/*Guilherme Gonçalves Borges da Silva 
    AN34A
    Javascript para os botoes e scroll lento
*/
$(document).ready(function() {
    $('#botao_contato').click(function() {
        $('html, body').animate({
            scrollTop: $('#contato').position().top
        }, 1500);
        return false;
    });
	
		
	

    var label_aviso = $("#label_aviso").val();

    $('#botao_enviar').click(function() {
        var nome = $("#nome").val();

        var email = $("#email").val();

        var assunto = $("#assunto").val();

 


        if (nome==null || nome =='') {
        	$("#nome").focus();
        	$("#nome").css("border-color", "red");
        	$("#nome").css("border-width", "3px");

        	$("#label_aviso").hide(); 
        }

        else if (email==null || email ==''){
        	$("#email").focus();
        	$("#email").css("border-color", "red");
        	$("#email").css("border-width", "3px");
        	$("#label_aviso").hide();
        }

	else if (assunto==null || assunto =='') {        	
        	$("#label_aviso").hide();
        	$("#assunto").css("border-color", "red");
        	$("#assunto").css("border-width", "3px");
        	$("#assunto").focus();
        }
        else{
		
		
		// filtros
		var emailFilter=/^.+@.+\..{2,}$/;
		var illegalChars= /[\(\)\<\>\,\;\:\\\/\"\[\]]/
		// condição
		if(!(emailFilter.test(email))||email.match(illegalChars)){
			$("#label_aviso").show().text("E-mail inválido!").css("color", "red");
			$("#email").css("border-color", "black");
        		$("#email").css("border-width", "1px");
			return;

		} 
        	$("#nome").css("border-color", "black");
        	$("#nome").css("border-width", "1px");
        	$("#email").css("border-color", "black");
        	$("#email").css("border-width", "1px");
        	$("#assunto").css("border-color", "black");
        	$("#assunto").css("border-width", "1px");
        	$("#label_aviso").html("Mensagem enviada com sucesso!").css("color", "green");;
        	$("#label_aviso").show();
        }

        
    });

    $('.menu_home').click(function() {
        $('html, body').animate({
            scrollTop: $('#home').position().top
        }, 1500);
        return false;
    });

    $('.menu_produtos').click(function() {
        $('html, body').animate({
            scrollTop: $('#produtos').position().top
        }, 1500);
        return false;
    });

    $('.menu_novidades').click(function() {
        $('html, body').animate({
            scrollTop: $('#novidades').position().top
        }, 1500);
        return false;
    });

    $('.menu_contato').click(function() {
        $('html, body').animate({
            scrollTop: $('#contato').position().top
        }, 1500);
        return false;
    });
});
