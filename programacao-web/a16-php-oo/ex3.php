<?php
	class Estatica{
		static $var = "Variável Estática";
		static function getStatic(){
			return Estatica::$var;
		}
	}
	echo Estatica::$var;
	echo "<br/>";
	echo Estatica::getStatic();
?>