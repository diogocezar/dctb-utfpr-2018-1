var bazarContainerInfo = document.getElementById("bazar-info");
var bazarContainerProdutos = document.getElementById("bazar-produtos");

var ourRequest = new XMLHttpRequest();
ourRequest.open('GET', 'https://diogocezar.github.io/bazar/json/database.json');
ourRequest.onload = function(){
    var ourData = JSON.parse(ourRequest.responseText);
    renderHTML(ourData);
};
ourRequest.send();

function renderHTML(data){
    var htmlStringInfo = "";
    var htmlStringProducts = "";
    
    htmlStringInfo += "<h1>" + data.configs.title + "</h1>";
    htmlStringInfo += "<h2>" + data.configs.subTitle + "</h2>";
    htmlStringInfo += "<p>" + data.configs.email + "</p>";
    htmlStringInfo += "<p>" + data.configs.phone + "</p>";
   
    htmlStringInfo += "<p>" + data.configs.description[0].p + "</p>";
    htmlStringInfo += "<p>" + data.configs.description[1].p + "</p>";
    
    for(i = 0; i < data.products.length; i++){
        htmlStringProducts += "<h4>" + data.products[i].name + "</h4>";
        htmlStringProducts += "<img src =" + data.products[i].image + ">";
        for(j = 0; j < data.products[i].description.length; j++){
            if(data.products[i].description[j].p){
             htmlStringProducts += "<p>" + data.products[i].description[j].p + "</p>";
            }
            else{
                htmlStringProducts += "<h4>" + data.products[i].description[j].h4 + "</h4>";
            }
        }
        htmlStringProducts += "<h4>Preço: R$" + data.products[i].price + "</h4>";
    }
    
    bazarContainerInfo.innerHTML = htmlStringInfo;
    bazarContainerProdutos.innerHTML = htmlStringProducts;
}