
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    int p = 10;
    int * pt;

    // Incrementa um inteiro comum

    p++;
	printf("Endereço de \t\t %p\n", pt);
    printf("Valor de pt \t\t %d\n", *pt);

    pt = &p;

    printf("Endereço de \t\t %p\n", pt);
    printf("Valor de pt \t\t %d\n", *pt);

    // Incrementa o valor que pt aponta

    (*pt)++;

	printf("Endereço de \t\t %p\n", pt);
    printf("Valor de pt \t\t %d\n", *pt);

    // Incrementa o próprio ponteiro

    //*(pt++);
    pt++;

	printf("Endereço de \t\t %p\n", pt);
    printf("Valor de pt \t\t %d\n", *pt);


    return 0;
}
