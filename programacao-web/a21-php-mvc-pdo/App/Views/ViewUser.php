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
			$str  = "";
			$str .= "<h1>Users</h1>";
			$str .= "<ul>";
			if(!empty($data)){
				foreach ($data as $key => $value) {
					$str .= "<li>";
					$str .= "<h2>" . $value['name'] . "</h2>";
					$str .= "<p>" . $value['email'] . "</p>";
					$str .= "</li>";
				}
			}
			else{
				$str .= "Nenhum dado cadastrado.";
			}
			$str .= "</ul>";
			echo $str;
		}
	}
?>