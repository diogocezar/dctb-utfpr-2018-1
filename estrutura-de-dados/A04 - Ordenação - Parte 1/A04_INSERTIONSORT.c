#include <stdio.h>

/**
  * Exemplo de Implementação do Método de Ordenação InsertionSort
  * Diogo Cezar <diogo@diogocezar.com>
  */

/**
  * Ordenação pelo método InsertionSort
  */
void insertionSort(int n, int v[]){
    int i;
    int j;
    int pivo;
    for(i=1; i<n; i++){
        pivo = v[i];
        j = i-1;
        while(j >= 0 && v[j] > pivo){
            v[j+1] = v[j];
            j--;
        }
        v[j+1] = pivo;
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
    insertionSort(7, v);
    printf("Vetor ordenado:\n");
    printVet(7, v);
}