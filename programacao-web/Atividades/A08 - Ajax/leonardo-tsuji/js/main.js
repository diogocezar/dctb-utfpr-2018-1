$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: 'https://diogocezar.github.io/bazar/json/database.json',
		success: function(data){
			var user = JSON.parse(data);
			console.log();
		}
	});
});