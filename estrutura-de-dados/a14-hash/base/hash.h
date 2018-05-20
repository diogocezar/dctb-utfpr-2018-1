#define tam 677

/*hash.h armazena a estrutura e os prototipos das funcaoes*/
struct dados{
  int info;
  struct dados *prox;
};

typedef struct dados Dados;
typedef Dados* Hash[tam];

int funcaoHash(int num);/**/
void inicializaHash(Hash tab); /**/
void insereHash(Hash tab,int num);
void buscaHash(Hash tab, int num);
void imprimeHash(Hash tab);
void removeHash(Hash tab, int num);

void criarArquivo(FILE* arquivo);
void reescreveArquivo(FILE* arquivo);
void escreveArquivo(FILE* arquivo, int elemento);
int carreagaArquivo(Hash tab);

void linhaAnimada(int q, int a);
void linha(int q, int a);
void cor(WORD cor);
void posicao(int x, int y);
void menuHash(int *num);
void menuEstatistica(int *num);

float porcentagemHash(Hash tab);
void indiceColisao(Hash tab);
int quantidadeColisao(Hash tab);
void posicoesVazias(Hash tab);
void imprimeColisao(Hash tab, int pos);

void numeroAleatorio();
void lerNumero(int *num);
void lerNumero1(int *num);
void lerNumero2(int *num);
void mensagem();
void mesagem2();
void mensagem3();
void mensagem4();

