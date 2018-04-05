#include<stdio.h>
#include<stdlib.h>

struct Youtubers{
   char name[50];
   int views;
   int subscribers;
};

typedef struct Youtubers Youtubers;

void read_yt(Youtubers * yt, int qtd){
	int i;
	for(i=0; i<qtd; i++){
		printf("Digite o nome [%d]", i+1);
		scanf(" %s", yt[i].name);
		printf("Digite a qtd de views [%d]", i+1);
		scanf("%d", &yt[i].views);
		printf("Digite a qtd de inscritos [%d]", i+1);
		scanf("%d", &yt[i].subscribers);
	}
}

void write_yt(Youtubers * yt, int qtd){
	int i;
	for(i=0; i<qtd; i++){
		printf("%s\t%d\t%d\n", yt[i].name, yt[i].views, yt[i].subscribers);
	}
}

int main(){

   Youtubers* yt;
   int qtd, ii;

   printf("\n Quantos youtubers voce quer ler? ");
   scanf("%d", &qtd);

   if (qtd <= 0){
       printf("\a\n Quantidade nao pode ser menor ou igual a zero!\n");
       return -1;
   }

   yt = (Youtubers*) malloc(qtd * sizeof(Youtubers));

   if (yt == NULL){
       printf("\a\n Erro na alocacao de memoria!\n");
       return -2;
   }

   read_yt(yt, qtd);
   write_yt(yt, qtd);

   return 0;
}