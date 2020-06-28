/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 10/25/2019
	Name: Assignment 2 - my_cat.c
	Description: my_cat reads a text
	file as specified by the user and
	prints its contents exactly as is.
\**************************************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
    if(argc >= 2){
        for (int i = 1; i < argc; ++i){
            char *filename = argv[i];
            FILE *file = fopen ( filename, "r" );
            if (file != NULL ){
                char line [ 128 ];
                while ( fgets ( line, sizeof line, file ) != NULL ){
                    fputs ( line, stdout );
                }
                fclose ( file );
            }
            else{
                printf("my_cat: cannot open file\n");
                exit(1);
            }
        }
    }
    return 0;
}
