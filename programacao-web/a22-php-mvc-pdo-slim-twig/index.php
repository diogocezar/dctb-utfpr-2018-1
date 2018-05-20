<?php
	require 'vendor/autoload.php';

	Slim\Slim::registerAutoloader();
	$app  = new \Slim\Slim();
	$user = new App\Controllers\ControllerUser();

	$app->get('/', function(){
		echo "Página Inicial da API";
	});

	$app->get('/user', function(){
		global $user;
		$user->index();
	});

	$app->get('/user/save', function(){
		global $user;
		// os dados poderiam vir de um $_POST
		$user_data = array(
			'name'  => 'Diogo Cezar',
			'email' => 'diogo@diogocezar.com'
		);
		$user->save($user_data);
	});

	$app->get('/user/:id', function($id){
		global $user;
		$user_data = array(
			'id'  => $id
		);
		$user->query($user_data);
	});

	$app->run();
?>