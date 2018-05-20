<?php
	require_once('vendor/autoload.php');
	$loader = new Twig_Loader_Filesystem('./templates');
	$twig = new Twig_Environment($loader, array(
	    //'cache' => './cache',
	    'cache' => false
	));
	$template = $twig->loadTemplate('index.html');
	echo $template->render(
		array(
			'var' => array('template', 'teste'),
			'doo' => 'dah',
			'users' => array(
					   		array('name' => 'diogo',  'age' => '29'),
					   		array('name' => 'diogo1', 'age' => '30'),
					   		array('name' => 'diogo2', 'age' => '31')
					   	)

			)
		);
?>