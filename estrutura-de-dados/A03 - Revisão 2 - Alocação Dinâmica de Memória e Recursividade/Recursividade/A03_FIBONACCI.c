/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Fibonacci Recursivo
*/

#include <stdio.h>

int fibonacci(int N){
	if (N < 0){
        return -1; // Não existe fibonacci
    }else{
    	if (N == 0){
    		return 0;
    	}
    	else{
	    	if (N == 1){
	    		return 1;
	    	}else{
	    		return fibonacci(N - 1) + fibonacci(N - 2);
	    	}
    	}
    }
}

int main(){
	int resultado, numero;

	printf("\n Calculo de Fibonacci");
	printf("\n ====================\n");

	printf("\n Entre com o numero: ");
	fflush(stdin);
	scanf("%d", &numero);

	resultado = fibonacci(numero);

	if (resultado < 0){
		printf("\n Nao existe F(%d)\n", numero);
	}else{
		printf("\n F(%d) = %d\n", numero, resultado);
	}
	return 0;
}
