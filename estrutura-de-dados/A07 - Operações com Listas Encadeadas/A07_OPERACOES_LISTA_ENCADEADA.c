/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de uma Lista Encadeada
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int value;
	struct Node* next;
} Node;

Node* start(){
	return NULL;
}

Node * insert(Node* list, int value){
	Node *new = (Node*) malloc (sizeof(Node));
	new->value = value;
	new->next  = list;
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
	Node * p = list;
	Node * prior = NULL;
	if(value == list->value){
		prior = list;
		list = list->next;
		free(prior);
		return list;
	}
	while(p != NULL && p->value != value){
		prior = p;
		p = p->next;
	}
	if(p == NULL){
		return list;
	}
	else{
		prior->next = p->next;
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

/**
  * Novas Operações
  */

int searchBiggest(Node * list){
	int biggest = list->value;
	Node * p = list;
	while(p != NULL){
		if(p->value > biggest){
			biggest = p->value;
		}
		p = p->next;
	}
	return biggest;
}

int searchSmaller(Node * list){
	int smaller = list->value;
	Node * p = list;
	while(p != NULL){
		if(p->value < smaller){
			smaller = p->value;
		}
		p = p->next;
	}
	return smaller;
}

Node * insertOrdered(Node * list, int value){
	Node * aux1 = list;
	Node * aux2 = list;
	Node * new  = (Node*) malloc (sizeof(Node));
	new->value  = value;
	new->next   = NULL;
	while((aux2 != NULL) && (aux2->value < new->value)){
		aux1 = aux2;
		aux2 = aux2->next;
	}
	if(aux1 == aux2){
		new->next = aux1;
		list = new;
	}
	else{
		new->next = aux1->next;
		aux1->next = new;
	}
	return list;
}

Node * insertAtEnd(Node * list, int value){
	Node * new = (Node*) malloc (sizeof(Node));
	new->value = value;
	Node * aux = list->next;
	new->next = NULL;
	if(isEmptyList(list)){
		list->next = new;
	}
	else{
		while(aux->next != NULL){
			aux = aux->next;
		}
		aux->next = new;
	}
	return list;
}

Node * removeAtEnd(Node * list){
	if(isEmptyList(list)){
		return NULL;
	}
	else{
		Node * last = list->next;
		Node * penultimate = list;
		while(last->next != NULL){
			penultimate = last;
			last = last->next;
		}
		penultimate->next = NULL;
		free(last);
		return list;
	}
}

Node * removeAtStart(Node * list){
	if(isEmptyList(list)){
		return NULL;
	}
	else{
		Node * aux = list->next;
		list->next = aux->next;
		free(aux);
		return list;
	}
}

int main(){
	Node* list;
	list = start();
	list = insert(list, 77);
	list = insert(list, 25);
	list = insert(list, 15);
	list = insert(list, 5);
	printf("A lista está vazia (0,1) : %d\n", isEmptyList(list));
	printf("Impressão normal:\n");
	printList(list);
	if((search(list, 3)) != NULL){
		printf("\nBuscando pelo nó de valor 3. Valor encontrado: %d\n", (search(list, 3))->value);
	}
	if((search(list, 5)) != NULL){
		printf("\nBuscando pelo nó de valor 4. Valor encontrado: %d\n", (search(list, 5))->value);
	}
	printf("\n\nRemovendo o elemento 5.\n");
	list = removeList(list, 5);
	printf("\n\nImpressão recursiva:\n");
	printRecursive(list);
	printf("\n\nImpressão recursiva invertida:\n");
	printRecursiveInverted(list);

	/**
	  * Novas Operações
	  */
	printf("\n\nO maior elemento encontrado na lista foi: %d", searchBiggest(list));
	printf("\n\nO menor elemento encontrado na lista foi: %d", searchSmaller(list));
	printf("\n\nInserindo elemento de forma ordenada:\n");
	list = insertOrdered(list, 30);
	printf("\n\nImpressão normal:\n");
	printList(list);
	list = insertAtEnd(list, 80);
	printf("\n\nImpressão normal:\n");
	printList(list);
	printf("\n\nRemovendo no início:\n");
	list = removeAtStart(list);
	printf("\n\nRemovendo no final:\n");
	list = removeAtEnd(list);
	printf("\n\nImpressão normal:\n");
	printList(list);
	printf("\n");
	printf("\n\nLiberando a Lista.\n");
	freeList(list);
	return 0;
}