<?php
	require_once('config/Config.php');
	require_once('database/DataBase.php');
	require_once('oracle/Oracle.php');

	echo "<h2>Instanciando uma nova Classe Oracle</h2>";

	$oracle = new Oracle();

	echo "<h2>Cadastrando um Nome</h2>";

	$post = array('name' => 'Diogo Cezar Teixeira Batista');
	$oracle->save_item($post);

	echo "<h2>Editando um Nome Cadastrado</h2>";

	$post = array('name' => 'José da Silva');
	$oracle->save_item($post, 1);

	echo "<h2>Adicionando um novo Nome</h2>";

	$post = array('name' => 'Diogo Cezar Teixeira Batista');
	$oracle->save_item($post);

	echo "<h2>Adicionando um novo Nome</h2>";

	$post = array('name' => 'Jonas');
	$oracle->save_item($post);

	echo "<h2>Adicionando um novo Nome</h2>";

	$post = array('name' => 'José');
	$oracle->save_item($post);

	echo "<h2>Exibindo apenas um registro com um id específico</h2>";

	$item = $oracle->get_item(1);

	print_r($item);

	echo "<h2>Exibindo todos os registros</h2>";

	$items = $oracle->get_item();

	print_r($items);

	echo "<h2>Removendo um registo</h2>";

	$oracle->delete_item(2);

	echo "<h2>Mostrando novamente todos os ítens</h2>";

	$items = $oracle->get_item();

	print_r($items);
?>