
/* Exemplo de ponteiros */

#include<stdio.h>

typedef struct myStruct{
	int a;
	int b;
	int c;
} typeMyStruct;

int main(){

    printf("\n Tamanho da variavel int .......: %lu Bytes",   sizeof(int));
    printf("\n Tamanho do ponteiro para int...: %lu Bytes\n", sizeof(int*));

    printf("\n Tamanho da variavel double ....: %lu Bytes",   sizeof(double));
    printf("\n Tamanho do ponteiro para double: %lu Bytes\n", sizeof(double*));

    printf("\n Tamanho da variavel char ......: %lu Bytes",   sizeof(char));
    printf("\n Tamanho do ponteiro para char..: %lu Bytes\n", sizeof(char*));

    printf("\n Tamanho da variavel myStruct ......: %lu Bytes",   sizeof(typeMyStruct));
    printf("\n Tamanho do ponteiro para myStruct..: %lu Bytes\n", sizeof(typeMyStruct*));

    return 0;
}
