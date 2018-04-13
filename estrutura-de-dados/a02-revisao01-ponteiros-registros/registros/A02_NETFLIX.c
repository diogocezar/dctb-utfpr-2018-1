#include <stdio.h>
#include <string.h>

#define SIZE 2

typedef struct NetFlix{
    char title[50];
    char genre[50];
    int duration;
    int like;
} MyMovies;

void printData(MyMovies[], int);
void readData(MyMovies[], int);

int main(){
    MyMovies dataMovies[SIZE];
    readData(dataMovies, SIZE);
    printData(dataMovies, SIZE);
    return 0;
}

void printData(MyMovies movies[], int size){
    int i;
    printf("\n\nDados dos filmes informados: \n");
    for(i = 0; i<size; i++){
        printf("Titulo: %s \nGenero: %s \nDuracao: %d \nCurtidas: %d \n\n", movies[i].title, movies[i].genre, movies[i].duration, movies[i].like);
    }
}

void readData(MyMovies movies[], int size){
    int i;
    for(i = 0; i<size; i++){
        printf("\nInforme o titulo do filme: ");
        scanf("%s", movies[i].title);
        printf("Informe o genero do filme: ");
        scanf("%s", movies[i].genre);
        printf("Informe a duracao do filme em minutos: ");
        scanf("%d", &movies[i].duration);
        printf("Informe a quantidade de curtidas do filme: ");
        scanf("%d", &movies[i].like);
    }
}