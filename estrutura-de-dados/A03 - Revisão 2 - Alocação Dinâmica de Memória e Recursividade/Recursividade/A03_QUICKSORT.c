/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Método de ordenação recursiva QuickSort!
*/

#include <stdio.h>

void quickSort(int * vet, int start, int end);
void printVet(int * vet);

int main(){

	int vet[10] = {7, 9, 4, 3, 6, 1, 18, 2, 10, 5};
	int i;

	printf("Vetor desordenado:\n");
	printVet(vet);

	quickSort(vet, 0, 9);

	printf("Vetor ordenado:\n");
	printVet(vet);

}

void printVet(int * vet){
	int i;
	for(i = 0; i < 10; i++){
		printf("%d ", vet[i]);
	}
	printf("\n");
}

void quickSort(int * vet, int start, int end){
	int pivo, aux, i, j, middle;

	i = start;
	j = end;

	middle = (int) ((i + j) / 2);
	pivo = vet[middle];
	do{
		while (vet[i] < pivo) i = i + 1;
		while (vet[j] > pivo) j = j - 1;

		if(i <= j){
			aux = vet[i];
			vet[i] = vet[j];
			vet[j] = aux;
			i = i + 1;
			j = j - 1;
		}
	}while(j > i);
	if(start < j) quickSort(vet, start, j);
	if(i < end) quickSort(vet, i, end);
}