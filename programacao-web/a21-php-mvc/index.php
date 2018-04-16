<?php
	// require 'App/Controllers/ControllerAgenda.php';
	// require 'App/Models/ModelAgenda.php';
	// require 'App/Views/ViewAgenda.php';

	require 'vendor/autoload.php';

	$controllerAgenda = new App\Controllers\ControllerAgenda();
	//$controllerAgenda->index();



	$controllerAgenda->save(
		array(
			'id'    => 3,
			'name'  => 'Marcio Augusto',
			'phone' => '+55 43 877 744 959'
		)
	);



?>