
//Função baseada em um exemplo da internet
function json(){
	var qtd;
	var retorno;

	// Resgatar valores.
	//Criando protótipo da função para um objeto acessa-la
	json.prototype.resgatarValores = function(){
		$('#resultado').html('Carregando dados...');


		// Estrutura de resultado.
		$.getJSON('https://diogocezar.github.io/bazar/json/database.json', function (data) {

			this.qtd = data.products.length;
			this.retorno = '';

			this.retorno += data.configs.title;
			this.retorno += '</br>'+data.configs.subTitle;
			this.retorno += '</br></br>Email: '+data.configs.email;
			
			
			
			this.retorno += '</br></br>'+data.configs.url;
			this.retorno += '</br></br>'+'Telefone para contato: '+data.configs.phone;
			this.retorno += '</br></br>'+data.configs.description[0].p;



			$('#info').html(this.retorno);


			//Resetando a string retorno, para percorrer os produtos
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'Produto: ' + data.products[i].name + '<br/>';
				this.retorno += '<img class="resolucao" src="' + data.products[i].image + '" class="img-decorative" alt="Produto"/>'+'<br/>';
				for(j=0;j<data.products[i].description.length;j++){
					this.retorno += 'Descrição: ' + data.products[i].description[j].p + '<br/>';
				}

				this.retorno += 'Preço: R$' + data.products[i].price + ',00' + '<br/><br/>';
			}
				

			$('#resultado').html(this.retorno);
		});

	}

}

// Objeto.
var obj = new json();
obj.resgatarValores();