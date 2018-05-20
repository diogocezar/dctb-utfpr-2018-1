<?php
	/**
	* 	ModelUser
	* 	Representes a User Controller.
	* 	Author: Diogo Cezar <diogo@diogocezar.com>
	*	Year: 2017
	*/

	namespace App\Controllers;

	use App\Models;
	use App\Views;

	class ControllerUser{
		public function index(){
			$modelUser = new Models\ModelUser();
			$viewUser  = new Views\ViewUser();
			$viewUser->render($modelUser->getData());
		}
		public function save($data){
			$modelUser = new Models\ModelUser();
			$modelUser->saveData($data);
		}
		public function query($data){
			$modelUser = new Models\ModelUser();
			$viewUser  = new Views\ViewUser();
			$viewUser->render($modelUser->query($data));
		}
	}
?>