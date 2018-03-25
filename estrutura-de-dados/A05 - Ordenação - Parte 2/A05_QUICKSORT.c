#include <stdio.h>

/**
  * Exemplo de Implementação do Método de Ordenação QuickSort
  * Diogo Cezar <diogo@diogocezar.com>
  */

/**
  * Demonstração do partition
  */

void swapItems(int dex1, int dex2, int v[]){
	int temp = v[dex1];
	v[dex1] = v[dex2];
	v[dex2] = temp;
}

void partition(int left, int right, int pivot, int v[]){
    int leftPtr = left - 1;
    int rightPtr = right + 1;
    while(1==1){
        while(v[++leftPtr] < pivot && leftPtr < right){}
        while(v[--rightPtr] > pivot && rightPtr > left){}
        if(leftPtr >= rightPtr){
            break;
        }
        else{
            swapItems(leftPtr, rightPtr, v);
        }
    }
}

/**
  * Ordenação QuickSort
  */

void quickSort(int start, int end, int vet[]){
	int pivo, aux, i, j, middle;
	i = start;
	j = end;
	middle = (int) ((i + j) / 2);
	pivo  = vet[middle];
    /* Aqui inicia o algoritmo partition, poderia estar em outra função */
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
    /* Fim do Partition */
	if(start < j) quickSort(start, j, vet);
	if(i < end) quickSort(i, end, vet);
}

/**
  * Impressão de um vetor
  */
void printVet(int n, int v[]){
    int j;
    for(j = 0; j<n ; j++){
        printf("[%d] ", v[j]);
    }
    printf("\n");
}

/**
  * Função Principal
  */
int main(){
    int v1[7] = {80,12,1,5,18,20,3};
    int v2[7] = {80,12,1,5,18,20,3};
    printf("Vetor original V1:\n");
    printVet(7, v1);
    partition(0, 6, 18, v1);
    printf("Vetor com particionamento [18]:\n");
    printVet(7, v1);
    printf("Vetor original V2:\n");
    printVet(7, v2);
    quickSort(0, 6, v2);
    printf("Vetor ordenado com QuickSort:\n");
    printVet(7, v2);
}
