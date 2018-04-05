
/* Exemplo de ponteiros */

#include <stdio.h>

#define SIZE 5

void printVector(int * vet){
	int i;
	for(i=0; i<SIZE; i++)
		printf("Posição [%d] => [%d]\n", i+1, vet[i]);
	printf("=========================\n");
}

void printMat(int mat[][SIZE]){
	int i,j;
	for(i=0; i<SIZE; i++)
		for(j=0; j<SIZE; j++)
			printf("Posição [%d][%d] => [%d]\n", i+1, j+1, mat[i][j]);
	printf("=========================\n");
}


void fillNormal(int * vet){
	int i;
	for(i=0; i<SIZE; i++)
		vet[i] = i+10;
}

void fillPointer(int * vet){
	int i, *p;
	p = vet;
	for(i=0; i<SIZE; i++){
		*p = i+5;
		p++;
	}
}

void fillPointerMat(int mat[][SIZE]){
	int i, *p;
	p = mat[0];
	for(i=0; i<(SIZE*SIZE); i++){
		*p = i+5;
		p++;
	}
}

int main(){
	int vet[SIZE];
	int mat[SIZE][SIZE];
	printf("\nVetor:\n\n");
	printf("Preenchido normalmente: \n");
	fillNormal(vet);
	printVector(vet);
	printf("Preenchido com ponteiro: \n");
	fillPointer(vet);
	printVector(vet);
	printf("\nMatriz:\n\n");
	fillPointerMat(mat);
	printMat(mat);
}