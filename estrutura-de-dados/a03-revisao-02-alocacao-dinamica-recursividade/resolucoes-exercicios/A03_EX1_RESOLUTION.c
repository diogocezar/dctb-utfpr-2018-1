#include<stdio.h>
#include<stdlib.h>

typedef struct Clients{
    char name[50];
    int  age;
}Clients;

void readClients(Clients * vClients, int num){
    int i;
    for(i=0;i<num;i++){
        printf("Type the name: \n");
        /**
         * Notem que, vClients[i].name já é o ponteiro para o primeiro elemento do vetor
         * por isso, não precisa do &
         */
        scanf("%s", vClients[i].name);

        // scanf("%s", &vClients[i].name);
        // ^ Isso é errado pois iremos obter o endereço de memória do ponteiro!

        printf("Type the age: \n");
        /**
         * Notem que, vClients[i].age é um tipo de dado
         * precisamos passar o seu endereço de memória, por isso precisamos do &
         */
        scanf("%d", &vClients[i].age);
    }
}

void printClients(Clients * vClients, int num){
    int i;
    for(i=0;i<num;i++){
        printf("Name: %s\n", vClients[i].name);
        printf("Age: %d\n", vClients[i].age);
    }
}

int main(){
    int numberOfClients = 2;

    Clients * list = malloc(numberOfClients*sizeof(Clients));

    if(list == NULL){
        printf("Alocation Error!\n");
        exit(1);
    }

    readClients(list, numberOfClients);
    printClients(list, numberOfClients);

    return 0;
}