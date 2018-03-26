
/* Exemplo de ponteiros */

#include<stdio.h>

int main(){

    float salario, *pontFloat;

    pontFloat = &salario;

    printf("\n Entre com o salario: ");
    scanf("%f", pontFloat);

    printf("\n Valor armazenado na variavel float: %.2f",    salario);
    printf("\n Valor apontando pelo ponteiro ....: %.2f\n", *pontFloat);

    return 0;
}
