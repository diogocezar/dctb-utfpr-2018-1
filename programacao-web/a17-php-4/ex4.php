<?php
	include("class/conta-corrente.php");
	include("class/conta-especial.php");
	/* Conta Corrente */
	echo "<h2>Conta Corrente</h2>";
	$cc = new ContaCorrente(1000);
	$cc->saque(500);
	echo $cc;
	$cc->saque(500);
	echo $cc;
	$cc->saque(10);
	echo $cc;
	$cc->deposito(150);
	echo $cc;

	/* Conta Especial */
	echo "<h2>Conta Especial</h2>";
	$cc = new ContaEspecial(1000, 500);
	$cc->saque(500);
	echo $cc;
	$cc->saque(500);
	echo $cc;
	$cc->saque(10);
	echo $cc;
?>