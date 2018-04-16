<?php
	class ContaEspecial extends ContaCorrente{
		private $limite;
		function __construct($valor, $limite){
			parent::__construct($valor);
			$this->limite = $limite;
		}
		function saque($valor){
			if($this->saldo + $this->limite >= $valor){
				$this->saldo  -= $valor;
			}
		}
	}
?>