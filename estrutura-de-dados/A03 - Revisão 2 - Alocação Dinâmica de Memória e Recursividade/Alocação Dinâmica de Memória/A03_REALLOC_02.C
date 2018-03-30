
#include<stdio.h>
#include<stdlib.h>

/* Faz a remoção de uma informação cadastrada.
   Remove apenas a última */

int quantidade = 0, *idades = NULL;

int  cadastrar();
int  remover();
void listar();

int main(){
    int opcao;

    do {
        printf("\n Menu de opcoes");
        printf("\n ==============\n");
        printf("\n <1> Cadastrar Idade");
        printf("\n <2> Remover Ultima Idade");
        printf("\n <3> Listar Idades e Media");
        printf("\n <4> Sair");

        printf("\n\n Qual a opcao escolhida? ");
        fflush(stdin);
        if (scanf("%d", &opcao) == 0){
            opcao = -1; // O scanf nao leu nada, força entrar no default
        }

        switch (opcao){

            case 1:cadastrar();
                   break;

            case 2:remover();
                   break;

            case 3:listar();
                   break;

            case 4:free(idades); // Libera o vetor alocado dinâmicamente
                   exit(0);

            default: printf("\n\a Opcao invalida!\n");
        }
    }while(1);
}

int cadastrar(){

    int* novoBloco;

    printf("\n Cadastrando uma idade");
    printf("\n =====================");

    novoBloco = (int*) realloc(idades, (quantidade + 1) * sizeof(int));

    if (novoBloco == NULL){
        printf("\n\a Erro ao alocar dinamicamente memoria!\n");
        return 0;
    }

    if (novoBloco != idades){
       printf("\n Movimentou para um novo bloco de memoria.\n");
       free(idades);
       idades = novoBloco;
    }else{
       printf("\n Apenas aumentou o bloco de memoria atual.\n");
    }

    printf("\n Entre com a idade: ");
    fflush(stdin);
    scanf("%d", &idades[quantidade]);

    quantidade++;

    printf("\n Cadastrado realizado com sucesso!\n");

    return 1;
}

int remover(){

    if (quantidade == 0){
        printf("\n\a Nenhuma idade foi cadastrada!\n");
        return 0;
    }

    printf("\n Removendo ultima idade");
    printf("\n ======================");

    quantidade--; // Já atualizamos a quantidade, desprezando a última posição que será apagada

    if (quantidade >= 1){

        // Vai restar alguém na memória

        int* novoBloco;

        novoBloco = (int*) realloc(idades, quantidade * sizeof(int));

        if (novoBloco == NULL){
           printf("\n\a Erro ao alocar dinamicamente memoria!\n");
           return 0;
        }

        if (novoBloco != idades){
           printf("\n Movimentou para um novo bloco de memoria.\n");
           free(idades);
           idades = novoBloco;
        }else{
           printf("\n Apenas diminuiu o bloco de memoria atual.\n");
        }

    }else{
        // Não vai restar ninguém, libera todo o bloco

        printf("\n Liberou o bloco de memoria atual.\n");
        free(idades);
        idades = NULL; // Evitar erro no realloc usando um ponteiro com valor inválido de bloco
    }

    printf("\n Remocao realizada com sucesso!\n");

    return 1;
}

void listar(){

    int indice, soma = 0;

    if (quantidade == 0){
        printf("\n\a Nenhuma idade foi cadastrada!\n");
        return;
    }

    printf("\n Listando todas as idades");
    printf("\n ========================");

    for (indice = 0; indice < quantidade; indice++){
        printf("\n %3d - Idade: %3d", indice + 1, idades[indice]);
        soma += idades[indice];
    }

    printf("\n\n A media das idades eh %.2f", (float) soma / quantidade);
    printf("\n\n O vetor ocupa %d Bytes em memoria.\n", sizeof(int) * quantidade);
}
