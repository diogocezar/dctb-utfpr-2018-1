<?php
	/**
	* 	ModelUser
	* 	Representes a View.
	* 	Author: Diogo Cezar <diogo@diogocezar.com>
	*	Year: 2017
	*/

	namespace App\Views;

	class ViewUser{
		public function render($data){
			$dir      = './templates';
			$html     = 'user_template.html';
			$loader   = new \Twig_Loader_Filesystem($dir);
			$twig     = new \Twig_Environment($loader, array('cache' => false));
			$template = $twig->loadTemplate($html);
			$values = array(
				'title' => 'Usuários',
				'users' => $data
			);
			echo $template->render($values);
		}
	}
?>