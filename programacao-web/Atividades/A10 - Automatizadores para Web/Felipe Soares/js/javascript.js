var clicouS = false;
var clicouP = false;
function image() {
    var img = document.createElement("IMG");
    img.src = "https://www.aprenderexcel.com.br//imagens/post/385/2901-1.jpg";
    if(clicouS == false){
      document.getElementById('im').innerHTML = 'Este é o Sobre, estou apenas testando js e div juntos com imagem';
      document.getElementById('im').appendChild(img);
      clicouS = true;
      clicouP = false;
    }
}

function insereTexto() {
  if(clicouP == false){
    document.getElementById('im').innerHTML = 'Este é o Principal, estou apenas testando js e div juntos com texto';
    clicouP = true;
    clicouS = false;
  }
}
