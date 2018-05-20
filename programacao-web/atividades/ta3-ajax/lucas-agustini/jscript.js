// Nao consigo manipular dados vindo do fetch
// const URL_TO_FETCH = 'https://diogocezar.github.io/bazar/json/database.json';
// fetch(URL_TO_FETCH, {
//   method: 'get' // opcional 
// })
// .then(function(response) { 
//   response.json().then(function(data){
//       console.log(data);
//       console.log("teste");
//     });
// })
// .catch(function(err) { 
//   console.error(err); 
// });


//tentativa jquery baseado na internet
$(document).ready(function(){
	$.getJSON("https://diogocezar.github.io/bazar/json/database.json", function(data){
		var dadosPadrao;
		var dadosDescricao ='';
		var dadosProduto = '';
		// var produtoNome = [];
		// var produtoDesc = [];
		// var produtoFoto = [];

		//mostrando os dados que usarei do json
		console.log(data.configs);
		console.log(data.products);
		//console.log(this.dadosDescricao); nao sei pq esta com undefined

		//pegando os dados de informaçao padrao
		this.dadosPadrao = data.configs.title+ '<br>';
		this.dadosPadrao += data.configs.subTitle+ '<br>';
		this.dadosPadrao += data.configs.email;

		for(d = 0; d < data.configs.description.length; d++){
			if (d == 2) {
				continue;
			}
			dadosDescricao += data.configs.description[d].p+ '<br>';
		}
		console.log(dadosDescricao);

		//pegando nomes, imagens e descriçoes dos produtos (concatenando)
		for(i = 0; i<data.products.length ;i++){
			dadosProduto += '<br><br>Produto : '+ data.products[i].name+ '<br>';
			dadosProduto += '<img class = "foto" src = "'+data.products[i].image +'" '+'<br>';
				for(j = 0; j < data.products[i].description.length; j++){
					if (data.products[i].description[j].h4)
						dadosProduto += '<br><br>'+ data.products[i].description[j].h4 +'<br>';
					else if (data.products[i].description[j].p)
						dadosProduto += data.products[i].description[j].p +'<br>';
				}
			dadosProduto += 'Valor em Temers: ' +data.products[i].price +'<br>';

		}
			console.log(dadosProduto);

		$('#padrao').html(this.dadosPadrao);
		$('#descricao').html(dadosDescricao);
		$('#produto').html(dadosProduto);

		// for(i = 0; i<data.products.length ;i++){
		// 	produtoNome[i] = data.products[i].name;
		// 	produtoDesc[i] = data.products[i].description;
		// 	produtoFoto[i] = data.products[i].image;
		// }
		// 	console.log(produtoNome);
		// 	console.log(produtoDesc);

		// for(i = 0; i<data.products.length ;i++){
		//  	document.getElementById("produto"+i).innerHTML = produtoNome[i];
		// 	//document.getElementById("produto"+i).innerHTML = produtoFoto[i];
		// }	
	}
	)
}
)
	