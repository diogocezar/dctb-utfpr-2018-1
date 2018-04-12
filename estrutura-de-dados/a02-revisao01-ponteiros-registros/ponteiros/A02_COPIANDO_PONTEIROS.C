
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    char  letra;
    char *pontChar1, *pontChar2;

    printf("\n Valor inicial da variavel char, simbolo = %c, codigo = %d",  letra, letra);

    pontChar1  = &letra;
    *pontChar1 = 88; // Podia ser *pontChar1 = 'X'

    printf("\n\n      pontChar1  = &letra");
    printf("\n      *pontChar1 = 88");

    printf("\n\n Valor atual da variavel char,   simbolo = %c, codigo = %d",letra, letra);

    // Copia o endereco de um ponteiro em outro

    pontChar2 = pontChar1;

    printf("\n\n      pontChar2 = pontChar1");

    printf("\n\n Endereco variavel char..........: %p", &letra);
    printf("\n Endereco armazenado no ponteiro1: %p", pontChar1);
    printf("\n Endereco armazenado no ponteiro2: %p", pontChar2);

    printf("\n\n Valor apontado pelo segundo ponteiro, simbolo = %c, codigo = %d\n", *pontChar2, *pontChar2);

    return 0;
}
