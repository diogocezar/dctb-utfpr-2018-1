# include "hash.c"

main(){
 Hash tab;
 int num, elemento, op,cont = 0, conti = 0;
 FILE* arquivo;
 criarArquivo(arquivo);
 
 while(num != 8) {
  menuHash(&num);
  switch(num){
   case 1:
        if(cont > 0){
         system("cls");
         printf("\nOs Numeros Aleatorios ja foram gerados!\n");
        }else{
             cont++;
             inicializaHash(tab);
             reescreveArquivo(arquivo);
             numeroAleatorio();
             mensagem();
             } 
        break;
   case 2:
        if(cont > 0){
         conti++;
         carregaArquivo(tab);
         mesagem2();
        }else{
              mensagem3();
             }
        break;
   case 3:
        if(conti > 0){
         system("cls");
         lerNumero(&elemento);
         buscaHash(tab,elemento);
         getch();
        }else{
              mensagem4();
             }
         break;
   case 4:
        if(conti > 0){
         system("cls");
         lerNumero1(&elemento);
         removeHash(tab,elemento);
         getch();
        }else{
              mensagem4();
             }
        break;
   case 5:
        if(conti > 0){
         system("cls");
         imprimeHash(tab);
        }else{
              mensagem4();
             }
        getch();
        break;
   case 6:
        op = -1;
        if(conti > 0){
         while(op != 0){
          menuEstatistica(&op);
          switch(op){
           case 0:
                 system("cls");
                 break; 
           case 1:
                system("cls");
                posicao(25,3);printf("%g%% da tabela foi preenchida!\n",porcentagemHash(tab));
                getch();
                break;
           case 2:
               system("cls");
               indiceColisao(tab);
               getch();
               break;
           case 3:
                system("cls");
                lerNumero2(&op);
                imprimeColisao(tab,op);
                getch();
                break;
           case 4:
               system("cls");
               posicao(25,3);printf("Total de colisoes = %d",quantidadeColisao(tab));
               getch();
               break;
           case 5:
               system("cls");
               posicoesVazias(tab);
               getch();
               break;
           default:
                 system("cls");  
                 printf("\nOpcao invalida!");
                 getch();
                 break;
         }
           system("cls");
        }
        }else{
             mensagem4();
             }
       break;
   case 7:
         exit(0);
   default:
           system("cls");
           printf("\nOpcao invalida!\n");
           getch();
           break;
   }
   system("cls");
  }
  
}
        
        
        
