window.onload = function(e){
	const URL_TO_FETCH = "https://diogocezar.github.io/bazar/json/database.json";
	fetch(URL_TO_FETCH)
	.then(function(response) { return response.json(); })
	.then(function(json){
		var configs = document.getElementsByClassName("configs");
		var products = document.getElementsByClassName("products");
		configs[0].innerHTML = fillConfigs(json.configs);
		json.products.forEach(function(element){
			products[0].innerHTML += fillProducts(element);
		});
	})
	const fillConfigs = function(c){
		var title = `<h1>${c.title}</h1>`;
		var subtitle = `<h2>${c.subTitle}</h2>`;
		var email = `<p><a href="mailto:${c.email}">${c.email}</a></p>`;
		var phone = `<p><a href="tel:${c.phone}">${c.phone}</a></p>`;
		var descr = fillDescr(c.description);
		var r = `${title} ${subtitle} ${email} ${phone} ${descr}`;
		return r;
	}
	const fillProducts = function(p){
		var active = p.active;
		var name = `<h2><b>${p.name}</b></h2>`;
		var img = `<img src="${p.image}"/>`;
		var desc = fillDescription(p.description);
		var price = `<h2 class="price">R$${p.price},00</h2>`;
		var comprar = `<a href="mailto:diogo@diogocezar.com?subject=[QUERO COMPRAR] ${p.name}&amp;body=Olá, estou interessado no produto: ${p.name} por ${p.price}"><button class="button">Comprar</button></a>`;
		if(active){
			var element = `<div class="elementList">${name} ${img} ${desc} ${price} ${comprar}</div>`;
			return element;
		}else{
			var element = `<div class="elementListFalse">${name} ${img} ${desc} ${price} ${comprar}</div>`;
			return element;
		}
	}
	const fillDescr = function(d){
		let html = "";
		d.forEach(function(element){
			var verificar = verificacao(JSON.stringify(element));
			if (verificar == "h2") {
			 	html += `<h2>${element.h2}</h2>`;
			}else{
			 	html += `<p>${element.p}</p>`;
			}
		})
		return `<div class="descr">${html}</div>`;
	}
	const fillDescription = function(d){
		let html = "";
		d.forEach(function(element){
			var verificar = verificacao(JSON.stringify(element));
			if (verificar == "h4") {
			 	html += `<h4><b>${element.h4.toUpperCase()}</b></h4>`;
			}else{
			 	html += `<p>${element.p}</p>`;
			}
		})
		return `<div class="description">${html}</div>`;
	}
	const verificacao = function(element){
		var x = element.substring(2, 4);
		return x;
	}
};