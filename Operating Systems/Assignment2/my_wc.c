/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 10/25/2019
	Name: Assignment 2 - my_wc.c
	Description: my_wc reads text file
	as specified by the user, counts the
	number of lines, words, and
	characters within the files based on
	the options (or the lack thereof),
	and prints out the values of each
	file on a single line, with each
	value separated by a single white
	space. The name of that file is
	printed out at the end of that line,
	separated by a single white space.
\**************************************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>


int main(int argc, char *argv[]){

    if(argc >= 2){
        bool print_lines = false,
             print_words = false,
             print_chars = false;

        int index = 1;
        for(int i = 1; i < argc; ++i){
            if(strcmp(argv[i], "-l") == 0){
                print_lines = true;
                index++;
            }
            if(strcmp(argv[i], "-w") == 0){
                print_words = true;
                index++;
            }
            if(strcmp(argv[i], "-c") == 0){
                print_chars = true;
                index++;
            }
        }

        if(!print_lines && !print_words && !print_chars){
            print_lines = true;
            print_words = true;
            print_chars = true;
        }

        for(int i = 1; i < argc; ++i){
            char *filename = argv[i];
            FILE *file = fopen(filename,"r");

            if(!file){
                printf("my_wc: cannot open file\n");
                exit(1);
            }
            else{
                int words = 0;
                int chars = 0;
                int lines = 0;
                char prev = ' ', curr;

                while((fscanf(file,"%c", &curr)) != EOF){
                    chars++;
                    if(curr == '\n')
                        lines++;
                    if(isspace(curr) && !isspace(prev))
                        words++;
                    prev = curr;
                }
                fclose(file);

                if(print_lines){
                    printf("%d ", lines);
                }
                if(print_words){
                    printf("%d ", words);
                }
                if(print_chars){
                    printf("%d ", chars);
                }
                printf("%s\n", filename);
            }
        }
    }
    else{
        printf("my_wc: [option ...] [file ...]\n");
        exit(1);
    }
    return 0;
}
