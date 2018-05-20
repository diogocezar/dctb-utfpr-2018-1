// Matheus Ferreira Flausino 1582623

/*
** Para o form foi utilizado a verificação do navegador
** Foi ultilizado o requere e a validação do email foi feita pelo navegador atraves do tipo email do input
** Foi adicionado evento de Submit ao form da pagina
** Onde é verificado se o formulario é valido atraves da função checkValidity
** A função checkValidity retorna True se a verificação do navegador estiver tudo certo
** 
** Utilizei o setTimeout só para limpar a msg depois que foi exibida
*/

var alert = document.querySelector('.alert');

document.getElementsByTagName('form')[0].addEventListener('submit', function (e) {
    e.preventDefault();

    if(this.checkValidity()){
        alert.style.display = 'block';
        alert.innerHTML = 'envio com sucesso';
        
        setTimeout(function() {
            alert.style.display = 'none';
            alert.innerHTML = '';
        }, 5000);
    }
});

/*
** querySelectorAll retorna uma lista de elementos presentes no documento
** O seletor ^= seleciona todas as Tags a com href que inicia com #
** com o forEach adiciona um evento de click a cada elemeto
** No querySelector ele seleciona os elementos de cada href vai adicionar a função de scroll
** scrollIntoView apesar de experimental, funciona em grande parte dos browser
** Ele é um metodo de scroll por elemeto
** Behavior: Animação ("auto", "instant" ou "smooth")
** Block: start (onde a Elemeto inicia) || center (no centro do Elemento) || end (onde o Elemento termina)
*/

document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth', block:'start'
        });
    });
});