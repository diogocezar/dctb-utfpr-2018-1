<?php
	class ContaCorrente{
		public $saldo;
		function __construct($valor){
			$this->saldo = $valor;
		}
		function saque($valor){
			if($this->saldo >= $valor)
				$this->saldo -= $valor;
			else
				echo "Saldo insuficiente! <br/>";
		}
		function deposito($valor){
			$this->saldo += $valor;
		}
		function __toString(){
			$str  = "";
			$str .= "Saldo: " . $this->saldo;
			$str .= "<br/>";
			return $str;
		}
	}
?>