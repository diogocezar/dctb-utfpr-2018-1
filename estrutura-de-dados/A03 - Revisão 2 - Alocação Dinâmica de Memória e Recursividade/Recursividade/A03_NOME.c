/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: faça uma função recursiva que imprima seu nome n vezes;
*/

#include <stdio.h>

void normal(int number, char * name){
	int i;
	for(i=0; i<number; i++)
		printf("%s\n", name);
}

void recursive(int number, char * name){
	if(number == 0)
		return;
	else{
		printf("%s\n", name);
		recursive(number-1, name);
	}
}

int main(){
	int number;
	char name[50];
	printf("Digite o seu nome:\n");
	scanf(" %s", name);
	printf("Digite quantas vezes será exibido:\n");
	scanf("%d", &number);
	printf("Forma normal:\n");
	normal(number, name);
	printf("\nForma recursiva:\n");
	recursive(number, name);
	printf("\n");
	return 0;
}