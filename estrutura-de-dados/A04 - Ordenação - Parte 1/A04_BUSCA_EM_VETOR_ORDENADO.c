#include <stdio.h>

/**
  * Exemplos de Buscas em Vetores Ordenados
  * Diogo Cezar <diogo@diogocezar.com>
  */

/**
  * Uma busca sequencial, nada performática!
  */
int sequentialSearch(int x, int n, int v[]){
    int j;
    for(j = 0; (j<n && v[j]<x) ; j++){}
    return j;
}

/**
  * Uma busca binária, bem mais performática!
  */
int binarySearch(int x, int n, int v[]){
    int e = -1;
    int d = n;
    while(e < d-1){
        int m = (e + d)/2;
        if(v[m] < x)
            e = m;
        else
            d = m;
    }
    return d;
}

/**
  * Uma busca binária, recursiva!
  */
int recursiveBinarySearch(int x, int e, int d, int v[]){
    if(e == d-1) return d;
    else{
        int m = (e + d)/2;
        if(v[m] < x)
            return recursiveBinarySearch(x, m, d, v);
        else
            return recursiveBinarySearch(x, e, m, v);
    }
}

int main(){
    int v[7] = {1,2,30,45,88,90,101};
    printf("O elemento foi encontrado na posição: %d\n", sequentialSearch(30, 7, v));
    printf("O elemento foi encontrado na posição: %d\n", binarySearch(30, 7, v));
    printf("O elemento foi encontrado na posição: %d\n", recursiveBinarySearch(30, -1, 7, v));
}