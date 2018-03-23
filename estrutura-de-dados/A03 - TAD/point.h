/**
  * Criação de um TAD para a manipulação de um ponto
  * Diogo Cezar <diogo@diogocezar.com>
  */


/**
  * Estrutura
  */

typedef struct point{
    float x;
    float y;
} Point;

/**
  * Protótipos
  */

Point * point_create(float x, float y);

void point_free(Point * p);

void point_print(Point * p);

float point_distance(Point * a, Point *b);

/**
  * Implementação
  */

Point * point_create(float x, float y){
    Point * p = (Point*) malloc(sizeof(Point));
    if(p == NULL){
        printf("Houve um erro na criação do ponto.\n");
        exit(1);
    }
    p->x = x;
    p->y = y;
    return p;
}

void point_free(Point * p){
    free(p);
    printf("Ponto removido com sucesso.\n");
}

void point_print(Point * p){
    printf("X: %f, Y: %f\n", p->x, p->y);
}

float point_distance(Point * a, Point *b){
    // implements here
    printf("A distância entre os pontos é: %f\n", 0.0);
}