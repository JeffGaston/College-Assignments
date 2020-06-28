/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 9/25/2019
	Name: Assignment 3 - heat_mpi_parallel.c
\**************************************/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <unistd.h>
#include <mpi.h>

#define COLS 1000
#define ROWS 1000

#define WHITE    "15 15 15 "
#define RED      "15 00 00 "
#define ORANGE   "15 05 00 "
#define YELLOW   "15 10 00 "
#define LTGREEN  "00 13 00 "
#define GREEN    "05 10 00 "
#define LTBLUE   "00 05 10 "
#define BLUE     "00 00 10 "
#define DARKTEAL "00 05 05 "
#define BROWN    "03 03 00 "
#define BLACK    "00 00 00 "

void copyNewToOld(float *new, float *old, int width, int height)
{
   
    memcpy(old, new, width*height*sizeof(float));
}

void calculateNew(float *new, float *old, int width, int height)
{
    int i,j;
  
    for (j = 1; j < height-1; j++)
    {
     
        new += width;
        old += width;
       
        for (i = 1; i < width-1; i++)
        {
    
            new[i] = (old[i-1] + old[i+1] + old[i-width] + old[i+width]) / 4;
        }
    }
}

void printGridtoFile(float *grid, int width, int height)
{

    FILE *fp = fopen("c.pnm", "w");
    
    int i,j;
    
    fprintf(fp, "P3\n%d %d\n15\n", width-2, height);
    for (j = 0; j < height; j++)
    {
        for (i = 1; i < width-1; i++)
        {
      
            float c = grid[i];
         
            if (c > 250.0)
                fprintf(fp, "%s ", RED );
            else if (c > 180.0)
                fprintf(fp, "%s ", ORANGE );
            else if (c > 120.0)
                fprintf(fp, "%s ", YELLOW );
            else if (c > 80.0)
                fprintf(fp, "%s ", LTGREEN );
            else if (c > 60.0)
                fprintf(fp, "%s ", GREEN );
            else if (c > 50.0)
                fprintf(fp, "%s ", LTBLUE );
            else if (c > 40.0)
                fprintf(fp, "%s ", BLUE );
            else if (c > 30.0)
                fprintf(fp, "%s ", DARKTEAL );
            else if (c > 20.0)
                fprintf(fp, "%s ", BROWN );
            else
                fprintf(fp, "%s ", BLACK );
        }
        fprintf(fp, "\n");
      
        grid += width;
    }
    fclose(fp);
}

int main(int argc, char **argv)
{
    if(argc != 2){
        printf("Usage: ./program <number of timestamps>\n");
        exit(0);
    }
    int i;
    
    MPI_Init(&argc, &argv);
    
    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    
    int cycles = atoi(argv[1]);
    int width = ROWS;
    int height = COLS;
   
    int slice_height = height*(rank+1)/size - height*rank/size;
  
    float *temps = (float *)malloc(width*(slice_height+2)*sizeof(float));
    float *old = (float *)malloc(width*(slice_height+2)*sizeof(float));
   
    for (i = 0; i < width*(slice_height+2); i++)
        temps[i] = 20.0;
   
    if (rank == 0)
        for (i = width*3/10+1; i < width*7/10+1; i++)
            temps[i] = 300.0;

   
    for (; cycles > 0; cycles--)
    {
       
        if (rank < size-1)
            MPI_Send(temps + width*slice_height, width, MPI_FLOAT, rank+1, 0, MPI_COMM_WORLD);
        if (rank > 0)
        {
          
            MPI_Recv(temps, width, MPI_FLOAT, rank-1, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
           
            MPI_Send(temps + width, width, MPI_FLOAT, rank-1, 1, MPI_COMM_WORLD);
        }
     
        if (rank < size-1)
            MPI_Recv(temps + width*(slice_height+1), width, MPI_FLOAT, rank+1, 1, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
        
        copyNewToOld(temps, old, width, slice_height+2);
        calculateNew(temps, old, width, slice_height+2);
    }
    
    float *results = NULL;
    int *sizes = NULL;
    int *displacements = NULL;
    if (rank == 0)
    {
       
        results = (float *)malloc(width*height*sizeof(float));
       
        displacements = (int *)malloc(size*sizeof(int));
        sizes = (int *)malloc(size*sizeof(int));
       
        displacements[0] = 0;
        for (i = 1; i <= size; i++)
        {
            int next = (height*i/size) * width;
            if (i < size)
                displacements[i] = next;
            sizes[i-1] = next - displacements[i-1];
        }
    }
    
    MPI_Gatherv(temps + width, slice_height*width, MPI_FLOAT, results, sizes, displacements, MPI_FLOAT, 0, MPI_COMM_WORLD);
    
    if (rank == 0){
        printGridtoFile(results, width, height);
        system("convert c.pnm c.png");
    }
    
    free(temps);
    free(old);
    free(sizes);
    free(displacements);
    free(results);

    MPI_Finalize();
    return 0;
}