script = {
  ancora: null,
  init: function () {
    script.ancora();
},

ancora: function(){
  jQuery(document).ready(function($) {
    $(".go-menu").click(function(event){
      event.preventDefault();
      $('html,body').animate({scrollTop:$(this.hash).offset().top}, 1000);
      });
  });
},

script.init();
