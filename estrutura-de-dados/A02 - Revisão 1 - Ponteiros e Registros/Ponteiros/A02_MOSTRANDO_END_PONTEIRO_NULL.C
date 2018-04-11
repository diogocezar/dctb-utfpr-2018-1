
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

    printf("\n\n Novo valor do ponteiro ..........: %p\n", pontInt);

    return 0;
}
