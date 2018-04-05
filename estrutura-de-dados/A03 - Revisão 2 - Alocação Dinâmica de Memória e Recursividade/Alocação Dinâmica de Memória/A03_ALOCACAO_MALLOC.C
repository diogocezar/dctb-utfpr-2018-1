#include<stdio.h>
#include<stdlib.h>

int main(){
	int* pontInt;
	pontInt = (int*) malloc(sizeof(int));
	if (pontInt == NULL){
		printf("\a\n Erro na alocacao de memoria!\n");
		return -1;
	}
	printf("\n Alocacao realizada com sucesso!");
	printf("\n Endereco armazenado no ponteiro: %p\n\n", pontInt);
	printf(" Entre com um numero inteiro: ");
	scanf("%d", pontInt);
	printf("\n Valor armazenado %d\n", *pontInt);
	// Libera a memória alocada
	free(pontInt);
	return 0;
}