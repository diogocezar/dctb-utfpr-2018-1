# include <stdio.h>
# include <stdlib.h>
# include <windows.h>
# include <time.h>
# include <conio.h>
# include "hash.h"

/*funcaoHash  recebe como parametro uma variavel do tipo inteiro(num),
retorna a  restra da divisao do valor dessa variavel pela tamanho da tabela*/
int funcaoHash(int num){
  return(num%tam);
}

/*O procedimento inicializaHash recebe como parametro uma variavel do tipo
 Hash e sua funcao e que todas as posicoes da tab se tornem nulas*/
void inicializaHash(Hash tab){
 int i;
 for(i = 0; i < tam; i++){
  tab[i] = NULL;
 }
}
/*O procedimento insererHash recebe como parametro dois argumentos uma 
variavel do tipo Hash e outra do tipo num. Sua funcao e inserir os elementos
na tabela atraveis da funcaoHash e caso esta posicao ja esteja preenchida,
como colisao esta sendo adotado neste procedimento o encadeamento direto.*/
void insereHash(Hash tab, int num){
 int i = 0;   
 int chave = funcaoHash(num);
 Dados* aux = tab[chave];
 while(aux != NULL){
  if(aux->info == num){
   break;
  }
  aux = aux->prox;
 }   
 if(aux == NULL){
  aux = (Dados*)malloc(sizeof(Dados));
  aux->info = num;
  aux->prox = tab[chave];
  tab[chave] = aux;
 }
}

/*O procedimento buscaHash recebe como parametro duas variaveis uma do 
tipo Hash(tab) e outra do tipo inteiro(num),A variavel tab tem como funcao
 passar a tabela e a variavel num tem como funcao determinar a posicao da 
 tabela que o usuario deseja visualizar*/
void buscaHash(Hash tab,int num){
 int pos = num;
 if(num > tam || num < 0){
  printf("\nPosicao nao encontrada!");
  return;
 }else{
  imprimeColisao(tab,pos);

}}
/*O procedimento imprimeHash recebe como parametro uma variavel do tipo Hash.
Sua funcao e imprimir todos os elementos da variavel do tipo Hash*/
void imprimeHash(Hash tab){
 int  i = 0,cont = 0;
 for(i = 0; i < tam; i++){
  if(tab[i] != NULL){
   printf("\n %d",tab[i]->info);
   Dados* aux =tab[i]->prox;
   while(aux!=NULL){
    printf(" -> %3d",aux->info);
     aux=aux->prox;
   }
  }
 }
}

/*O procedimento removeHash recebe como parametro uma variavel do tipo Hash 
e outra do tipo inteiro, a variavel do tipo Hash serve para termos acesso 
a tabela e a variavel do tipo inteiro serve para escolher a posicao que o 
usuario deseja visualizar, apos a visualizacao da chave, o usuario escolhe a 
informacao da chave que deseja eliminar*/
void removeHash(Hash tab, int num){
 int pos = num;
 int ex ;
 if(num > tam){
  printf("\nEsta posicao nao existe na tabela!");
 }else{
  if(tab[pos] == NULL){
   printf("Esta chave esta vazia!");
  }else{
   printf("\n\n\n");
   imprimeColisao(tab,pos);
   printf("\n\nQual registro deseja apagar =  ");
   scanf("%d",&ex);
   if(tab[pos]->info == ex){
    if(tab[pos]->prox == NULL){
     tab[pos] = NULL;
     return;
    }
    if(tab[pos]->prox != NULL){
     tab[pos]->info = tab[pos]->prox->info;
     tab[pos]->prox = tab[pos]->prox->prox;
     return;
    } 
   }else{
   if(tab[pos]->info != ex){    
    if(tab[pos]->prox == NULL){
     printf("\nRegistro nao encontrado!");
     getch();
     return;
    }else{
    Dados* ant = NULL;
    Dados* aux = tab[pos]->prox;
    while(aux->prox != NULL  && aux->info != ex){
     ant = aux;
     aux = aux->prox;
    }
    if(aux->info != ex){
     printf("\nRegistro nao encontrado!\n");
     return;
    }else{
    if(ant == NULL){
     tab[pos]->prox = aux->prox;
    }else{
         ant->prox = aux->prox;
        }
        aux = NULL;
        free(aux);
        }
      }
     }
    }
   }
  }
}
 
/*O precedimento criarArquivo recebe como parametro uma variavel do 
tipo FILE*. Sua funcao é criar um arquivo, que futuramente será usado como
recipiente para guardar os numero aleatorios.*/
void criarArquivo(FILE* arquivo){
 arquivo = fopen("hash.txt", "r");
 if(arquivo == NULL){
  arquivo = fopen("hash.txt", "w");
  fclose(arquivo);  
 }else{
  return; 
 }
}

/*O procedimento reescreveArquivo recebe como parametro uma variavel do 
tipo FILE*. Sua funcao é eliminar o arquivo anterior.*/
void reescreveArquivo(FILE* arquivo){
 arquivo = fopen("hash.txt", "w");
 fclose(arquivo);
}

/*O procedimento escreveArquivo recebe como parametro uma variavel do tipo
FILE* e outra do tipo inteiro. A variavel do tipo FILE* fornece o acesso 
para o arquivo e a variavel do tipo inteiro sera o elemento que o usuario vai
guardar no arquivo*/
void escreverArquivo(FILE* arquivo, int elemento){
 arquivo = fopen("hash.txt", "a");     
 fprintf(arquivo,"%3d\n",elemento);
 fclose(arquivo);
}

/*A funcao carregaArquivo recebe como parametro o arquivo
onde esta guardado todos as informacoes. Sua funcao e inserir
na tabela Hash os elementos que estao no arquivo.*/
int carregaArquivo(Hash tab){
 int elemento; 
 FILE* arquivo; 
 arquivo = fopen("hash.txt","r"); 
 fseek(arquivo,0,SEEK_END); 
 if(ftell(arquivo) == 0){
  return 0;
 }
 fseek(arquivo,0,SEEK_SET); 
 if(arquivo == NULL){
  return 0; 
 }else{
  while(!feof(arquivo)){
   fscanf(arquivo,"%d",&elemento); 
   insereHash(tab,elemento);
  }
  system("cls");
 }
 fclose(arquivo);
 return 1; 
}



/*O procedimento linhaAnimada tem como parametro duas variaveis do tipo inteiro
uma sera o comprimento e a outra sera o caracter escolhido pelo usuario. 
Sua funcao é desenhar na tela os caracteres escolhidos pelo usuario com um certo
delay*/
void linhaAnimada(int q, int a){
 int j;
 for(j = 1; j <= q; j++){
  _sleep(200);
   printf("%c",a);
 }
}

/*O procedimento linha é similar ao linhaAnimada, mais sem delay*/
void linha(int q, int a){ 
 int j; 
 for(j = 1; j <= q; j++)
  printf("%c",a);
}

/*O procedimento cor recebe como parametro uma variavel do tipo WORD.
sua funcao é possibilitar que o programador modifique as cores do texto
ou do fundo*/
void cor(WORD cor){
 HANDLE SaidaSTD = GetStdHandle(STD_OUTPUT_HANDLE); 
 SetConsoleTextAttribute(SaidaSTD, cor); 
} 

/*O procedimento posicao tem como parametro duas variaveis do tipo inetiro
. Sua funcao é possibilitar que o programador escolha a posicao na tela
que deseja visualizar determinada instrucao.*/
void posicao(int x, int y){
 HANDLE SaidaSTD = GetStdHandle(STD_OUTPUT_HANDLE);
 COORD coord;
 coord.X = x;
 coord.Y = y;
 SetConsoleCursorPosition(SaidaSTD, coord);
}

/*O procedimento menuHash sera uma interface para o usuario visualizar
 e escolher suas opcoes*/
void menuHash(int *num){ 
  system("cls");
  cor(11);posicao(22,1);linha(1,201);linha(41,205);linha(1,187);
  cor(11);posicao(22,2);printf("\272");posicao(64,2);printf("\272");
  cor(15);posicao(40,2);printf("HASH");
  cor(11);posicao(22,3);linha(1,204);linha(41,205);linha(1,185);
  cor(11);posicao(22,4);printf("\272 1 \x1a Gerar numeros aleatoios\t\t\272");
  cor(11);posicao(22,5);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,6);printf("\272 2 \x1a Inserir os numeros aleatorios \t\272");
  cor(11);posicao(22,7);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,8);printf("\272 3 \x1a Buscar chave \t\t\t\272");
  cor(11);posicao(22,9);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,10);printf("\272 4 \x1a Remover chave \t\t\t\272");
  cor(11);posicao(22,11);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,12);printf("\272 5 \x1a Imprimir Hash \t\t\t\272");
  cor(11);posicao(22,13);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,14);printf("\272 6 \x1a Menu Estatistica       \t\t\272");
  cor(11);posicao(22,15);linha(1,204);linha(41,205),linha(1,185);
  cor(11);posicao(22,16);printf("\272 7 \x1a Sair \t\t\t\t\272");
  cor(11);posicao(22,17);linha(1,200);linha(41,205),linha(1,188);
  cor(15);posicao(1,1);printf("\nDigite uma opcao = ");scanf("%d",num);
}

/*O procedimento menuEstatistica sera uma interface para o usuario visualizar
 as e escolher uma das opcoes */
void menuEstatistica(int *num){
  system("cls");
  cor(11);posicao(10,1);linha(1,201);linha(53,205);linha(1,187);
  cor(11);posicao(10,2);printf("\272");posicao(64,2);printf("\272");
  cor(10);posicao(30,2);printf("ESTATISTICAS");   
  cor(11);posicao(10,3);linha(1,204);linha(53,205);linha(1,185);
  cor(11);posicao(10,4);printf("\272 1 \x1a Porcentagem de preenchimento da tabela \t\t\272");
  cor(11);posicao(10,5);linha(1,204);linha(53,205),linha(1,185);
  cor(11);posicao(10,6);printf("\272 2 \x1a Vizualizar as posicoes que ocorreram colisoes\t\272");
  cor(11);posicao(10,7);linha(1,204);linha(53,205),linha(1,185);
  cor(11);posicao(10,8);printf("\272 3 \x1a imprimir determinada posicao\t\t\t\272");
  cor(11);posicao(10,9);linha(1,204);linha(53,205),linha(1,185);
  cor(11);posicao(10,10);printf("\272 4 \x1a Visualizar quantidade de colisoes \t\t\272");
  cor(11);posicao(10,11);linha(1,204);linha(53,205),linha(1,185);
  cor(11);posicao(10,12);printf("\272 5 \x1a Visualiar as posicoes vazias \t\t\t\272");
  cor(11);posicao(10,13);linha(1,204);linha(53,205),linha(1,185);
  cor(11);posicao(10,14);printf("\272 0 \x1a Sair                          \t\t\t\272");
  cor(11);posicao(10,15);linha(1,200);linha(53,205),linha(1,188);
  cor(15);posicao(9,16);printf("Digite uma opcao = ");scanf("%d",num);
}     

/*A funcao porcentagemHash retorna a quantidade em procentagem da tabela que foi
 completada.*/
float porcentagemHash(Hash tab){
 int i;
 float porcent = 0, cont  = 0;
 for(i = 0; i < tam; i++){
  if(tab[i] != NULL){
   cont++;
  }
 }
 porcent = (cont*100)/tam;
 return(porcent);
}

/*O procedimento indiceColisao mostra as posicoes da tabela que ocorreram
colisoes*/
void indiceColisao(Hash tab){
 int i, cont = 0;
 posicao(25,1);printf("\nOcorreram colisoes nas posicoes\n");
 for(i = 0 ; i< tam; i++){
  if(tab[i] != NULL && tab[i]->prox){
   printf("%d\t",i);
  }
 }
 return;
}

/*A fucao quantidadeColisao retorna em variavel do tipo inteiro total de 
colisoes que ocorreram na tabela*/
int quantidadeColisao(Hash tab){
 int i, cont = 0;
 for(i = 0; i < tam; i++){
  Dados* aux = tab[i];
  if(aux != NULL){
    while(aux->prox != NULL){
     cont++;
     aux = aux->prox;
    }
  }
 }
 return cont;
} 
    
 
/*O procedimento posicaoVazias mostra todas as posicoes que apos a insercao
continuam nulas.*/
void posicoesVazias(Hash tab){
 int i, cont = 0;
 posicao(25,1);printf("Posicoes Vazias\n");
 for(i = 0; i < tam; i++){
  if(tab[i] == NULL){
   printf("%d\t",i);
   cont++;
   
  }
 }
 printf("\nTotal de posicoes vazias = %d",cont);
}

/*O procedimento imprimeColisaon mostra uma posicao
e todas as suas colisoes.*/
void imprimeColisao(Hash tab, int pos){
 Dados* aux = tab[pos];
 if(aux == NULL){
  printf("Esta posicao esta vazia!");
  return;
 }else{
  if(aux != NULL){
   printf("%3d",aux->info);
   while(aux->prox != NULL){
    printf(" -> %d",aux->prox->info);
    aux = aux->prox;
   }
  }
 }
}

/*O procedimento numeroAleatorio gera 675 numeros no intervalo 2000 >= X <= 8200
e os armazena no arquivo*/
void numeroAleatorio(){
 int numero,cont = 0;
 FILE* arquivo;
 srand(time(NULL));
 while(cont != 675){
  numero = (rand()%6200)+2000;
  escreverArquivo(arquivo, numero);
  cont++;
 }
}


void lerNumero(int *num){
 system("cls");
 printf("\nDigite a posicao do elemento que deseja verificar = ");
 scanf("%d",num);
}


void lerNumero1(int *num){
 system("cls");
 printf("\nDigite a posicao do elemento que deseja excluir = ");
 scanf("%d",num);
}


void lerNumero2(int *num){
 system("cls");
 printf("Digite a posicao que desejar verificar = ");
 scanf("%d",num);
}


void mensagem(){
  system("cls");
  cor(11);posicao(20,1);linha(1,201);linha(41,205);linha(1,187);
  posicao(20,2);printf("\272");posicao(62,2);printf("\272");
  posicao(20,3);linha(1,200);linha(41,205);linha(1,188);
  cor(10);posicao(26,2);printf("GERANDO NUMEROS ALEATORIOS");
  cor(12);posicao(21,2);linhaAnimada(41,219);
  cor(202);posicao(36,2);printf("CONCLUIDO"); 
  getch();
  cor(1|2|4);
}



void mesagem2(){
  system("cls");
  cor(11);posicao(20,1);linha(1,201);linha(41,205);linha(1,187);
  posicao(20,2);printf("\272");posicao(62,2);printf("\272");
  posicao(20,3);linha(1,200);linha(41,205);linha(1,188);
  cor(10);posicao(26,2);printf("TABELA HASH CRIADA COM SUCESSO");
  getch();;
}  
 

void mensagem3(){
  system("cls");
  cor(11);posicao(20,1);linha(1,201);linha(41,205);linha(1,187);
  posicao(20,2);printf("\272");posicao(62,2);printf("\272");
  posicao(20,3);linha(1,200);linha(41,205);linha(1,188);
  cor(10);posicao(24,2);printf("OS NUMEROS AINDA NAO FORAM GERADOS");
  getch();;
}  

void mensagem4(){
  system("cls");
  cor(11);posicao(20,1);linha(1,201);linha(41,205);linha(1,187);
  posicao(20,2);printf("\272");posicao(62,2);printf("\272");
  posicao(20,3);linha(1,200);linha(41,205);linha(1,188);
  cor(10);posicao(30,2);printf("TABELA NAO FOI CRIADA");
  getch();;
}  
