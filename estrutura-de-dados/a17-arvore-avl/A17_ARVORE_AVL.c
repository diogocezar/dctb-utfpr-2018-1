/* ---------------------------------------------------------------- avl_tree.h 
   AVL Tree - Caio Dutra <caiodutra@uft.edu.br>
  
   UFT - EDII - 01/2010 
   
   Biblioteca relativa a estrutura de dados. Caracteriza aqui a Árvore AVL.
   
   ----> Por convenção, todos as funções listadas neste arquivo referentes a 
   manipulação de árvore AVL terão o prefixo avl_, para evitar possíveis 
   conflitos de nomes.

   ---------------------------------------------------------------------------*/

#ifndef AVL_H
#define AVL_H

#ifdef __cplusplus
exterm "C" {
#endif

typedef struct AVL_Node 
{    
    /*
     *  Estrutura do nó da árvore AVL.
     *  Contém um bit extra que informa
     *  o grau de balanceamento da árvore.
     *  Se for 0, 1 ou -1, a árvore está
     *  balanceada. Se não, serão realizadas
     *  algumas mudanças até que se balanceie
     */
     
     void *info;                // Informação contida no nó
     int bal;                   // Fator de balanceamento do nó
     
     struct AVL_Node *pai;      // Aponta para o nó ancestral
     struct AVL_Node *esq;      // Aponta para o filho da esquerda 
     struct AVL_Node *dir;      // Aponta para o filho da direita
     
} AVL_Node;

typedef struct AVL_Tree 
{
    /*
     *  Estrutura que define a árvore AVL.
     *  Aonde está guardada a raiz da árvore.
     *  Contém ponteiros para funções que
     *  manipulam as informações contidas na
     *  árvore.
     *  
     *  A função que o ponteiro compara_info
     *  aponta deverá retornar um valor inteiro
     *  segundo a seguinte legenda:
     *  +1 => Se o primeiro for maior
     *  -1 => Se o segundo for maior
     *   0 => Se os dois forem iguais 
     */
     
     AVL_Node *root;            // Raiz da árvore
     unsigned int num_nodes;    // Número de nós da árvore
     
     // Função que compara duas informações
     int (*compara_info)( const void *, const void * );
     // Função que imprime uma informação
     void (*imprime_info)( const void * );

} AVL_Tree;

/* Funções para manipulação da árvore */

// Inicialização da árvore
void avl_init ( AVL_Tree **, int (*compara_info)( const void *, const void * ),
        void (*imprime_info)( const void * ));

// Insere um elemento na árvore
int avl_insert ( AVL_Tree **, AVL_Node *, AVL_Node **, void * );

// Remove um elemento da árvore
int avl_remove ( AVL_Tree **, AVL_Node **, void * );

// Realiza o percurso em pré-ordem
void avl_walk_pre ( AVL_Tree *, AVL_Node * );

// Realiza o percurso em pos-ordem
void avl_walk_pos ( AVL_Tree *, AVL_Node * );

// Realiza o percurso em ordem simetrica
void avl_walk_sim ( AVL_Tree *, AVL_Node * );

// Realiza o percurso na árvore por nível
void avl_walk_byLevel ( AVL_Tree * );

// Faz uma busca na árvore
AVL_Node *avl_search ( AVL_Tree *, AVL_Node *, void * );

// Retorna a altura de uma sub-árvore
int avl_height ( AVL_Node * );

#ifdef __cplusplus
}
#endif


#endif /* AVL_H */


/* ---------------------------------------------------------------- avl_tree.c
   AVL Tree API - Caio Dutra <caiodutra@uft.edu.br>
  
   UFT - EDII - 01/2010 
   
   Biblioteca relativa a estrutura de dados. Caracteriza aqui a Árvore AVL.
   
   ----> Por convenção, todos as funções listadas neste arquivo referentes a 
   manipulação de árvore AVL terão o prefixo avl_, para evitar possíveis 
   conflitos de nomes.
   
   ---------------------------------------------------------------------------*/
   
#include <stdio.h>
#include <stdlib.h>

#include "avl_tree.h"


void avl_init ( AVL_Tree **tree, 
            int (*compara_info)( const void *, const void *),
                                    void (*imprime_info)( const void * )) 
/* Inicializa a árvore */
{
    
    AVL_Tree *nova;
    nova = ( AVL_Tree * ) malloc ( sizeof ( AVL_Tree ));
    if ( nova == NULL ) return;
    
    nova->root = NULL;
    nova->num_nodes = 0;
    nova->compara_info = compara_info;
    nova->imprime_info = imprime_info;
    
    *tree = nova;
}

int avl_height ( AVL_Node *node ) {
	
    int esq, dir;
	
    if ( node == NULL ) return -1;
	
    esq = avl_height ( node->esq );
    dir = avl_height ( node->dir );
	
    if ( esq > dir )
        return esq + 1;
    else
        return dir + 1;
}


/*  -- Rotações de sub-árvore --
 *
 *  A árvore AVL necessita, além das rotinas 
 *  básicas, algumas rotinas auxiliares para 
 *  mantê-la balanceada. São elas: rotação 
 *  simples para a esquerda, rotação simples 
 *   para a direita.
 */

AVL_Node *rotacao_direita ( AVL_Node *p ) 
/* Rotação simples para a direita */
{
    AVL_Node *q;
    
    q = p->esq;
    //----------------> Realiza a rotação
    p->esq = q->dir;
    if ( q->dir != NULL )
        q->dir->pai = p;
    q->dir = p;
    q->pai = p->pai;
    if ( p->pai != NULL )
        if ( p->pai->esq == p )
            p->pai->esq = q;
        else
            p->pai->dir = q;
    p->pai = q;
    //----------------> Rebalanceia
    q->bal = avl_height ( q->dir ) - avl_height ( q->esq );
    p->bal = avl_height ( p->dir ) - avl_height ( p->esq );    
    
    return q;
}
    
AVL_Node *rotacao_esquerda ( AVL_Node *p ) 
/* Rotação simples para a esquerda */
{    
    AVL_Node *q;
   
    q = p->dir;
    //----------------> Realiza a rotação
    p->dir = q->esq;
    if ( q->esq != NULL )
        q->esq->pai = p;
    q->esq = p;
    q->pai = p->pai;
    if ( p->pai != NULL )
        if ( p->pai->esq == p )
            p->pai->esq = q;
        else
            p->pai->dir = q;
    p->pai = q;
    //----------------> Rebalanceia
    q->bal = avl_height ( q->dir ) - avl_height ( q->esq );
    p->bal = avl_height ( p->dir ) - avl_height ( p->esq );
    
    return q;
}

/* Inserção na árvore AVL */

int avl_insert ( AVL_Tree **tree, AVL_Node *pai, AVL_Node **node, void *info ) 
{    
    AVL_Node *novo;
    int aux;
    
    if ( *tree == NULL ) return -1;
    if ( *node == NULL ) 
    // Se for o local correto para a inserção
    {
        novo = ( AVL_Node * ) malloc ( sizeof ( AVL_Node ));
        if ( novo == NULL ) return -1;
        novo->info  = info;
        novo->bal   = 0;
        novo->pai   = pai;
        novo->esq   = NULL;
        novo->dir   = NULL;
        
        *node = novo;
        (*tree)->num_nodes++;
        return 1;
    }
    
    /* 
     *  Procura o local apropriado. Na volta da pilha do processador, o 
     *  algoritmo vai atualizando o fator de balanceamento de cada nó. 
     *  São feitas rotações, se necessárias, para que a árvore se rebalanceie.
     */
     
    if ( (*tree)->compara_info( info, (*node)->info ) == +1 ) {
    
        aux = avl_insert ( tree, *node, &((*node)->dir), info );
        if ( aux != 1 ) return 0;
        
        if ( ++((*node)->bal) == 2 ) {
            if ( (*node)->dir->bal == 1 ) {
                *node = rotacao_esquerda ( *node );
                return 0;
            }
            (*node)->dir = rotacao_direita ( (*node)->dir );
            *node = rotacao_esquerda ( *node );
            
            return 0;
        }
        
        return ( (*node)->bal == 0 )? 0: 1;  
    }
    
    if ( (*tree)->compara_info( info, (*node)->info ) == -1 ) {
        
        aux = avl_insert ( tree, *node, &((*node)->esq), info );
        if ( aux != 1 ) return 0;
        
        if ( --((*node)->bal) == -2 ) {
            if ( (*node)->esq->bal == -1 ) {
                *node = rotacao_direita ( *node );
                return 0;
            }
            (*node)->esq = rotacao_esquerda ( (*node)->esq );
            *node = rotacao_direita ( *node );
            
            return 0;
        }
        
        return ( (*node)->bal == 0 )? 0: 1;        
    }
    
    return 0;
}

/* Remove um elemento da árvore */

int avl_remove ( AVL_Tree **tree, AVL_Node **node, void *info ) 
{    
    int ret;
    
    if ( *node == NULL || *tree == NULL ) return -1;
    
    if ( (*tree)->compara_info( info, (*node)->info ) == +1 ) 
    // Vai para a S.A. da esquerda
    {
        ret = avl_remove ( tree, &((*node)->dir), info );
        if ( ret != 1 ) return 0;
        
        if ( --((*node)->bal) == -2 ) {
            if ( (*node)->esq->bal == -1 ) {
                *node = rotacao_direita ( *node );
                return 0;
            }
            (*node)->esq = rotacao_esquerda ( (*node)->esq );
            *node = rotacao_direita ( *node );
            return 0;
        }
        return ( (*node)->bal == 0 )? 1: 0;
    }
    if ( (*tree)->compara_info( info, (*node)->info ) == -1 ) 
    // Vai para a S.A. da direita
    {
        ret = avl_remove ( tree, &((*node)->esq), info );
        if ( ret != 1 ) return 0;
        
        if ( ++((*node)->bal) == +2 ) {
            if ( (*node)->dir->bal == 1 ) {
                *node = rotacao_esquerda ( *node );
                return 0;
            }
            (*node)->dir = rotacao_direita ( (*node)->dir );
            *node = rotacao_esquerda ( *node );
            return 0;
        }
        return ( (*node)->bal == 0 )? 1: 0;
    }
    
    if ( (*tree)->compara_info( info, (*node)->info ) == 0 ) 
    // Encontrou o elemento a ser removido
    {
        AVL_Node *aux, *temp;
        void *i;
        
        if ( (*node)->esq == NULL ) {
            
            if ( (*node)->dir == NULL )
            // Se não contiver filho algum
            {
                free ( *node );
                *node = NULL;
                (*tree)->num_nodes--;                
                return 1;
            }
            
            // Se contiver o filho da direita
            aux = *node;
            temp = (*node)->dir;
            temp->pai = (*node)->pai;
            if ( (*node)->pai != NULL )
                if ( (*node)->pai->esq == *node )
                    (*node)->pai->esq = temp;
                else
                    (*node)->pai->dir = temp;
            *node = temp;
            free ( aux );
            (*tree)->num_nodes--;            
            return 1;
        }
        
        if ( (*node)->dir == NULL )
        // Se contiver apenas o filho da esquerda
        {
            aux = *node;
            temp = (*node)->esq;
            temp->pai = (*node)->pai;
            if ( (*node)->pai != NULL )
                if ( (*node)->pai->esq == *node )
                    (*node)->pai->esq = temp;
                else
                    (*node)->pai->dir = temp;
            *node = temp;
            free ( aux );
            (*tree)->num_nodes--;            
            return 1;        
        }
        
        // Se contiver os dois filhos
        aux = (*node)->esq;
        while ( aux->dir != NULL )
            aux = aux->dir;
        i = aux->info;
        avl_remove ( tree, node, aux->info );
        (*node)->info = i;
        
        return 1;
    }
}

/* Percursos da árvore */

void avl_walk_pre ( AVL_Tree *tree, AVL_Node *node ) 
// Percorre a árvore em pré-ordem
{    
    if ( node == NULL ) return;
    
    tree->imprime_info( node->info );
    if ( node->esq != NULL && node->dir != NULL ) printf ( ", " );
    
    avl_walk_pre ( tree, node->esq );
    avl_walk_pre ( tree, node->dir );
}

void avl_walk_pos ( AVL_Tree *tree, AVL_Node *node ) 
// Percorre a árvore em pós-ordem
{    
    if ( node == NULL ) return;
    
    avl_walk_pre ( tree, node->esq );
    avl_walk_pre ( tree, node->dir );
    
    tree->imprime_info( node->info );
    if ( node->esq != NULL && node->dir != NULL ) printf ( ", " );
}

void avl_walk_sim ( AVL_Tree *tree, AVL_Node *node ) 
// Percorre a árvore em ordem simétrica
{    
    if ( node == NULL ) return;
    
    avl_walk_pre ( tree, node->esq );
    
    tree->imprime_info( node->info );
    if ( node->esq != NULL && node->dir != NULL ) printf ( ", " );
    
    avl_walk_pre ( tree, node->dir );
}

void avl_walk_lev ( AVL_Tree *tree ) 
// Percorre a árvore por nível ( Busca Lateral )
{
	AVL_Node *queue[tree->num_nodes];
	AVL_Node *aux;
	int tail = -1, i;
	if ( tree->root == NULL ) return;
	
	queue[++tail] = tree->root;
	while ( tail > -1 ) {
		aux = queue[0];
		for ( i = 0; i < tail; i++ )
			queue[i] = queue[i+1];
		tail--;
		
		tree->imprime_info( aux->info );
		printf ( " " );
		
		if ( aux->esq != NULL )
			queue[++tail] = aux->esq;
		if ( aux->dir != NULL )
			queue[++tail] = aux->dir;
	}
}

void avl_print ( AVL_Tree *tree, AVL_Node *node, int level ) 
{    
    int i;
    
    if ( tree == NULL || node == NULL ) return;
    for ( i = 0; i < level; i++ )
        printf ( "   " );

    printf ( "> [" );
    tree->imprime_info( node->info );
    printf ( "][%i]\n", node->bal );
    
    avl_print ( tree, node->esq, level + 1 );
    avl_print ( tree, node->dir, level + 1 );
}

/* Busca por um elemento */

AVL_Node *avl_search ( AVL_Tree *tree, AVL_Node *node, void *info ) 
{
    if ( tree == NULL || node == NULL ) return NULL;
    
    if ( tree->compara_info( info, node->info ) == 0 ) return node;
    if ( tree->compara_info( info, node->info )  > 0 )
        return avl_search ( tree, node->dir, info );
    else
        return avl_search ( tree, node->esq, info );
}

