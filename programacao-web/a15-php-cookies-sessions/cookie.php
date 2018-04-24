<?php
	$value = 0;
	if(empty($_COOKIE["counter_utfpr"])){
		setcookie(	"counter_utfpr", 	// nome da variável cookie;
					"1",				// valor da variável cookie;
					time()+3600			// expira em 1 hora
					);
		$value = 1;
	}
	else{
		$value = $_COOKIE["counter_utfpr"] + 1;
		setcookie(	"counter_utfpr", 	// nome da variável cookie;
					$value,				// valor da variável cookie;
					time()+3600			// expira em 1 hora
					);
	}

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Exemplo Cookie</title>
	<link rel="stylesheet" href="">
</head>
<body>
	<h2>Exemplo de Cookie</h2>
	<h3>Você acessou este site: <?php echo $value; ?> veze(s)</h3>
</body>
</html>