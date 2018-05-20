Mps = {
    function validarFormulario(){
        var verificar=true;
        var formulario = document.getElementById("formulario");
        var nome = document.getElementById("nome");
        var email = document.getElementById("email");
        var assunto = document.getElementById("ast");
        var mensagem = document.getElementById("msg");	
        if((!nome.value)&&(!email.value)&&(!assunto.value)){
            alert("Complete os dados obrigatórios.");
        } else {
            alert("Enviado com sucesso.");
        }
        
    window.onload=function(){
        var btnEnviar=document.getElementById("enviar");
        btnEnviar.onclick=validarFormulario;
    }