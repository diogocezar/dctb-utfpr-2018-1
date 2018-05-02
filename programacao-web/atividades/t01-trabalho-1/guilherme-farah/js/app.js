/* Guilherme da Silva Farah - AN34A 
   Este é o arquivo que consta a validação do formulário de Contato na página web
   e também para fazer o scroll suave do menu */

const obj = {
    name: null, email: null, subject: null,

    validate: function () {
        this.name = $(".yourname").val();
        this.email = document.querySelector(".email")
        this.subject = document.querySelector(".subject")       

        if (this.name.value == null) 
            $(".yourname").css("border-color", "red");
        else
            $(".yourname").css("border-color", "black");
        if (this.subject.value != '')
            $(".subject").css("border-color", "black");
        else
            $(".subject").css("border-color", "red");
        if (this.email.value.search('@') != -1)
            $(".email").css("border-color", "black");
        else
            $(".email").css("border-color", "red");
                                                                //certo seria usar a funcao, mas não funciona
                                                                //this.validateEmail() == 1 
        if (this.name.value != '' && this.subject.value != '' && this.email.value.search('@') != -1){
            $(".warning").html("Mensagem enviada com sucesso!").css("margin-right", "2.5em");
            $(".warning").show();
        }
    },

    validateEmail: function () {
        var usuario = this.email.value.substring(0, this.email.value.indexOf('@'));
        var dominio = this.email.value.substring(this.email.value.indexOf('@') + 1, this.email.value.length);
        if ((usuario.length >= 3) && //se o tamanho do usuario for maior ou igual a 3
            (dominio.length >= 3) && //se o tamanho do dominio for maior ou igual a 3
            (usuario.search(" ") == -1) && // se o usuario não conter espaço
            (dominio.search(" ") == -1) && // se o dominio não conter espaço
            (dominio.search(".") != -1) && // se o dominio conter pelo menos 1 .
            (dominio.indexOf(".") >= 3) && // se a posicao do ponto for maior ou igual a 3
            (dominio.lastIndexOf(".") < dominio.length - 1)) { // e se o ultimo ponto for menor q tamanho do domino -1
            // então o email é valido
            return 1;
        }
        else {
            return 0;
        }
    },

    init: function () {
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
        
                document.querySelector(this.getAttribute('href')).scrollIntoView({
                    behavior: 'smooth', block: 'start'
                });
            });
        });
        
        var btn = document.querySelector("#send");
        btn.addEventListener('click', this.validate);
    }
}

obj.init();