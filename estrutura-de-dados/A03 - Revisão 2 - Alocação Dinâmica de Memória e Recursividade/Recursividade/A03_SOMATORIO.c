/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Problema: crie uma função recursiva que receba um número inteiro positivo N e calcule o somatório dos números de 1 a N.
*/

#include <stdio.h>
#include <stdlib.h>


void normalSum(int number){
	int sum = 0, i;
	for(i=number; i>0; i--){
		sum += number;
		number--;
	}
	printf("A soma (normal) foi: %d\n", sum);
}

int recursiveSum(int number){
	if(number == 0){
		return 0;
	}
	else{
		return number + recursiveSum(number-1);
	}
}

// recursiveSum(3);
// return 3 + recursiveSum(2)
	// return 2 + recursiveSum(1)
		// return 1 + recursiveSum(0)
			// 0
		// 1 + 0 -> return 1;
	// return 2 + 1 -> return 3;
// return 3 + 3 -> return 6;

int main(){
	normalSum(3);
	printf("A soma (recursiva) foi: %d\n", recursiveSum(3));
	return 0;
}