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
			return DB::get('users');
		}
		public function saveData($data){
			return DB::save('users', $data);
		}
		public function query($data){
			return DB::sql("SELECT * FROM users WHERE id = :id", array('id' => $data['id']));
		}
	}
?>