<?php
	namespace App\Views;

	class ViewAgenda{
		public function render($data){
			/**
			 * Local de chamada de uma template engine (Blade ou Twig)
			 */
			$str  = "";
			$str .= "<h1>Agenda de Contatos</h1>";
			$str .= "<ul>";
			foreach ($data as $key => $value) {
				$str .= "<li>";
				$str .= "<h2>" . $value['name'] . "</h2>";
				$str .= "<p>" . $value['phone'] . "</p>";
				$str .= "</li>";
			}
			$str .= "</ul>";
			echo $str;
		}
	}
?>