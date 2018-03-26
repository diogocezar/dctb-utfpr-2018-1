#include <stdio.h>
#include <stdlib.h>
#include "point.h"

int main(){
    Point * p1 = point_create(2.0, 1.0);
    Point * p2 = point_create(3.4, 2.1);
    printf("Imprimindo ponto p1:\n");
    point_print(p1);
    printf("Imprimindo ponto p2:\n");
    point_print(p2);
    printf("Imprimindo a distância entre os pontos:\n");
    point_distance(p1, p2);
    printf("Limpando memória.\n");
    point_free(p1);
    point_free(p2);
}