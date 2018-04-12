/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: demonstre a utilização recursividade múltipla;
*/

#include <stdio.h>

void multipla_1(int number){
	//printf("\tchamada com %d\n\n", number);
	if(number == 0)
		printf("fim\n");
	else{
		printf("%d\n", number);
		multipla_1(number-1);
		multipla_1(number-1);
	}
}

//		2
//			1
//				0 -> fim
//			0 -> fim
//		1
//			0 -> fim
//		0 -> fim

void multipla_2(int number){
	if(number == 0)
		printf("fim\n");
	else{
		multipla_2(number-1);
		multipla_2(number-1);
		printf("%d\n", number);
	}
}
/*
m(2);
	m(1);
		m(0);
			-> fim;
			-> return;
		m(0);
			-> fim;
			-> return;
		-> 1;
	m(1);
		m(0);
			-> fim;
			-> return;
		m(0);
			-> fim;
			-> return;
		-> 1;
-> 2;
*/

void multipla_3(int number){
	//printf("\tchamada com %d\n\n", number);
	if(number == 0)
		printf("fim\n");
	else{
		multipla_3(number-1);
		printf("%d\n", number);
		multipla_3(number-1);
	}
}

// Desenhe a execução!

int main(){
	printf("Multipla 1:\n");
	multipla_1(2);
	printf("Multipla 2:\n");
	multipla_2(2);
	printf("Multipla 3:\n");
	multipla_3(2);
	return 0;
}