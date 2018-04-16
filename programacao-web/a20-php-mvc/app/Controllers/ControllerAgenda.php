<?php
	namespace App\Controllers;

	use \App\Models;
	use \App\Views;

	class ControllerAgenda{
		public function index(){
			$modelAgenda = new Models\ModelAgenda();
			$viewAgenda  = new Views\ViewAgenda();
			$viewAgenda->render($modelAgenda->getAgenda());
		}
		public function save($data){
			$modelAgenda = new Models\ModelAgenda();
			$viewAgenda  = new Views\ViewAgenda();
			$modelAgenda->saveAgenda($data);
			$viewAgenda->render($modelAgenda->getAgenda());
		}
	}
?>