/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo Árvore Binária de Busca
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct BinarySearchTree{
    int value;
    struct BinarySearchTree * left;
    struct BinarySearchTree * right;
} BinarySearchTree;

BinarySearchTree * create(){
    return NULL;
}

int isEmptyTree(BinarySearchTree * bst){
    return (bst == NULL);
}

BinarySearchTree * insert(BinarySearchTree * bst, int value){
    if(isEmptyTree(bst)){
        bst = (BinarySearchTree*) malloc(sizeof(BinarySearchTree));
        bst->value = value;
        bst->left = NULL;
        bst->right = NULL;
    }
    else if(value < bst->value){
        bst->left = insert(bst->left, value);
    }
    else{
        bst->right = insert(bst->right, value);
    }
    return bst;
}

void printTree(BinarySearchTree * bst){
    if(!isEmptyTree(bst)){
        printTree(bst->left);
        printf("%d\n", bst->value);
        printTree(bst->right);
    }
}

BinarySearchTree * search(BinarySearchTree * bst, int value){
    if(isEmptyTree(bst))
        return NULL;
    else if(bst->value > value)
        return search(bst->left, value);
    else if(bst->value < value)
        return search(bst->right, value);
    else
        return bst;
}

BinarySearchTree * freeTree(BinarySearchTree * bst){
    if(!isEmptyTree(bst)){
        freeTree(bst->left);
        freeTree(bst->right);
        free(bst);
    }
    return NULL;
}

BinarySearchTree * removeNode(BinarySearchTree * bst, int value){
    if(bst == NULL) return NULL;
    else if(bst->value > value)
        bst->left = removeNode(bst->left, value);
    else if(bst->value < value)
        bst->right = removeNode(bst->right, value);
    else{
        if(bst->left == NULL && bst->right == NULL){
            free(bst);
            bst = NULL;
        }
        else if(bst->left == NULL){
            BinarySearchTree * aux = bst;
            bst = bst->right;
            free(aux);
        }
        else if(bst->right == NULL){
            BinarySearchTree * aux = bst;
            bst = bst->left;
            free(aux);
        }
        else{
            BinarySearchTree * aux = bst->right;
            while(aux->left != NULL)
                aux = aux->left;
            bst->value = aux->value;
            aux->value = value;
            bst->right = removeNode(bst->right, value);
        }
    }
    return bst;
}


int main(){
    BinarySearchTree * bst;
	bst = create();
    bst = insert(bst, 50);
    bst = insert(bst, 1);
    bst = insert(bst, 23);
    bst = insert(bst, 22);
    bst = insert(bst, 12);
    bst = insert(bst, 43);
    printf("Imprimindo a árvore binária:\n");
    printTree(bst);
    printf("Retornando o valor do elemento 1 -> %d:\n", search(bst, 1)->value);
    printf("Removendo elemento 22.\n");
    removeNode(bst, 22);
    printf("Removendo elemento 1.\n");
    removeNode(bst, 1);
    printf("Imprimindo a árvore binária:\n");
    printTree(bst);
    printf("Liberando a árvore binária.\n");
    freeTree(bst);
    return 0;
}