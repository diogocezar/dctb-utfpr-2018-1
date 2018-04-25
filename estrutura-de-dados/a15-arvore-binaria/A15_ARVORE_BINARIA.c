/**
* Professor Diogo Cezar Teixeira Batista
* <diogo@diogocezar.com>
* <diogoc@utfpr.edu.br>
* Exemplo Árvore Binária
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct BinaryTree{
	int value;
	struct BinaryTree * left;
struct BinaryTree * right;
} BinaryTree;

BinaryTree * create(){
	return NULL;
}

BinaryTree * insert(int value, BinaryTree * left, BinaryTree * right){
	BinaryTree * new = (BinaryTree*) malloc(sizeof(BinaryTree));
	new->value = value;
	new->left = left;
	new->right = right;
	return new;
}

int isEmptyTree(BinaryTree * tree){
	return (tree == NULL);
}

void printTree(BinaryTree * bt){
	if(!isEmptyTree(bt)){
		printf("%d\n", bt->value);
		printTree(bt->left);
		printTree(bt->right);
    }
}

int search(BinaryTree * bt, int value){
    if(isEmptyTree(bt))
        return 0;
    else{
        if(bt->value == value)
            return 1;
        else{
            search(bt->left, value);
            search(bt->right, value);
        }
    }
}

BinaryTree * freeTree(BinaryTree * bt){
	if(!isEmptyTree(bt)){
		freeTree(bt->left);
		freeTree(bt->right);
		free(bt);
    }
    return NULL;
}

int main(){
    BinaryTree * bt;
	bt = create();
    bt = insert(10, 
        insert(15, 
            insert(20, create(), create()),
            insert(35, create(), create())
        ),
        insert(12, 
            insert(25, create(), create()),
            insert(12, 
                insert(3, create(), create()),
                insert(1, create(), create())
            )
        )
    );
    printTree(bt);
    printf("\nO elemento 10 existe? (1,0) : %d\n", search(bt, 10));
    freeTree(bt);
    return 0;
}