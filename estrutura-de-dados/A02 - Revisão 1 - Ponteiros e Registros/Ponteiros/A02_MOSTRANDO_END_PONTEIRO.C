
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    int  idade;
    int* pontInt;

    printf("\n Valor inicial da variavel int ...: %d", idade);
    printf("\n Endereco inicial da variavel int : %p", &idade);

    printf("\n\n Valor inicial do ponteiro .......: %p", pontInt);

    pontInt = &idade;

    printf("\n\n Novo valor do ponteiro ..........: %p\n", pontInt);

    return 0;
}
