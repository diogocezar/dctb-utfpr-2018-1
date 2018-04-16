<?php
	class Person{
		public function __construct(){
			echo "Constructor called here!<br/>";
		}
		public function __destruct(){
			echo "Destructor called here!<br/>";
		}
	}
	$p = new Person();	// invoca o construtor
	unset($p);			// invoca o destrutor
?>
