<?php
	namespace App\Models;

	class ModelAgenda{
		private $data;
		public function __construct(){
			$this->data = $this->getData();
		}
		private function getData(){
			/**
			 * Local de chamada de dos dados do banco de dados
			 */
			return array(
				array(
					'id'    => 1,
					'name'  => 'Diogo Cezar',
					'phone' => '+55 43 996 299 435'
				),
				array(
					'id'    => 2,
					'name'  => 'Jonas Silva',
					'phone' => '+55 43 987 787 999'
				)
			);
		}
		public function saveAgenda($data){
			array_push($this->data, $data);
		}
		public function getAgenda(){
			return $this->data;
		}
	}
?>