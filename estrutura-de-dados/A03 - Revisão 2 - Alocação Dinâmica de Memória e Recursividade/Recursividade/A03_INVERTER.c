/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: faça uma função recursiva que permita inverter um número inteiro N.
*/

#include <stdio.h>

int normalize(int number){
	if(number < 0)
		return number *= -1;
	else
		return number;
}

void normal(int number){
	int last;
	do{
		last = number % 10;
		printf("%d", last);
		number /= 10;
	} while(number != 0);
}void normal(int number){
	int last;
	do{
		last = number % 10;
		printf("%d", last);
		number /= 10;
	} while(number != 0);
}

void recursive(int number){
	int last;
	if(number != 0){
		last = number % 10;
		printf("%d", last);
		number /= 10;
		recursive(number);
	}
}

int main(){
	int number;
	printf("Digite um número inteiro:\n");
	scanf("%d", &number);
	number = normalize(number);
	printf("Forma normal:\n");
	normal(number);
	printf("\nForma recursiva:\n");
	recursive(number);
	printf("\n");
	return 0;
}