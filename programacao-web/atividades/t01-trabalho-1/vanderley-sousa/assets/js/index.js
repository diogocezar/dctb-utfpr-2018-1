//Nome: Vanderley Sousa da Silva Junior
//RA: 1885022
//Turma: N14
//Este arquivo contém os códigos JavaScript da página principal.

Mps = {
    ancora: null,
    validaform: null,
    init: function () {
        Mps.validaform();
        Mps.ancora();
    },

    //Menu ancorado deslizante que funciona com tags que contenham a class 'go-menu'.
    ancora: function(){
        jQuery(document).ready(function($) { 
            $(".go-menu").click(function(event){        
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top}, 600);
           });
        });
    },

    //Válidar formulário de contato
    validaform: function(){
        var checkform = function(){
            var nome = form.nome.value;
            var email = form.email.value;
            var assunto = form.assunto.value;
            if(nome != '' && email != '' && assunto != ''){
                alert('Enviado com sucesso.');
                form.submit();
            } else {
                if(nome == ''){
                    alert('Nome é obrigatório.');
                }
                if(email == ''){
                    alert('Email é obrigatório.');
                }
                if(assunto == ''){
                    alert('Assunto é obrigatório.');
                }
            }
        }
        jQuery(document).ready(function($) { 
            $("#btnEnviar").click(function(event){        
                event.preventDefault();
                checkform();
           });
        });
    }
}
Mps.init();