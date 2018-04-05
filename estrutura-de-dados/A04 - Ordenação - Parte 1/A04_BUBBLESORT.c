#include <stdio.h>

/**
  * Exemplo de Implementação do Método de Ordenação BubbleSort
  * Diogo Cezar <diogo@diogocezar.com>
  */

/**
  * Ordenação pelo método BubbleSort
  */
void bubbleSort(int n, int v[]){
    int i;
    int j;
    int aux;
    for(i=0; i<n; i++){
        for(j=0; j<n-1; j++){
            if(v[j] > v[j+1]){
                aux = v[j];
                v[j] = v[j+1];
                v[j+1] = aux;
            }
        }
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
    bubbleSort(7, v);
    printf("Vetor ordenado:\n");
    printVet(7, v);
}