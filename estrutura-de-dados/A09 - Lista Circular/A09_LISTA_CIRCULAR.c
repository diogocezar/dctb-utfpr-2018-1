/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de uma Lista Circular
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
	int value;
	struct Node* next;
} Node;

int isEmptyList(Node * head){
	return (head == NULL);
}

Node * insert(Node* head, int value){
	Node *new = (Node*) malloc (sizeof(Node));
	new->value = value;
	if(isEmptyList(head)){
		head = new;
		new->next  = head;
		head->next = new;
	}
	else{
		new->next = head->next;
		head->next = new;
	}
	return head;
}

Node * removeList(Node* head){
	Node * p = head->next;
	Node * nextNode = head->next;
	if(head == NULL){
		return NULL;
	}
	else{
		while(p->next != head){
			p = p->next;
		}
		p->next = nextNode;
		free(head);
	}
	return nextNode;
}

void printListLoop(Node* head, int i){
	Node * p = head;
	if(isEmptyList(head)){
		printf("Essa lista está vazia!\n");
	}
	else{
		while(i > 0){
			printf("Valor: %d\n", p->value);
			p = p->next;
			i--;
		}
	}
}

void printList(Node* head){
	Node * p;
	p = head->next;
	if(isEmptyList(p)){
		printf("Essa lista está vazia!\n");
	}
	else{
		while(p != head){
			printf("Valor: %d\n", p->value);
			p = p->next;
		}
		printf("Valor: %d\n", p->value);
	}
}

Node * search(Node * head, int value){
	Node * p;
	for(p=head->next; p != head; p=p->next){
		if(p->value == value){
			return p;
		}
	}
	if(p->value == value){
		return p;
	}
	return NULL;
}

int main(){
	printf("Iniciando a cabeça com NULL.\n");
	Node * head = NULL;
	Node * searched = NULL;
	printf("A lista está vazia (0,1) : %d\n", isEmptyList(head));
	printf("Inserindo elementos.\n");
	head = insert(head, 10);
	head = insert(head, 25);
	head = insert(head, 21);
	head = insert(head, 76);
	head = insert(head, 23);
	head = insert(head, 2);
	printf("Imprimindo a lista:\n");
	printList(head);
	printf("Imprimindo a lista 20 vezes:\n");
	printListLoop(head, 20);
	printf("Removendo elemento do início.\n");
	head = removeList(head);
	printf("Imprimindo a lista:\n");
	printList(head);
	printf("Buscando elemento:\n");
	searched = search(head, 4);
	if(searched != NULL){
		printf("Encontrou o elemento: %d\n", searched->value);
	}
	else{
		printf("Não encontrou o elemento.\n");
	}
	return 0;
}