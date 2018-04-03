
/* Exemplo de criação de Registros e Ponteiros */

#include<stdio.h>
#include<stdlib.h> // Para uso da função malloc

struct Ponto{
   int x, y;
};

typedef struct Ponto Ponto;

int main(){

   // Declaração de ponteiro para Registros Ponto
   Ponto* ponteiroPonto;

   // Atribuição do endereço da área de memória alocada para o ponteiro
   ponteiroPonto = (Ponto*) malloc(sizeof(Ponto));

   if (ponteiroPonto == NULL){
        printf("\a\n Erro na alocacao de memoria!\n");
        return -1;
   }

   // Atribuição de valores através do operador de membro do ponteiro
   ponteiroPonto->x = 10;
   ponteiroPonto->y = 20;

   printf("\n Valores do Ponto = (%d,%d)\n", ponteiroPonto->x, ponteiroPonto->y);

   // Libera a memória alocada
   free(ponteiroPonto);

   return 0;
}
