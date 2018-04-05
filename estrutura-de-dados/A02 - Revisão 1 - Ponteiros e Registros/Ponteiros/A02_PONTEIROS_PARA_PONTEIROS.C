
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    char letra = 'A';
    char *pontChar;
    char **pontPontChar;

    printf("\n Valor inicial da variavel char, simbolo = %c, codigo = %d",letra,letra);

    pontChar     = &letra;
    pontPontChar = &pontChar;

    // Atribui um valor a area de memoria apontada pelo ponteiro apontado

    **pontPontChar = 'Z';

    printf("\n\n      **pontPontChar = \'Z\'");

    printf("\n\n Variavel                      Endereco\tValor");
    printf("\n ==============================================");
    printf("\n char .......................: %p\t%d",&letra,       letra);
    printf("\n Ponteiro de char ...........: %p\t%p",&pontChar,    pontChar);
    printf("\n Ponteiro de ponteiro de char: %p\t%p",&pontPontChar,pontPontChar);

    printf("\n\n Simbolo do valor atual da variavel char = %c\n",letra);

    return 0;
}
