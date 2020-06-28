/**************************************\
	Name: Jeff Gaston
	Github: github.com/JeffGaston
	Date: 9/25/2019
	Name: Assignment 1 - payroll.c
\**************************************/

#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]){
	int hours_worked = atoi(argv[3]);
	double hourly_rate = atof(argv[4]);
	double total_payment = (hours_worked * hourly_rate);

	printf("%s, %s: %.2lf\n", argv[2], argv[1], total_payment);
	return 0;
}
