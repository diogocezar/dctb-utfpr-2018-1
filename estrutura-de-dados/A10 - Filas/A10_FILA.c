/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de Fila
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int value;
	struct Node * next;
} Node;

typedef struct Queue{
	Node * start;
	Node * end;
} Queue;

Queue * create(){
	Queue * q = (Queue*) malloc(sizeof(Queue));
	q->start = NULL;
	q->end = NULL;
	return q;
}

void insert(Queue * q, int value){
	Node * new = (Node*) malloc(sizeof(Node));
	new->value = value;
	new->next = NULL;
	if(q->end != NULL){
		q->end->next = new;
	}
	else{
		q->start = new;
	}
	q->end = new;
}

int isEmptyQueue(Queue * q){
	return (q->start == NULL);
}

void printQueue(Queue * q){
	Node * p;
	p = q->start;
	if(isEmptyQueue(q)){
		printf("Essa fila está vazia!\n");
	}
	else{
		while(p != NULL){
			printf("Valor: %d\n", p->value);
			p = p->next;
		}
	}
}

Node * search(Queue * q, int value){
	Node * p;
	for(p=q->start; p != NULL; p=p->next){
		if(p->value == value){
			return p;
		}
	}
	return NULL;
}

void freeQueue(Queue * q){
	Node * p = q->start;
	while(p != NULL){
		Node * t = p->next;
		free(p);
		p = t;
	}
	free(q);
}

int removeQueue(Queue * q){
	Node * t;
	int v;
	if(isEmptyQueue(q)){
		printf("\nFila já vazia!\n");
		return 0;
	}
	t = q->start;
	v = t->value;
	q->start = t->next;
	if(q->start == NULL)
		q->end = NULL;
	free(t);
	return v;
}

int main(){
	Queue * q;
	q = create();
	Node * searched = NULL;
	int removed;
	printf("Inserindo elementos.\n");
	insert(q, 6);
	insert(q, 1);
	insert(q, 3);
	printf("Imprimindo a fila.\n");
	printQueue(q);
	removed = removeQueue(q);
	printf("O elemento removido foi: %d\n", removed);
	printf("Imprimindo a fila.\n");
	printQueue(q);
	printf("Buscando elemento:\n");
	searched = search(q, 1);
	if(searched != NULL){
		printf("Encontrou o elemento: %d\n", searched->value);
	}
	printf("Liberando a fila.\n");
	freeQueue(q);
	return 0;
}