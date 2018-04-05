/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de funções utilizando registros.
* Exemplo da passagem de um único registro por ponteiro, e a forma da sua utilização;
* Exemplo da passagem de um vetor de registros, e a forma de sua utilização;
*/

#include <stdio.h>

typedef struct Students{
	char name[50];
	int code;
} typeStudents;

void readOne(typeStudents * student){
	printf("Digite o nome do estudante: \n");
	scanf("%s", student->name); // note que com ponteiro não utiliza-se o . e sim ->
	printf("Digite o código do estudante: \n");
	scanf("%d", &student->code);
}

void printOne(typeStudents * student){
	printf("\nNome do estudante : %s \n", student->name);
	printf("Código do estudante : %d \n", student->code);
}

void readVector(typeStudents * student, int size){ // note que podemos recever tanto um ponteiro para o vetor
	int i;
	for(i=0; i<size; i++){
		printf("Digite o nome do estudante [%d]: \n", i+1);
		scanf("%s", student[i].name);
		printf("Digite o código do estudante [%d]: \n", i+1);
		scanf("%d", &student[i].code);
	}
}

void printVector(typeStudents student[], int size){ // esta segunda forma de declaração também tem o mesmo efeito
	int i;
	for(i=0; i<size; i++){
		printf("\nNome do estudante : %s \n", student[i].name);
		printf("Código do estudante : %d \n", student[i].code);
	}
}

int main(){
	// duas declarações: um registro único e um vetor de registros
	typeStudents uniqueStudent;
	typeStudents vectorStudents[2];

	// lendo e escrevendo um único estudante:
	readOne(&uniqueStudent);
	printOne(&uniqueStudent);

	printf("\n\n");

	// lendo e escrevendo vários estudantes
	readVector(vectorStudents, 2);
	printVector(vectorStudents, 2);
	return 0;
}