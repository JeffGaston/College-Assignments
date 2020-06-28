/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 9/25/2019
	Name: Assignment 1 - sum.c
\**************************************/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	FILE *fPointer;
	char *pointer = argv[1];
	fPointer = fopen(pointer, "r");
	int num_Array[10];
	int sum = 0;
	
	for(int i = 0; i < 10; i++){
		fscanf(fPointer, "%d", &num_Array[i]);
		sum += num_Array[i];
	}
	printf("%d\n", sum);
	fclose(fPointer);
	return 0;
}