#include<stdio.h>
#include<stdlib.h>
int main(){
	int  quantidade, indice;
	int* pontInt;
	printf("\n Quantos inteiros quer armazenar? ");
	scanf("%d", &quantidade);
	if (quantidade <= 0){
		printf("\a\n Quantidade nao pode ser menor ou igual a zero!\n");
		return -1;
	}
	/*
		Atribuição do endereço da área de memória alocada para o ponteiro
		Como é alocada uma quantidade de int, na prática é um vetor dinâmico
	*/
	pontInt = (int*) malloc(quantidade * sizeof(int));
	if (pontInt == NULL){
		printf("\a\n Erro na alocacao de memoria!\n");
		return -2;
	}
	printf("\n Alocacao realizada com sucesso!");
	printf("\n Endereco armazenado no ponteiro: %p\n\n", pontInt);
	for (indice = 0; indice < quantidade; indice++){
		printf(" Entre com inteiro %d: ", indice + 1);
		scanf("%d", &pontInt[indice]);
	}
	printf("\n Impressao dos valores");
	printf("\n =====================\n\n");
	for (indice = 0; indice < quantidade; indice++){
		printf(" %d = %d\n", indice + 1, pontInt[indice]);
	}
	// Libera a memória alocada
	free(pontInt);
	return 0;
}