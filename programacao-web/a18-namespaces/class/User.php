<?php
	namespace People;

	const YEAR = 2016;

	function sum($n1, $n2){
		return $n1 + $n2;
	}

	class User{
		private $name;
		private $age;
		public function __construct($name, $age){
			$this->name = $name;
			$this->age  = $age;
		}
		public function __toString(){
			$out = array(
				'Name' => $this->name,
				'Age'  => $this->age
			);
			return implode(' - ', $out);
		}
	}
?>