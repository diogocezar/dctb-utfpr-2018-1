/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de um Registro de Nomes e Idades
*/

#include <stdio.h>

typedef struct Ages{
	char name[50];
	int age;
} typeAges;

void readAges(typeAges * ages, int size){
	int i;
	for(i=0; i<size; i++){
		printf("Digite o nome [%d]: \n", i+1);
		scanf("%s", ages[i].name);
		printf("Digite a idade [%d]: \n", i+1);
		scanf("%d", &ages[i].age);
	}
}

void printAges(typeAges ages[], int size){
	int i;
	printf("============================\n");
	for(i=0; i<size; i++){
		printf("\nNome : %s \n", ages[i].name);
		printf("Idade : %d \n", ages[i].age);
		printf("============================");
	}
}

int main(){
	typeAges ages[3];
	readAges(ages, 3);
	printAges(ages, 3);
	return 0;
}
