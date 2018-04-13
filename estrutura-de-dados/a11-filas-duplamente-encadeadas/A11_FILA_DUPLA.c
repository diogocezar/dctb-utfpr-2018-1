/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de Fila Duplamente Encadeada
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int value;
	struct Node * next;
	struct Node * prev;
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

void insertEnd(Queue * q, int value){
	Node * new = (Node*) malloc(sizeof(Node));
	new->value = value;
	new->next = NULL;
	if(q->end != NULL){
		q->end->next = new;
		new->prev = q->end;
	}
	else{
		q->start = new;
		new->prev = NULL;
	}
	q->end = new;
}

void insertStart(Queue * q, int value){
	Node * new = (Node*) malloc(sizeof(Node));
	new->value = value;
	new->prev = NULL;
	if(q->end != NULL){
		q->start->prev = new;
		new->next = q->start;
	}
	else{
		q->end = new;
		new->next = NULL;
	}
	q->start = new;
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

int removeStartQueue(Queue * q){
	Node * t;
	int v;
	if(isEmptyQueue(q)){
		printf("\nFila já vazia!\n");
		return 0;
	}
	t = q->start;
	v = t->value;
	q->start = t->next;
	if(t->next == NULL)
		q->end = NULL;
	else
		t->next->prev = NULL;
	free(t);
	return v;
}

int removeEndQueue(Queue * q){
	Node * t;
	int v;
	if(isEmptyQueue(q)){
		printf("\nFila já vazia!\n");
		return 0;
	}
	t = q->end;
	v = t->value;
	q->end = t->prev;
	if(t->prev == NULL)
		q->start = NULL;
	else
		t->prev->next = NULL;
	free(t);
	return v;
}

int main(){
	Queue * q;
	q = create();
	printf("Inserindo elemento 1 no início.\n");
	insertStart(q, 1);
	printf("Inserindo elemento 2 no início.\n");
	insertStart(q, 2);
	printf("Inserindo elemento 3 no início.\n");
	insertStart(q, 3);
	printf("Inserindo elemento 100 no fim.\n");
	insertStart(q, 100);
	printf("Inserindo elemento 99 no fim.\n");
	insertStart(q, 99);
	printf("Inserindo elemento 98 no fim.\n");
	insertStart(q, 98);
	printf("Imprimindo a fila:\n");
	printQueue(q);
	printf("Removendo um elemento do fim.\n");
	removeEndQueue(q);
	printf("Removendo um elemento do início.\n");
	removeStartQueue(q);
	printf("Imprimindo a fila:\n");
	printQueue(q);
	printf("Liberando a fila.\n");
	freeQueue(q);
	return 0;
}