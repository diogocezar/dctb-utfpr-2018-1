<?php
	abstract class Abstrata{
		protected $nome;
		public abstract function setNome($nome);
		public function getNome(){
			return $this->nome;
		}
	}

	class ClasseAbstrata extends Abstrata{
		public function setNome($nome){
			$this->nome = $nome;
		}
	}

	$classeAbstrata = new ClasseAbstrata();
	$classeAbstrata->setNome("Pedro");
	echo $classeAbstrata->getNome();
?>