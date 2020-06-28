/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 9/25/2019
	Name: Assignment 1 - sort.c
\**************************************/

#include <stdio.h>
#include <stdlib.h>

int comp(const void *a, const void *b){
    return (*(int *)a - *(int *)b);
}
int main(int argc, char *argv[]){
	FILE *fPointer;
	char *pointer = argv[1];
	fPointer = fopen(pointer, "r");
	int num1;
	int array_Size = 0;

	while(fscanf(fPointer, "%d", &num1) == 1){
        array_Size++;
	}

	fclose(fPointer);
	fopen(pointer, "r");

	int arr[array_Size];
	for(int i = 0; i < array_Size; i++){
        fscanf(fPointer, "%d", &arr[i]);
	}
	fclose(fPointer);

	qsort(arr, array_Size, sizeof(int), comp);

	for(int a = 0; a < array_Size - 1; a++){
        printf("%d ", arr[a]);
	}
	printf("%d\n", arr[array_Size - 1]);

	return 0;
}
