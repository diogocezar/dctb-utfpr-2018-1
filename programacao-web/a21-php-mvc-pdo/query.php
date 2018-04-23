<?php
	require 'vendor/autoload.php';

	$user = new App\Controllers\ControllerUser();

	$user_data = array(
		'id'  => '1'
	);

	$user->query($user_data);
?>