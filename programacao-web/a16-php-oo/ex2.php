<?php
	include("class/conta-corrente.php");
	$cc = new ContaCorrente(1000);
	$cc->saque(500);
	echo $cc;
	$cc->saque(500);
	echo $cc;
	$cc->saque(10);
	echo $cc;
	$cc->deposito(150);
	echo $cc;
?>