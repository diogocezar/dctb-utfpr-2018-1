
#include<stdio.h>
#include<stdlib.h>

int main(){

   int   quantLinhas, quantColunas, indiceLinha, indiceColuna;
   int** pontInt; // Ponteiro de ponteiros de int

   printf("\n Quantidade linhas.: ");
   scanf("%d", &quantLinhas);

   if (quantLinhas <= 0){
       printf("\a\n Quantidade de linhas nao pode ser menor ou igual a zero!\n");
       return -1;
   }

   /* Atribuição do endereço da área de memória alocada para o ponteiro de ponteiros */

   pontInt = (int**) malloc(quantLinhas * sizeof(int*)); //tamanho de ponteiro de int

   if (pontInt == NULL){
       printf("\a\n Erro na alocacao de memoria para as linhas!\n");
       return -2;
   }

   printf(" Quantidade Colunas: ");
   scanf("%d", &quantColunas);

   if (quantColunas <= 0){
       printf("\a\n Quantidade de colunas nao pode ser menor ou igual a zero!\n");
       return -3;
   }

   for (indiceLinha = 0; indiceLinha < quantLinhas; indiceLinha++){

        *(pontInt + indiceLinha) = (int*) malloc(quantColunas * sizeof(int)); // tamanho de int

        if (*(pontInt + indiceLinha) == NULL){
            printf("\a\n Erro na alocacao das colunas da linha %d!\n", indiceLinha);
            return -3;
        }
   }

   printf("\n Alocacao realizada com sucesso!");
   printf("\n Endereco armazenado no ponteiro: %p\n\n", pontInt);

   for (indiceLinha = 0; indiceLinha < quantLinhas; indiceLinha++){
        for (indiceColuna = 0; indiceColuna < quantColunas; indiceColuna++){
           printf(" Entre com inteiro [%d][%d]: ", indiceLinha, indiceColuna);
           scanf("%d", *(pontInt + indiceLinha) + indiceColuna);
        }
   }

   printf("\n Impressao dos valores");
   printf("\n =====================\n\n ");

   for (indiceLinha = 0; indiceLinha < quantLinhas; indiceLinha++){
        for (indiceColuna = 0; indiceColuna < quantColunas; indiceColuna++){
            printf("%d\t", *(*(pontInt + indiceLinha) + indiceColuna));
        }
        printf("\n ");
   }

   // Libera a memória alocada para cada linha
   for (indiceLinha = 0; indiceLinha < quantLinhas; indiceLinha++){
        free(pontInt + indiceLinha);
   }

   free(pontInt); // Libera a memória alocada para o vetor de linhas

   return 0;
}
