
/* Exemplo de criação de Registros e Ponteiros */

#include<stdio.h>
#include<stdlib.h> // Para uso da função malloc

struct Ponto{
   int x, y;
};

typedef struct Ponto Ponto;

int main(){

   // Declaração de ponteiro para Registros Ponto
   Ponto* pontos;
   int    quantidade, indice;

   printf("\n Quantos pontos voce quer ler? ");
   scanf("%d", &quantidade);

   if (quantidade <= 0){
       printf("\a\n Quantidade nao pode ser menor ou igual a zero!\n");
       return -1;
   }

   /* Atribuição do endereço da área de memória alocada para o ponteiro
      Como é alocada uma quantidade de pontos, na prática é um vetor dinâmico */

   pontos = (Ponto*) malloc(quantidade * sizeof(Ponto));

   if (pontos == NULL){
       printf("\a\n Erro na alocacao de memoria!\n");
       return -2;
   }

   for (indice = 0; indice < quantidade; indice++){
       printf("\n Ponto %d - Entre com o valor x: ", indice + 1);
       scanf("%d", &pontos[indice].x);
       printf(" Ponto %d - Entre com o valor y: ", indice + 1);
       scanf("%d", &pontos[indice].y);
   }

   printf("\n Impressao dos valores");
   printf("\n =====================\n\n");

   for (indice = 0; indice < quantidade; indice++){
      printf(" Valores do Ponto %d = (%d,%d)\n", indice+1, pontos[indice].x, pontos[indice].y);
   }

   // Libera a memória alocada
   free(pontos);

   return 0;
}
