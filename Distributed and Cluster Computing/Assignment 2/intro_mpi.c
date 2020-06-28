/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 9/25/2019
	Name: Assignment 2 - intro_mpi.c
\**************************************/

#include <mpi.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv) {
  int size, my_rank, i, buffer, fromProc0, fromOne, fromOneSum;
  int tag = 0;
  int arrayZero[16];
  int fromArray[2];
  int arrayOne[16];
    
  MPI_Init(&argc, &argv);
  MPI_Status status;
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
  
  if(my_rank == 0){
      srand(time(0));
      
      printf("arrayZero values: ");
      for(i = 0; i < 16 ; i++){
         arrayZero[i] = (rand() % 1000);
         printf("%d  ",arrayZero[i]);
      }
      printf("\n");
      MPI_Send(&arrayZero[1], 1, MPI_INT, 1, tag, MPI_COMM_WORLD);
      printf("Process %i sent %d to process 1.", my_rank, arrayZero[1]);
  }
  if(my_rank == 1){
      MPI_Recv(&fromProc0, 1, MPI_INT, 0, tag, MPI_COMM_WORLD, &status);
      printf("Process %d has received %d from process 0.\n", my_rank, fromProc0);
      fromOne = fromProc0;
  }
  
  MPI_Bcast(&fromOne, 1, MPI_INT, 1, MPI_COMM_WORLD);
  printf("Process %i received %d from process 1.\n", my_rank, fromOne);
  fromOneSum = my_rank;
  
  MPI_Reduce(&fromOne, &fromOneSum, 1, MPI_INT, MPI_SUM, 2, MPI_COMM_WORLD);
  if(my_rank == 2){
      printf("The toal sum from the 'fromOne' variable at processes %d is %d \n", my_rank, fromOneSum);
  }
  
  MPI_Scatter(&arrayZero, 2, MPI_INT, &fromArray, 2, MPI_INT, 0, MPI_COMM_WORLD);
  printf("Process 0 scattered %d and %d to process %d\n", fromArray[0],fromArray[1], my_rank);
  
  MPI_Gather(&fromArray, 2, MPI_INT, &arrayOne, 2, MPI_INT, 0, MPI_COMM_WORLD);
  if(my_rank == 0){
      printf("Process %d has arrayZero values of: ", my_rank);
      for(i = 0; i < 16; i++){
          printf("%d ", arrayZero[i]);
      }
      printf("\nProcess %d has arrayOne values of: ", my_rank);
      for(i = 0; i < 16; i++){
          printf("%d ", arrayOne[i]);
      }
      printf("\n");
  }
  
  /* Finalize the MPI environment. */
  MPI_Finalize();
  return 0;
}