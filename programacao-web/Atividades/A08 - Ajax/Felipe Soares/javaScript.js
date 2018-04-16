$(document).ready(function() {
  var action = 'https://diogocezar.github.io/bazar/json/database.json';
  $.ajax({
    type: 'GET',
    url: action,
    data: [],
    success: function (data) {
      $('#cabecalho').append('<h1 id="titlelogo">'+data.configs.title+'</h1');
      $('#cabecalho').append('<h3>'+data.configs.subTitle+'</h3');
      $('#cabecalho').append('<p>E-mail: '+data.configs.email+'</p');
      $('#cabecalho').append('<p>Telefone: '+data.configs.phone+'</p');
      for(i = 0; i < data.configs.description.length; i++){
        if(i != 2)
          $('#cabecalho').append('<p>'+data.configs.description[i].p+'</p>');
        else
          $('#cabecalho').append('<h3>'+data.configs.description[i].h2+'</h3>');
      }
      for(i=0; i<data.products.length; i++){
        $('#produto'+[i]).append('<h2>' + data.products[i].name + '</h2>');
        $('#produto'+[i]).append('<img src="'+data.products[i].image+'"/>');
        for(j=0 ; j<data.products[i].description.length; j++){
          if(data.products[i].description[j].h4)
            $('#produto'+[i]).append('<h4>' + data.products[i].description[j].h4 + '</h4>');
          else
            $('#produto'+[i]).append('<p>' + data.products[i].description[j].p + '</p>');
          }
          $('#produto'+[i]).append('<p id="preco">R$'+data.products[i].price+',00</p>');
          $('#produto'+[i]).append('<a id="btnComprar" href="mailto:'+data.configs.email+'?subject=[QUERO COMPRAR]' + data.products[i].name + '&body=Olá, estou interessado no produto ' + data.products[i].name + ' por R$'+data.products[i].price+',00.">COMPRAR</a>');
      }
    },
    error: function (data) {
      alert("Erro na leitura");
    }
  });
});
