
/* Exemplo de criação de Registros e Ponteiros */

#include<stdio.h>

struct Ponto{
   int x, y;
};

typedef struct Ponto Ponto;

int main(){

   // Declaração de ponteiro para Registros Ponto
   Ponto* ponteiroPonto;

   // Declaração de variável do tipo Ponto
   Ponto  inicio;

   // Atribuição do endereço da variável para o ponteiro
   ponteiroPonto = &inicio;

   // Atribuição de valores através do operador de membro do ponteiro
   // Utilizar ponteiroPonto->x é o mesmo que fazer *(ponteiroPonto).x
   ponteiroPonto->x = 10;
   ponteiroPonto->y = 20;

   printf("\n Valores do Ponto = (%d,%d)\n", ponteiroPonto->x, ponteiroPonto->y);

   return 0;
}
