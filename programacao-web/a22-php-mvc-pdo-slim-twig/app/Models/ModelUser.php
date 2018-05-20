<?php
	/**
	* 	ModelUser
	* 	Representes a User Model.
	* 	Author: Diogo Cezar <diogo@diogocezar.com>
	*	Year: 2017
	*/

	namespace App\Models;

	use App\DataBase\DB;

	class ModelUser{
		public function getData(){
			return DB::get('php_users');
		}
		public function saveData($data){
			return DB::save('php_users', $data);
		}
		public function query($data){
			return DB::sql("SELECT * FROM php_users WHERE id = :id", array('id' => $data['id']));
		}
	}
?>