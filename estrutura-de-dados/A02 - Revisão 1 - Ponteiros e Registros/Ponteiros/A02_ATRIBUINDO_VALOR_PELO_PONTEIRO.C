
/* Exemplo de ponteiros */

#include<stdio.h>
#include<stdlib.h>

int main(){

    int  idade = 0;

    // Constante que indica que o ponteiro não tem valor
    int* pontInt = NULL;

    printf("\n Valor inicial da variavel int ...: %d", idade);
    printf("\n Endereco inicial da variavel int : %p", &idade);

    printf("\n\n Valor inicial do ponteiro (NULL).: %p", pontInt);

    pontInt = &idade;

    printf("\n\n Novo valor do ponteiro ..........: %p", pontInt);

    // Atribui valor na area apontada pelo ponteiro

    *pontInt = 100;

    printf("\n\n Novo valor da variavel int ......: %d", idade);
    printf("\n Novo valor apontado pelo ponteiro: %d\n", *pontInt);

    return 0;
}
