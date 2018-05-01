A = {
    scroll: null,
    valForms: null,
    init: function () {
        A.scroll();
        A.valForms();
    },
    scroll: function () {
        jQuery(document).ready(function () {
            $(".ancora").click(function (e) {
                e.preventDefault();
                var id = $(this).attr('href'),
                    targetOffset = $(id).offset().top;
                $('html,body').animate({
                    scrollTop: targetOffset
                }, 1000);
            });
        })
    },
    valForms: function () {
        jQuery(document).ready(function () {
            var form = document.getElementById('formContact');
            form.addEventListener("click", validar);
            function validar(e) {
                var nome = document.getElementById('input_nome'),
                    email = document.getElementById('input_email'),
                    assunto = document.getElementById('assunto'),
                    contErr = 0,
                    filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                /*Validar nome*/
                box_name = document.querySelector('.msg-nome');
                if (nome.value == "") {
                    box_name.innerHTML = "Preencha o nome";
                    box_name.style.display = 'block';
                    contErr++;
                } else {
                    box_name.style.display = 'none';
                }
                /*validar email*/
                box_email = document.querySelector('.msg-email');
                if (email.value == "") {
                    box_email.innerHTML = "Preencha o email";
                    box_email.style.display = 'block';
                    contErr++;
                } else if (filtro.test(email.value)) {
                    box_email.style.display = 'none';
                } else {
                    box_email.innerHTML = "Formato invalido!!";
                    box_email.style.display = 'block';
                    contErr++;
                }
                /*validar assunto*/
                box_assunto = document.querySelector('.msg-assunto');
                if (sexo.value == "") {
                    box_assunto.innerHTML = "Favor preencher assunto";
                    box_assunto.style.display = 'block';
                    contErr++;
                } else {
                    box_assunto.style.display = 'none';
                }

                if (contErr > 0) {
                    evt.preventDefault();
                } else {
                    document.getElementById("msg-ok").innerHTML = "MENSAGEM ENVIADA!!";;
                }
            }
        })
    }
}
A.init();