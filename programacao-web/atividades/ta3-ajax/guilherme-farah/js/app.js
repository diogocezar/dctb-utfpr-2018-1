
function json(){
	var qtdProds, saida

	// Resgatar valores.
	json.prototype.resgatarValores = function(){
		$('#resultado').html('Carregando dados...')

		// Estrutura de resultado.
		$.getJSON('./database.json', function(data){

			this.qtdProds = data.products.length
			this.saida = ''

			this.saida += data.configs.title + '</br>'
			this.saida += data.configs.subTitle + '</br>'
			this.saida += data.configs.email + '</br>'
			this.saida += data.configs.subject + '</br>'
			this.saida += data.configs.bodyMail + '</br>'
			this.saida += data.configs.bodyWhats + '</br>'
			this.saida += data.configs.url + '</br>'
			this.saida += data.configs.phone + '</br></br>'

			for(var x=0; x<data.configs.description.length; x++){
				if (data.configs.description[x].p){
					this.saida += data.configs.description[x].p + '<br/>'
				}
				else if (data.configs.description[x].h2){
					this.saida += '</br>' + data.configs.description[x].h2 + '<br/></br>'
				}
			}

			for (i = 0; i < this.qtdProds; i++){
				this.saida += 'Produto: ' + data.products[i].name + '<br/>'
				this.saida += '<img src="' + data.products[i].image + '" class="img-decorative" alt="Produto"/>'+'<br/>'
				for(j=0; j<data.products[i].description.length; j++){
					if (data.products[i].description[j].p){
						this.saida += data.products[i].description[j].p + '<br/>'
					}
					else if (data.products[i].description[j].h4){
						this.saida += '</br>' + data.products[i].description[j].h4 + '<br/></br>'
					}
				}
				this.saida += 'Por: R$' + data.products[i].price + ',00' + '<br/><br/>'
			}

			$('#resultado').html(this.saida)
		});

	}

}

// Objeto
var obj = new json()
obj.resgatarValores()