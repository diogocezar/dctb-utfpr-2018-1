/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo de Hash
*/

#include <stdio.h>
#include <stdlib.h>

#define SIZE 677

typedef struct Data{
  int value;
  struct Data *next;
} Data;

typedef Data* Hash[SIZE];

int hashFunction(int value){
  return(value%SIZE);
}

void startHash(Hash table){
    int i;
    for(i=0; i<SIZE; i++)
        table[i] = NULL;
}

void insertHash(Hash table, int value){
    int i = 0;
    int hashCode = hashFunction(value);
    Data * aux = table[hashCode];
    while(aux != NULL){
        if(aux->value == value){
            break;
        }
        aux = aux->next;
    }
    if(aux == NULL){
        aux = (Data*)malloc(sizeof(Data));
        aux->value = value;
        aux->next = table[hashCode];
        table[hashCode] = aux;
    }
}

void printHash(Hash table){
    int i = 0;
    int cont = 0;
    for(i=0; i<SIZE; i++){
        if(table[i] != NULL){
            printf("\n [%d] -> %d", i, table[i]->value);
            Data * aux = table[i]->next;
            while(aux != NULL){
                printf("\t -> %3d", aux->value);
                aux = aux->next;
            }
        }
    }
    printf("\n");
}

void printCollision(Hash table, int position){
    Data * aux = table[position];
    if(aux == NULL){
        printf("\nEsta posição esta vazia!");
        return;
    }
    else{
        printf("%3d", aux->value);
        while(aux->next != NULL){
            printf(" -> %d", aux->next->value);
            aux = aux->next;
        }
    }
}

void searchHashIndex(Hash table, int value){
    if(value > SIZE || value < 0){
        printf("\nPosição não encontrada!");
        return;
    }
    else{
        printCollision(table, value);
    }
    printf("\n");
}

void emptyPositions(Hash table){
    int i, cont=0; 
    for(i=0; i<SIZE; i++){
        if(table[i] == NULL){
            printf("%d\t", i);
            cont++;
        }
    }
    printf("\nTotal de posições vazias = %d\n", cont);
}

void fillTable(Hash table){
    int i;
    for(i=0; i<1000; i++){
        insertHash(table, 1234 + i);
    }
}

void removeHash(Hash table, int index, int value){
    if(index > SIZE || index < 0){
        printf("\nEsta posição não existe na tabela!\n");
    }
    else{
        if(table[index] == NULL){
            printf("Esta chave esta vazia!\n");
        }
        else{
            if(table[index]->value == value){
                if(table[index]->next == NULL){
                    table[index] = NULL;
                    return;
                }
            }
            else{
                Data * prev = NULL;
                Data * aux = table[index]->next;
                while(aux->next != NULL && aux->value != value){
                    prev = aux;
                    aux = aux->next;
                }
                if(aux->value != value){
                    printf("\nRegistro não encontrado!");
                }
                else{
                    if(prev == NULL)
                        table[index]->next = aux->next;
                    else
                        prev->next = aux->next;
                    aux = NULL;
                    free(aux);
                }
            }
        }
    }
}

int main(){
    Hash table;
    printf("Iniciando a tabela hash.\n");
    startHash(table);
    printf("Inserindo elementos na tabela.\n");
    fillTable(table);
    printf("Imprimindo a tabela:");
    printHash(table);
    printf("Elementos do índice 0:\n");
    searchHashIndex(table, 0);
    emptyPositions(table);
    printf("Removendo o elemento: 1354\n");
    removeHash(table, 0, 1354);
    printf("Elementos do índice 0:\n");
    searchHashIndex(table, 0);
    return 0;
}