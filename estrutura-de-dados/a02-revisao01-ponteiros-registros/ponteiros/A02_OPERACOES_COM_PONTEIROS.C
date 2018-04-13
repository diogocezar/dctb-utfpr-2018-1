
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    int numeros[5], *pontInt, indice;

    printf("\n\n Entrada de Dados");
    printf("\n ================\n\n");

    for (indice = 0; indice < 5; indice++){
        printf(" Endereco a ser usado [%d],", numeros + indice);
        printf(" Entre com o numero %d: ",   indice + 1);
        scanf("%d", numeros + indice); // numeros é o ponteiro com o endereço do primeiro elemento do vetor
    }

    printf("\n Listagem dos Valores");
    printf("\n ====================\n\n");

    for (indice = 0; indice < 5; indice++){
        printf(" %d - [%d]\n", indice + 1, *(numeros + indice));
    }

    return 0;
}

