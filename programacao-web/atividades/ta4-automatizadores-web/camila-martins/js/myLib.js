 $(document).ready(function(){
       $.getJSON("https://diogocezar.github.io/bazar/json/database.json",function(json){
           console.log(json);
   
           var configs = json.configs;
           console.log(configs);
           $('#id01').append('<h1 id="bigTitle">'+configs.title+'</h1');
           $('#id01').append('<h3>'+configs.subTitle+'</h3');
           $('#id01').append('<p>'+configs.email+'</p');
           $('#id01').append('<p>'+configs.phone+'</p');
           var descConfigs = configs.description;
           console.log(descConfigs);
           for(var i=0 ; i<descConfigs.length ; i++){
             if(i==2){
               $('#id01').append('<h2>'+descConfigs[i].h2+'</h2>');
             }else{
               $('#id01').append('<p>'+descConfigs[i].p+'</p>');
             }
           }
           var products = json.products;
           console.log(products);
           for(var i=0; i<products.length; i++){
               console.log(products[i]);
               $('#products'+[i]).append('<h3>' + products[i].name + "</h3>");
               $('#products'+[i]).append('<img id "imageProducts" src="'+products[i].image+'"/>');  
               var description =products[i].description;
               console.log(description);
               for(var j=0 ; j<description.length ; j++){
                 if(i==1){
                   if(j==0 || j==9 || j==15 || j==19){
                     $('#products'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#products'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                 if(i==0|| i==2 || i==3 ||i==5|| i==6){
                   if(j==0){
                     $('#products'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#products'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
                                 
                 if(i==4){
                   if(j==0 || j==2){
                     $('#products'+[i]).append('<h4>' + description[j].h4 + '</h4>');
                   }else{
                   $('#products'+[i]).append('<p>' + description[j].p + '</p>');
                   }
                 }
               }
               $('#products'+[i]).append('<p>R$'+products[i].price+',00</p>');
               $('#products'+[i]).append('<a id="btnBuy" href="mailto:'+configs.email+'?subject='+configs.subject + products[i].name + '&body='+configs.bodyMail + products[i].name + ' por R$'+products[i].price + ',00.">COMPRAR</a>');
           }
           console.log(str.join());
           
      });
   });