/*
Raphael Ochetski de Queiroz
1633465

Utilizando JQuery, aponta-se para os links que queremos que o efeito seja aplicado assim que clicamos no item de menu.

*/
var $menu = $('html, body');
$('.scrollMenu').click(function(){
    $menu.animate({
        scrollTop: $( $.attr(this, 'href')).offset().top
    }, 500);
    return false;
});
