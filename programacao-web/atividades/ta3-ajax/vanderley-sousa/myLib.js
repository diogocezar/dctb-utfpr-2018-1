 $(document).ready(function(){
       $.getJSON("https://diogocezar.github.io/bazar/json/database.json",function(json){   
           var infopessoal = json.configs;
           $('#listmenu').append('<li id="titlelogo">'+infopessoal.title+'</li');
           $('#cabecalho').append('<h3>'+infopessoal.subTitle+'</h3');
           $('#cabecalho').append('<p>E-mail: '+infopessoal.email+'</p');
           $('#cabecalho').append('<p>Telefone: '+infopessoal.phone+'</p');

           var descconfig = infopessoal.description;
           for(var i=0 ; i<descconfig.length ; i++){
             if(i==2){
               $('#cabecalho').append('<h3>'+descconfig[i].h2+'</h3>');
             }else{
               $('#cabecalho').append('<p>'+descconfig[i].p+'</p>');
             }
           }

           var produto = json.products;

           for(var i=0; i<produto.length; i++){
               $('#produto'+[i]).append('<h2>' + produto[i].name + '</h2>');
               $('#produto'+[i]).append('<img src="'+produto[i].image+'"/>');  

               var description = produto[i].description;
               
               for(var j=0 ; j<description.length ; j++){
                if(description[j].h4) continue;
                 if(i==0){
                   if(j==0 || j==9 || j==15 || j==19){
                     $('#produto'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#produto'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                 if(i==1|| i==5){
                   if(j==0){
                     $('#produto'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#produto'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                 if(i==2){
                   if(j==0){
                     $('#produto'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#produto'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                 if(i==3){
                   if(j==0 || j==2){
                     $('#produto'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#produto'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                 if(i==4){
                   if(j==0){
                     $('#produto'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#produto'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
               }
               $('#produto'+[i]).append('<p>R$'+produto[i].price+',00</p>');
               $('#produto'+[i]).append('<a id="btnComprar" href="mailto:'+infopessoal.email+'?subject=[QUERO COMPRAR]' + produto[i].name + '&body=Olá, estou interessado no produto ' + produto[i].name + ' por R$'+produto[i].price+',00.">COMPRAR</a>');
           }          
      });
   });