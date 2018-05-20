//Simplesmente ao verificar se é required o formulário ele retorna um "Enviado com sucesso como alert padrão do js"

document.getElementsByTagName('form')[0].addEventListener('submit', function (e) {
    if(this.checkValidity()){
        alert('Enviado com sucesso')
    }
});