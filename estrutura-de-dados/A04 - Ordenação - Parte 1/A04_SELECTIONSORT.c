#include <stdio.h>

/**
  * Exemplo de Implementação do Método de Ordenação SelectionSort
  * Diogo Cezar <diogo@diogocezar.com>
  */


/**
  * Ordenação pelo método SelectionSort
  */
void selectionSort(int n, int v[]){
    int i, j, min, aux;
    for(i=0; i<n-1; i++){
        min = i;
        for(j=i+1; j<n; j++){
            if(v[j] < v[min]){
                min = j;
            }
        }
        aux = v[i];
        v[i] = v[min];
        v[min] = aux;
    }
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
    int v[7] = {80,12,1,5,18,20,3};
    printf("Vetor original:\n");
    printVet(7, v);
    selectionSort(7, v);
    printf("Vetor ordenado:\n");
    printVet(7, v);
}