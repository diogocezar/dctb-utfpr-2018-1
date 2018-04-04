/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: uma função recursiva rec_1 e rec_2 são iguais e recebem como parâmetro um inteiro, utilize a chamada da recursividade antes e depois da impressão para verificar suas diferenças;
*/

#include <stdio.h>

void rec_1(int number){
	if(number == 0)
		printf("fim\n");
	else{
		printf("%d\n", number);
		rec_1(number-1);
	}
}

void rec_2(int number){
	if(number == 0)
		printf("fim\n");
	else{
		rec_2(number-1);
		printf("%d\n", number);
	}
}

int main(){
	printf("Forma recursiva 1:\n");
	rec_1(5);
	printf("Forma recursiva 2:\n");
	rec_2(5);
	printf("\n");
	return 0;
}