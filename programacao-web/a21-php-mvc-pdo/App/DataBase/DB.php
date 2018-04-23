<?php
	/**
	* 	DB
	* 	Class manipulate DataBase with PDO.
	* 	Author: Diogo Cezar <diogo@diogocezar.com>
	*	Year: 2017
	*/

	namespace App\DataBase;

	use App\Configurations;

	class DB{
		/**
		* Attribute to store if database is connected
		*/
		public static $connected = false;
		/**
		* Attribute to store type of database
		*/
		public static $type;
		/**
		* Attribute to store host of database
		*/
		public static $host;
		/**
		* Attribute to store name of database
		*/
		public static $base;
		/**
		* Attribute to store user of database
		*/
		public static $user;
		/**
		* Attribute to store password of database
		*/
		public static $pass;
		/**
		* Attribute to store the connection string
		*/
		public static $conn_string;
		/**
		* Attribute to store pdo object
		*/
		public static $pdo;

		/**
		* Private Constructor
		*/
		private function __construct(){}

		/**
		* Method to Connect Database
		*/
		public static function connect(){
			DB::$type = Configurations\Config::$config['database']['type'];
			DB::$user = Configurations\Config::$config['database']['user'];
			DB::$host = Configurations\Config::$config['database']['host'];
			DB::$base = Configurations\Config::$config['database']['base'];
			DB::$pass = Configurations\Config::$config['database']['pass'];

			DB::$conn_string  = DB::$type;
			DB::$conn_string .= ":host="   . DB::$host;
			DB::$conn_string .= ";dbname=" . DB::$base;

			try{
				DB::$pdo = new \PDO(DB::$conn_string, DB::$user, DB::$pass);
	        	DB::$pdo->exec("SET CHARACTER SET utf8");
				DB::$pdo->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
				DB::$connected = true;
			}
			catch (PDOException $e) {
				die(DB::error($e->getMessage()));
			}
		}

		/**
		* Method to check if database is connected, and connect if is false;
		*/
		public static function checkConnection(){
			if(!DB::$connected)
				DB::connect();
		}

		/**
		* Method to Get Item or Items from table
		*/
		public static function get($table, $id = false){
			DB::checkConnection();
			if(!isset($table))
				die(DB::error("Nenhuma tabela foi selecionada."));
			$sql   = "SELECT * FROM " . $table;
			$array = array();
			if($id != false){
				$sql .= " WHERE id = ?";
			}
			$rs  = DB::$pdo->prepare($sql);
			$rs->bindParam(1, $id);
			try{
				if($rs->execute()){
					if($rs->rowCount() > 0){
						return $rs->fetchAll();
					}
					else{
						return null;
					}
				}
			}
			catch (PDOException $e) {
				die(DB::error($e, $sql));
			}
		}

		/**
		* Method to save [insert/update] items from table
		*/
		public static function save($table, $data){
			DB::checkConnection();
			if(empty($data) || empty($table)){
				die(DB::error("Os dados, ou tabela não estão preenchidos corretamente."));
			}
			$array = array();
			if(empty($data['id'])){
				foreach ($data as $key => $value){
					if($value != "NOW()" && $value != "CURTIME()")
	            		$insert[] = ':' . $key;
	            	else
	            		$insert[] = $value;
				}
	        	$insert = implode(',', $insert);
	        	$fields = implode(',', array_keys($data));
	        	$sql = "INSERT INTO `".$table."` (".$fields.") VALUES (".$insert.")";
				$rs = DB::$pdo->prepare($sql);
	        	foreach ($data as $key => $value)
	        		if($value != "NOW()" && $value != "CURTIME()")
	            		$rs->bindValue(':' . $key, $value);
				try{
					$rs->execute();
					return DB::$pdo->lastInsertId();
				}
				catch (PDOException $e) {
					die(DB::error($e, $sql));
				}
			}
			else{
				$updates = array_filter($data, function ($value) {
				    return null !== $value;
				});
				$values = array();
				$set    = "";
				foreach ($updates as $key => $value){
					if($key != "id")
						if($value != "NOW()" && $value != "CURTIME()")
	    					$set .= ' '.$key.' = :'.$key.',';
	    				else
	    					$set .= ' '.$key.' = '.$value.',';
				}
				$set = rtrim($set, ',');
				$sql = "UPDATE `".$table."` SET". $set ." WHERE id = :id_where";
				$rs = DB::$pdo->prepare($sql);
				foreach ($data as $key => $value){
					if($key != "id")
						if($value != "NOW()" && $value != "CURTIME()")
	            			$rs->bindValue(':' . $key, $value);
				}
				$rs->bindValue(':id_where', $data['id']);
				try{
					$rs->execute();
				}
				catch (PDOException $e) {
					die(DB::error($e, $sql));
				}
			}
			return true;
		}

		/**
		* Method to delete item
		*/
		public static function delete($table, $id){
			DB::checkConnection();
			if(empty($table) || empty($id)){
				die(DB::error("A tabela ou id não estão preenchidos corretamente."));
			}
			$sql = "DELETE FROM `".$table."` WHERE id = :id_delete";
			$rs = DB::$pdo->prepare($sql);
			$rs->bindValue(':id_delete', $id);
			try{
				$rs->execute();
			}
			catch (PDOException $e) {
				die(DB::error($e, $sql));
			}
			return true;
		}

		/**
		* Method to execute a SQL
		*/
		public static function sql($sql, $binds = false){
			DB::checkConnection();
			if(!isset($sql))
				die(DB::error("O SQL está vazio."));
			$rs = DB::$pdo->prepare($sql);
			if($binds != false){
				foreach ($binds as $key => $value)
					$rs->bindValue(':'. $key, $value);
			}
			try{
				$rs->execute();
				if($rs->rowCount() > 0){
					return $rs->fetchAll();
				}
				else{
					return null;
				}
			}
			catch (PDOException $e) {
				die(DB::error($e, $sql));
			}
		}

		/**
		* Method to display an error
		*/
		public static function error($msg, $sql = false){
			$console  = "<pre>";
			$console .= "<h1>HOUVE UM ERRO NO SISTEMA</h1>";
			$console .= "<br/>";
			if($sql != false){
				$console .= "<h2>[SQL]</h2><br/>" . $sql;
				$console .= "<br/><br/>";
			}
			$console .= "<h2>[ERRO]</h2><br/>" . $msg;
			$console .= "</pre>";
			return $console;
		}
	}
?>