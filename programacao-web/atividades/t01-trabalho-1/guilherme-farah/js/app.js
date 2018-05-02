/* Guilherme da Silva Farah - AN34A 
   Este é o arquivo que consta a validação do formulário de Contato na página web
   e também para fazer o scroll suave do menu */

const obj = {
    name: null, email: null, phone: null,

    validate: function () {
        this.name = document.querySelector(".name")
        this.email = document.querySelector(".email")
        this.phone = document.querySelector(".phone")           //certo seria usar a funcao, mas não funciona
                                                                //this.validateEmail() == 1 
        if (this.name.value != '' && this.phone.value != '' && this.email.value.search('@') != -1) {
            alert('Formulário Enviado com Sucesso');
        }
        else if (this.name.value == '') {
            alert('Preencher Nome');
        }
        else if (this.phone.value == '') {
            alert('Preencher Telefone');
        }
        else if (this.validateEmail() == 0) {
            alert('Email Inválido');
        }
        window.location.href = ('./index.html#contato');
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