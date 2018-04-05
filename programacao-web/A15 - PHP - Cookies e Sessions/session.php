<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Exemplo Session</title>
	<link rel="stylesheet" href="">
</head>
<body>
	<?php
		if(!empty($_SESSION['store_info'])):
	?>
		<h1>Você tem uma mensagem salva!</h1>
		<h2><?php echo $_SESSION['store_info']; ?></h2>
	<?php else: ?>
		<h1>Não há mensagens salvas.</h1>
	<?php endif; ?>
</body>
</html>