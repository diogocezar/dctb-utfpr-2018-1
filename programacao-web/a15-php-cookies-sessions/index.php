<?php
	session_start();
	$_SESSION['store_info'] = "Olá sou uma informação salva na index.php";
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Exemplos PHP</title>
	<link rel="stylesheet" href="">
</head>
<body>
	<h2>Exemplos PHP - Parte 3</h2>
	<ul>
		<li><a href="cookie.php">Exemplo Cookie</a></li>
		<li><a href="session.php">Exemplo Session</a></li>
		<li><a href="header.php">Exemplo Header</a></li>
	</ul>
</body>
</html>