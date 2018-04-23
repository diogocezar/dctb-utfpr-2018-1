<?php
	require_once("./api/autoload.php");

	$oracle = new Oracle();

	Slim\Slim::registerAutoloader();
	$app     = new \Slim\Slim();
	$app->response()->header('Content-Type', 'application/json;charset=utf-8');

	$app->get('/', function(){
		echo "Página Inicial da API";
	});

	$app->get('/item', function(){
		global $oracle;
		return $oracle->get_item();
	});

	$app->get('/item/:id', function($id){
		global $oracle;
		return $oracle->get_item($id);
	});

	$app->post('/item', function(){
		global $oracle;
		$request = \Slim\Slim::getInstance()->request();
		$oracle->save_item($request->post());
	});

	$app->post('/item/:id', function($id){
		global $oracle;
		$request = \Slim\Slim::getInstance()->request();
		$oracle->save_item($request->post(), $id);
	});

	$app->delete('/item/:id', function($id){
		global $oracle;
		$oracle->delete_item($id);
	});

	$app->run();
?>