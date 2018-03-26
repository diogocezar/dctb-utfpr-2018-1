/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: faça uma função recursiva que permita somar os elementos de um vetor de inteiros.
*/

#include <stdio.h>
#include <stdlib.h>

int *ptVector = NULL;
int qtd       = 0;

void printVector(){
	int i;
	for(i=0; i<qtd; i++){
		printf("[%d] = [%d]\n", i+1, ptVector[i]);
	}
}

void fillVector(){
	int i;
	printf("Quantos elementos deseja guardar?\n");
	scanf("%d", &qtd);
	ptVector = (int*) malloc(qtd * sizeof(int));
	for(i=0; i<qtd; i++){
		printf("Digite o elemento [%d]\n", i+1);
		scanf("%d", &ptVector[i]);
	}
	printVector();
}

void normalSum(){
	int sum = 0, i;
	for(i=0; i<qtd; i++){
		sum += ptVector[i];
	}
	printf("A soma (normal) foi: %d\n", sum);
}

int recursiveSum(int number){
	if(number == 0){
		return 0;
	}
	else{
		return recursiveSum(number-1) + ptVector[number-1];
	}
}

// ptVector = [1,2,3];
// recursiveSum(3);
// return recursiveSum(2) + ptVector[2];
	// return recursiveSum(1) + ptVector[1];
		// return recursiveSum(0) + ptVector[0];
			// 0
		// 0 + 1 -> return 1;
	// return 1 + 2 -> return 3;
// return 3 + 3 -> return 6;

int main(){
	fillVector();
	normalSum();
	printf("A soma (recursiva) foi: %d\n", recursiveSum(qtd));
	return 0;
}