#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
int main(int argc, char *argv[]) {
  size_t bufferSize = 0;
  char *line = NULL; 
  char *command = NULL; 
  char* token;
  char **paths; 
  char *pathname;
  int pathCount = 1;
  int pathSet = 0; 
  char** myargs; 
  char** rargs; 
  char** pargs; 
  char** prargs; 
  FILE* stream; 

  if ((argc == 1) || (argc == 2)) {
      if (argc == 1) {
          printf("grsh> ");
          stream = stdin;
      }
      else if (argc == 2) {
          stream = fopen(argv[1], "r");
          if (stream == NULL) {
              char error_message[30] = "An error has occurred\n";
              write(STDERR_FILENO, error_message, strlen(error_message));
              exit(1);
          }
      }

      while (getline(&line, &bufferSize, stream) > 0) {
          command = (char *)calloc(1, (strlen(line)) + 1);
          token = strtok_r(line, " \n\t", &line);

          if (token == NULL) {
              free(command);
              if (argc == 1) {
                  printf("grsh> ");
              }
              continue;
          }

          strcat(command, token);
          int count = 1; 

          while ((token = strtok_r(line, " \n\t", &line))) {
              strcat(command, " ");
              strcat(command, token);
              count++;
          }

          if ((strcmp(command, "exit")) == 0) {
              int q;
              if (pathSet == 1) {
                  for (q = 0; q < pathCount; q++) {
                    free(paths[q]);
                  }//end for

                  free(paths);
              }

              free(command);
              exit(0);
          }

          int i;
          int redirectionCount = 0;
          int validRedirect = 0;
          int commandCount = 1;
          int validParallel = 0; 
          char* ctoken;
          myargs = (char **)calloc((count+1), (sizeof(char *)));
          rargs  = (char **)calloc((count-1), (sizeof(char *)));
          char *commandDup = (char *)calloc(1, (strlen(command)) + 1);
          strcpy(commandDup, command);

          for (i = 0; i < count; i++) {
            ctoken = strtok_r(commandDup, " ", &commandDup);
            myargs[i] = calloc((strlen(ctoken)) + 1, (sizeof(char)));
            strcpy(myargs[i], ctoken);
            if ((strcmp(myargs[i], ">")) == 0) {
                redirectionCount++;
            }
            else if ((strcmp(myargs[i], "&")) == 0) {
                commandCount++;
            }
          }

          myargs[count] = NULL;
          char *fname = myargs[count-1];

          if (pathSet == 0) {
              paths = (char**)calloc(pathCount, sizeof(char *));
              for (i = 0; i < pathCount; i++) {
                paths[i] = (char *)calloc(5, sizeof(char));
                strcpy(paths[i], "/bin");
              }
          }
          pathSet = 1;

          if (((strcmp(myargs[0], "&")) == 0)) {
              commandCount--;
          }

          int ampCount = commandCount - 1;
          int ampersandPositions[ampCount]; 
          int trailingAmp = 0;

          if ((redirectionCount == 1) && (count >= 3) && ((strcmp(myargs[count-2], ">")) == 0)) {
              validRedirect = 1;
              for (i = 0; i < (count-2); i++) {
                rargs[i] = myargs[i];
              }
              rargs[count-2] = NULL;
          }

          if (commandCount > 1) {
              if (((strcmp(myargs[count-1], "&")) == 0)) {
                  validParallel = 1;
                  commandCount--;
                  trailingAmp = 1;
              }

              if (((strcmp(myargs[0], "&")) != 0)) {

                  for (i = 1; i < (count-1); i++) {

                    if (((strcmp(myargs[i], "&")) == 0) && ((strcmp(myargs[i], myargs[i+1])) == 0)) {
                        validParallel = 0;
                        break;
                    }//end if
                    else {
                        validParallel = 1;
                    }
                  }
              }
              else {
                  validParallel = 0;
              }

              if (validParallel == 0) {
                  commandCount = 1;
              }
              
              else if (validParallel == 1) {
                  int j = 0;
                  for (i = 0; i < count; i++) {
                    if (((strcmp(myargs[i], "&")) == 0)) {
                        ampersandPositions[j] = i;
                        j++;
                    }
                  }
              }
          }

          if ((strcmp(myargs[0], "cd")) == 0) {
              if (count != 2) {
                  char error_message[30] = "An error has occurred\n";
                  write(STDERR_FILENO, error_message, strlen(error_message));
              }
              else {
                  int cd = chdir(myargs[1]);
                  if (cd != 0) {
                      char error_message[30] = "An error has occurred\n";
                      write(STDERR_FILENO, error_message, strlen(error_message));
                  }
              }
          }//end if
          else if ((strcmp(myargs[0], "path")) == 0) {
              for (i = 0; i < pathCount; i++) {
                free(paths[i]);
              }

              free(paths);

              pathCount = count - 1;
              paths = (char**)calloc(pathCount, sizeof(char *));
              for (i = 0; i < pathCount; i++) {
                paths[i] = (char *)calloc((strlen(myargs[i+1])) + 1, sizeof(char));
                strcpy(paths[i], myargs[i+1]);
              }
          }
          else {
              int success = 0; 

              if (validParallel == 0) {
                  for (i = 0; i < pathCount; i++) {
                    pathname = (char *)calloc(1, (strlen(paths[i])) + (strlen(myargs[0])) + 2);
                    strcat(pathname, paths[i]);
                    strcat(pathname, "/");
                    strcat(pathname, myargs[0]);

                    if ((access(pathname, X_OK)) == 0) {
                      success = 1;
                      int rc = fork();
                      if (rc < 0) {
                          char error_message[30] = "An error has occurred\n";
                          write(STDERR_FILENO, error_message, strlen(error_message));
                      }
                      else if (rc == 0) {
                          if (validRedirect == 0) {
                              execv(pathname, myargs);
                              printf("Tried to print, didn't come out though.");
                          }
                          else if (validRedirect == 1) {
                              freopen(fname, "w", stdout);
                              freopen(fname, "w", stderr);
                              execv(pathname, rargs);
                              printf("Uh, tried to print. Whatever.");
                          }
                      }
                      else {
                          wait(NULL);
                      }
                    }

                    free(pathname); //must be freed before pathname is has memory allocated on the next iteration
                  }//end for

                  if (success == 0) {
                      char error_message[30] = "An error has occurred\n";
                      write(STDERR_FILENO, error_message, strlen(error_message));
                  }
              }
              else if (validParallel == 1) {
                  int j; 
                  int k; 

                  for (i = 0; i < commandCount; i++) {
                    int psize; 
                    redirectionCount = 0;
                    validRedirect = 0;
                    success = 0;

                    if (i == 0) {
                         pargs = (char **)calloc(ampersandPositions[i] + 1, (sizeof(char *)));
                         psize = ampersandPositions[i] + 1;

                         for (j = 0; j < (psize-1); j++) {
                           pargs[j] = myargs[j];
                         }
                         pargs[psize-1] = NULL;
                    }

                    else if ((i < (commandCount-1)) || (trailingAmp == 1)) {
                        pargs = (char **)calloc((ampersandPositions[i])-(ampersandPositions[i-1]), (sizeof(char *)));
                        psize = (ampersandPositions[i])-(ampersandPositions[i-1]);

                        j++;
                        k = 0;

                        while (j < (ampersandPositions[i])) {
                            pargs[k] = myargs[j];
                            j++;
                            k++;
                        }
                        pargs[k] = NULL;
                    }

                    else {
                        pargs = (char **)calloc(count - (ampersandPositions[i-1]), (sizeof(char *)));
                        psize = count - (ampersandPositions[i-1]);

                        j++;
                        k = 0;

                        while (j < count) {
                            pargs[k] = myargs[j];
                            j++;
                            k++;
                        }
                        pargs[k] = NULL;
                    }

                    prargs  = (char **)calloc((psize-2), (sizeof(char *)));

                    //count number of >s
                    for (k = 0; k < (psize-1); k++) {
                      if ((strcmp(pargs[k], ">")) == 0) {
                          redirectionCount++;
                      }
                    }

                    char *pfname = pargs[psize-2];

                    if ((redirectionCount == 1) && (psize >= 4) && ((strcmp(pargs[psize-3], ">")) == 0)) {
                        validRedirect = 1;
                        for (k = 0; k < (psize-3); k++) {
                          prargs[k] = pargs[k];
                        }
                        prargs[psize-3] = NULL;
                    }

                    for (k = 0; k < pathCount; k++) {
                      pathname = (char *)calloc(1, (strlen(paths[k])) + (strlen(pargs[0])) + 2);
                      strcat(pathname, paths[k]);
                      strcat(pathname, "/");
                      strcat(pathname, pargs[0]);

                      if ((access(pathname, X_OK)) == 0) {
                          success = 1;
                          int rc = fork();
                          if (rc < 0) {
                              char error_message[30] = "An error has occurred\n";
                              write(STDERR_FILENO, error_message, strlen(error_message));
                          }
                          else if (rc == 0) {
                              if (validRedirect == 0) {
                                  execv(pathname, pargs);
                                  printf("Tried to print, didn't come out though.");
                              }
                              else if (validRedirect == 1) {
                                  freopen(pfname, "w", stdout);
                                  freopen(pfname, "w", stderr);
                                  execv(pathname, prargs);
                                  printf("Uh, tried to print. Whatever.");
                              }
                          }
                      }

                      free(pathname);
                    }

                    if (success == 0) {
                        char error_message[30] = "An error has occurred\n";
                        write(STDERR_FILENO, error_message, strlen(error_message));
                    }

                    free(pargs);
                    free(prargs);
                  }

                  for (i = 0; i < commandCount; i++) {
                    wait(NULL);
                  }
              }
          }

          free(command);

          for (i = 0; i < count; i++) {
            free(myargs[i]);
          }

          free(myargs);
          free(rargs);

          if (argc == 1) {
              printf("grsh> ");
          }
      }
  }

  else {
      printf("grsh: filename\n");
      exit(1);
  }

  return 0;
}