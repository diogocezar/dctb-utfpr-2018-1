<?php
	require 'vendor/autoload.php';

	$user = new App\Controllers\ControllerUser();

	$user_data = array(
		'name'  => 'Diogo Cezar',
		'email' => 'diogo@diogocezar.com'
	);

	$user->save($user_data);
?>