/*
    Nome: Felipe Soares da Silva
    R.A: 1478613
    Turma: N14
    Aqui eu faço toda a parte de validação dos formulários, e faço a "Ancora"
*/



function Volta(){
	location.href = 'index.html#contato';
}

const valida = {
    assunto : null,
	nome : null,
	email : null,
	mensagem : null,
	validate: function(){ 
		valida.nome = document.querySelector('#nome');
		valida.email = document.querySelector('#email');
		valida.assunto = document.querySelector('#assunto');
		valida.mensagem = document.querySelector('#mensagem');

        if(valida.nome.value != '' && valida.email.value != '' && valida.assunto.value != '') 
            alert('Formulário enviado');
		else{
			valida.nome.style.borderColor = 'red';
			valida.email.style.borderColor = 'red';
			valida.assunto.style.borderColor = 'red';
		}
	}, 
	init: function(){
		var botao = document.querySelector("#envia");
		botao.addEventListener('click', valida.validate);
	}
}

valida.init();

$(document).ready(function(){
	$(".link").click(function(event){
		event.preventDefault();
		$('html, body').animate({scrolltop: $(this.hash).offset().top}, 1000);
	});
});	