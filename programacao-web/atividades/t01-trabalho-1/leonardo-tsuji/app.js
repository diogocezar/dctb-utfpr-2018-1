/*Leonardo Hideki Koga Tsuji - N14 - Contém funções em JavaScript para funcionalidades dos botões, validar formulários*/

function redirecionar(){
	location.href = 'index.html#contato';
}

const validarFormulario = {
	nome : null,
	email : null,
	assunto : null,
	mensagem : null,
	validate: function(){ 
		validarFormulario.nome = document.querySelector('#nome');
		validarFormulario.email = document.querySelector('#email');
		validarFormulario.assunto = document.querySelector('#assunto');
		validarFormulario.mensagem = document.querySelector('#mensagem');

		if(validarFormulario.nome.value != '' && validarFormulario.email.value != '' && validarFormulario.assunto.value != '')
			alert('Formulário enviado');
		else{
			validarFormulario.nome.style.borderColor = 'red';
			validarFormulario.email.style.borderColor = 'red';
			validarFormulario.assunto.style.borderColor = 'red';
		}
	}, 
	init: function(){
		var btn = document.querySelector("#envia");
		btn.addEventListener('click', validarFormulario.validate);
	}
}

validarFormulario.init();

$(document).ready(function(){
	$(".link").click(function(event){
		event.preventDefault();
		$('html, body').animate({scrollTop: $(this.hash).offset().top}, 1000);
	});
});	