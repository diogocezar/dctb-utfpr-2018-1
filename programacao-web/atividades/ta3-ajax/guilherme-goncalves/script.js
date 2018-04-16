var titulo = document.getElementById("titulo"),
saida = document.getElementById("saida");

var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', 'https://diogocezar.github.io/bazar/json/database.json');
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.responseText);
    renderHTML(ourData);
};
ourRequest.send();

function renderHTML(data){
    var htmlString = "";
   
    
    htmlString += "<h1>" + data.configs.title + "</h1>";
    htmlString += "<h2>" + data.configs.subTitle + "</h2>";
    htmlString += "<p><a href='#'>" + data.configs.email + "</a></p>";
    htmlString += "<p>" + data.configs.phone + "</p>";
   
    htmlString += "<p>" + data.configs.description[0].p + "</p>";
    htmlString += "<p>" + data.configs.description[1].p + "</p>";
    htmlString += "<h2>" + data.configs.description[2].h2 + "</h2>";
    htmlString += "<p>" + data.configs.description[3].p + "</p>";

    for(i = 0; i < data.products.length; i++){
        htmlString += "<h4>" + data.products[i].name + "</h4>";
        htmlString += "<center><img src =" + data.products[i].image + "></center>";
        for(j = 0; j < data.products[i].description.length; j++){
            if(data.products[i].description[j].p){
             htmlString += "<p>" + data.products[i].description[j].p + "</p>";
            }
            else if(data.products[i].description[j].h4){
                htmlString += "<h4>" + data.products[i].description[j].h4 + "</h4>";
            }
        }
        htmlString += "<h4>Preço: R$" + data.products[i].price + "</h4>";
    }
    
    titulo.innerHTML = data.configs.title;
    saida.innerHTML = htmlString;
}
