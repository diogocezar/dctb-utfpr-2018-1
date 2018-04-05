/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de uma Lista Duplamente Encadeada
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int value;
	struct Node* next;
	struct Node* prev;
} Node;

Node* start(){
	return NULL;
}

Node * insert(Node* list, int value){
	Node *new = (Node*) malloc (sizeof(Node));
	new->value = value;
	new->next  = list;
	new->prev  = NULL;
	if(list != NULL){
		list->prev = new;
	}
	return new;
}

int isEmptyList(Node * list){
	return (list == NULL);
}

void printList(Node * list){
	Node * p = list;
	if(isEmptyList(p)){
		printf("Essa lista está vazia!\n");
	}
	else{
		while(p != NULL){
			printf("\nValor: %d", p->value);
			p = p->next;
		}
	}
}

Node * search(Node * list, int value){
	Node * p;
	for(p=list; p!=NULL; p=p->next){
		if(p->value == value){
			return p;
		}
	}
	return NULL;
}

void freeList(Node * list){
	Node * p = list;
	while(p != NULL){
		printf("Liberando o elemento: %d\n", p->value);
		Node * temp = p->next;
		free(p);
		p = temp;
	}
}

Node * removeList(Node * list, int value){
	Node * p = search(list, value);
	if(p==NULL)
		return list;
	if(list == p){
		list = p->next;
	}
	else{
		p->prev->next = p->next;
	}
	if(p->next != NULL){
		p->next->prev = p->prev;
	}
	free(p);
	return list;
}

void printRecursive(Node * list){
	Node * p = list;
	if(!isEmptyList(p)){
		printf("\nValor: %d", p->value);
		printRecursive(p->next);
	}
}

void printRecursiveInverted(Node * list){
	Node * p = list;
	if(!isEmptyList(p)){
		printRecursive(p->next);
		printf("\nValor: %d", p->value);
	}
}

int main(){
	Node* list;
	list = start();
	list = insert(list, 1);
	list = insert(list, 2);
	list = insert(list, 3);
	list = insert(list, 4);
	printf("A lista está vazia (0,1) : %d\n", isEmptyList(list));
	printf("Impressão normal:\n");
	printList(list);
	if((search(list, 3)) != NULL){
		printf("\nBuscando pelo nó de valor 3. Valor encontrado: %d\n", (search(list, 3))->value);
	}
	if((search(list, 9)) != NULL){
		printf("\nBuscando pelo nó de valor 9. Valor encontrado: %d\n", (search(list, 9))->value);
	}
	printf("\n\nRemovendo o elemento 3:\n");
	list = removeList(list, 3);
	printf("\n\nImpressão recursiva:\n");
	printRecursive(list);
	printf("\n\nImpressão recursiva invertida:\n");
	printRecursiveInverted(list);
	printf("\n");
	printf("\n\nLiberando a Lista.\n");
	freeList(list);
	return 0;
}