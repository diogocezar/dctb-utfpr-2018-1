/**
 * Prática com JavaScript
 * Implementar cada um dos seguintes exemplos.
 */

/**
 * FUNÇÕES
 */

/**
 * Implementar um exemplo simples de função
 */

function sum(number){
    return number + 2;
}

console.log(sum(4));

/**
 * Implementar uma função, atribuíla a uma variável e executar
 */

 var s = function (number){
    return ++number;
 }

console.log(s(4));

/**
 * Implementar um exemplo de passagem de função como callback
 */

function exCall(f){
    f(5);
}

exCall(function(val){
    console.log(val+10);
})

/**
 * VARIÁVEIS
 */

/**
 * Implementar exemplos de variáveis
 */

 var a = 19;
 var b = "Teste";
 var c = [1,2,3,4];
 var d = {'name' : 'diogo'};

/**
 * ARRAYS
 */

/**
 * Implementar exemplos de arrays
 */

var str = ['farah', 'judit', 'jessé', 'irley'];

/**
 * LAÇOS
 */

/**
 * Implementar exemplo de forEach com arrays (utilizando CB)
 */

str.forEach(function(v){
    console.log(v);
});

/**
 * Implementar função equivalente sem utilização  do forEach
 */

 for(var i=0; i<str.length; i++)
    console.log(str[i]);

/**
 * CONDIÇÕES
 */

/**
 * Implementar exemplos de utilização de == e ===
 */

var a = 1;
var b = '1';

//debugger;

if(a = b) console.log('ok');
if(a == b) console.log('ok2');
if(a === b) console.log('ok3');

/**
 * OBJETO LITERAL
 */

/**
 * Implementar a utilização de um Objeto Literal
 */

const ol = {
    newTitle : "Olá novo título",
    init: function(){
        var el = document.querySelector("#title-1");
        el.innerHTML = this.newTitle;
    }
}

ol.init();

/**
 * OBJETO CONSTRUTOR
 */

/**
 * Implementar a utilização de um Objeto Construtor
 */

function Fruits(color, shape){
    this.color = color;
    this.shape = shape;
    this.print = function(){
        console.log(this.color + ' - ' + this.shape);
    }
}

var apple = new Fruits('red', 'round');

apple.print();



/**
 * ARRAYS DE OBJETOS
 */

/**
 * Implementar a utilização arrays de objetos
 */

var a = [
    {
        name : 'aaa'
    },
    {
        name : 'bbb',
        age : 12
    },
    {
        name: 'ccc'
    },
];

console.log(a[1]);

/**
 * INTERAÇÕES COM HTML
 */

/**
 * Implementar a utilização getElementByID
 */

/**
 * Implementar a utilização querySelectorAll
 */

/**
 * Implementar a utilização querySelector
 */

/**
 * Implementar a utilização innerHTML
 */

/**
 * Implementar a utilização style
 */

var title = document.querySelector("#title-1");
title.style.color = 'blue';

/**
 * EVENTOS
 */

/**
 * Implementar addEventListner
 */



/**
 * FORMS
 */

/**
 * Implementar uma validação simples de formulário
 */

const validation = {
    firstName : null,
    lastName : null,
    validate: function(){
        validation.firstName = document.querySelector("#firstName");
        validation.lastName = document.querySelector("#lastName");
        validation.firstName.style.borderColor = 'black';
        validation.lastName.style.borderColor = 'black';
        if (validation.firstName.value != '' && validation.lastName.value != '')
            alert('Enviado com sucesso!');
        else{
            validation.firstName.style.borderColor = 'red';
            validation.lastName.style.borderColor = 'red';
        }
    },
    init: function(){
        var btn = document.querySelector("#send");
        btn.addEventListener('click', validation.validate);
    }
}

validation.init();