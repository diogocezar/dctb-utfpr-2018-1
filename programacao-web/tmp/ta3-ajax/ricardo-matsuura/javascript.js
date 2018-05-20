$(document).ready(function(){
	var action = 'https://diogocezar.github.io/bazar/json/database.json';
	$.ajax({
		type: 'GET',
		url: action,
		data: [],
		success: function(data) {
			$('#header1').append('<h1>'+data.configs.title+'</h1>');
			$('#header2').append('<h2>"'+data.configs.subTitle+'</h2>');
			$('#header3').append('<p>'+data.configs.email+'</p>');
			$('#header3').append('<p>'+data.configs.phone+'</p>');
			for(i = 0; i<data.configs.description.length; i++){
				if(i==2)
					$('#header3').append('<h3>'+data.configs.description[i].h2+'</h3>');
				else
					$('#header3').append('<p>'+data.configs.description[i].p+'</p>');
			}
			for(j = 0; j<data.products.length; j++){
				$('#product'+[j]).append('<h3>'+data.products[j].name+'</h3>');
				$('#product'+[j]).append('<img src="'+data.products[j].image+'"/>');
				for(k = 0; k<data.products[j].description.length;k++){
					if(data.products[j].description[k].h4)
						$('#product'+[j]).append('<h4>'+data.products[j].description[k].h4+'</h4>');
					else
						$('#product'+[j]).append('<p>'+data.products[j].description[k].p+'</p>');
				}
				$('#product'+[j]).append('<p>R$ '+data.products[j].price+'</p>');				
			}
		}, 
	});
});