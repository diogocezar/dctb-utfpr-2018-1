/* Caio Vinícius Pertile Moreti   AN34A-N14 

Esse arquivo contém todo o arquivos fonte de javascript para 
realizar a validação do formulário, exibindo a mensagem
de sucesso, bem como o menu de ancoragem, realizando
um scroll suave
*/

const validation = {
    name : null,
    email : null,
    assunto : null,
    mensagem : null,
    validate: function(){
        validation.name = document.querySelector("#contact-name");
        validation.email = document.querySelector("#contact-email");
        validation.assunto = document.querySelector("#contact-assunto");
        validation.envio = document.querySelector("#aguarda");

        if (validation.name.value != '' && validation.email.value != '' && validation.assunto.value != '')
            document.getElementById("aguarda").innerHTML = "Enviado com sucesso";

        else{
            alert('Não foi enviado!');
        }
    },
    init: function(){
        var btn = document.querySelector("#send");
        btn.addEventListener('click', validation.validate);
    }
}
validation.init();

var $doc = $('html, body');
$('.go-menu').click(function() {
    $doc.animate({
        scrollTop: $( $.attr(this, 'href') ).offset().top
    }, 500);
    return false;
});
