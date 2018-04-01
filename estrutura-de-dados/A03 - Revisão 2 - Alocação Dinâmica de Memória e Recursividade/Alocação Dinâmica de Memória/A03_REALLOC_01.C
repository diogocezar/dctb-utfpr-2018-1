
#include<stdio.h>
#include<stdlib.h>

int quantidade = 0, *idades = NULL; // O ponteiro passado para o realoc deve ter um valor válido ou NULL

int  cadastrar();
void listar();

int main(){
    int opcao;

    do {
        printf("\n Menu de opcoes");
        printf("\n ==============\n");
        printf("\n <1> Cadastrar Idade");
        printf("\n <2> Listar Idades e Media");
        printf("\n <3> Sair");

        printf("\n\n Qual a opcao escolhida? ");
        fflush(stdin);
        if (scanf("%d", &opcao) == 0){
            opcao = -1; // O scanf nao leu nada, força entrar no default
        }

        switch (opcao){

            case 1:cadastrar();
                   break;

            case 2:listar();
                   break;

            case 3:free(idades); // Libera o vetor alocado dinâmicamente
                   exit(0);

            default: printf("\n\a Opcao invalida!\n");
        }
    }while(1);
}

int cadastrar(){

    int* novoBloco;

    novoBloco = (int*) realloc(idades, (quantidade + 1) * sizeof(int));

    if (novoBloco == NULL){
        printf("\n\a Erro ao alocar dinamicamente memoria!");
        return 0;
    }

    idades = novoBloco;

    printf("\n Cadastrando uma idade");
    printf("\n =====================");

    printf("\n Entre com a idade: ");
    fflush(stdin);
    scanf("%d", &idades[quantidade]);

    quantidade++;

    printf("\n Cadastrado realizado com sucesso!\n");

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
