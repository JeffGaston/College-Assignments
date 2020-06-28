/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 10/25/2019
	Name: Assignment 2 - my_grep.c
	Description: my_grep is always
	passed a search term and zero or
	more files to grep through (thus,
    more than one is possible). It
    should go through each line and see
    if the search term is in it; if so,
    the line should be printed, and if
    not, the line should be skipped.
\**************************************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define MAXLINE 1024

int main(int argc, char *argv[]){
  // If no arguments are passed, print and exit.
  if (argc <= 1){
    printf("my_grep: searchterm [file ...]\n");
    exit(1);
  }

  char *term = argv[1];
  char buffer[MAXLINE];
  char *line = NULL;

  if (argc < 3){
    while (fgets(buffer, MAXLINE, stdin) != NULL){
      if (strstr(buffer, term) != NULL){
        printf("%s", buffer);
      }
    }
  }
  else {
    for (int i = 2; i < argc; ++i){
      char *filename = argv[i];
      size_t length = 0;
      ssize_t read;
      FILE *file = fopen(filename, "r");

      if (!file){
        printf("my_grep: cannot open file\n");
        exit(1);
      }

      while ((read = getline(&line, &length, file)) != -1){
        if(strstr(line, term) != NULL){
          printf("%s", line);
        }
      }

      fclose(file);
    }
  }

  return 0;
}
