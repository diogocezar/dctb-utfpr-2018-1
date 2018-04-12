<?php
	interface IPessoa{
		public function setNome($nome);
	}
	interface ITipo{
		public function setTipo($tipo);
	}
	class ClassePessoa implements IPessoa, ITipo{
		private $nome, $tipo;
		public function setNome($nome){
			$this->nome = $nome;
		}
		public function setTipo($tipo){
			$this->tipo = $tipo;
		}
		public function __toString(){
			$retorno  = "";
			$retorno .= "Nome: {$this->nome}<br>";
			$retorno .= "Tipo: {$this->tipo}";
			return $retorno;
		}
	}
	$IP = new ClassePessoa();
	$IP->setNome("Carlos");
	$IP->setTipo("Pessoa Física");
	echo $IP;
?>
