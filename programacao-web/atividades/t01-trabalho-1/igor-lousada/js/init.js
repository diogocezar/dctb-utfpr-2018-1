/* IGOR RICARDO GONÇALVES LOUSADA
RA 1582607
ARQUIVO JAVASCRIPT PARA A VALIDAÇÃO DO FORMULÁRIO "CONTATO" DA PÁGINA INDEX. ATRAVÉS DA FUNÇÃO validaCadastro(), verifica os campos nome e email e apresenta as menagens de erro. 
*/

var form = document.getElementById("form-contato");
 
if (form.addEventListener) {                   
    form.addEventListener("submit", validaCadastro);
} else if (form.attachEvent) {                  
    form.attachEvent("onsubmit", validaCadastro);
}
 
function validaCadastro(evt){
	var nome = document.getElementById('nome');
	var email = document.getElementById('email');
	var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	var contErro = ;
 
 
	/* Validação do campo nome */
	caixa_nome = document.querySelector('.msg-nome');
	if(nome.value == ""){
		caixa_nome.innerHTML = "Favor preencher o Nome";
		caixa_nome.style.display = 'block';
		contErro += 1;
	}else{
		caixa_nome.style.display = 'none';
	}
 
	/* Validação do campo email */
	caixa_email = document.querySelector('.msg-email');
	if(email.value == ""){
		caixa_email.innerHTML = "Favor preencher o E-mail";
		caixa_email.style.display = 'block';
		contErro += 1;
	}else if(filtro.test(email.value)){
		caixa_email.style.display = 'none';
	}else{
		caixa_email.innerHTML = "Formato do E-mail inválido";
		caixa_email.style.display = 'block';
		contErro += 1;
	}	
 
	if(contErro > ){
		evt.preventDefault();
	}
}