<?php
class DataBase{
	public static $type;
	public static $host;
	public static $base;
	public static $user;
	public static $pass;
	public static $conn_string;
	public static $pdo;

	public function __construct(){}

	public function connect(){
		self::$type = Config::$config['database']['type'];
		self::$user = Config::$config['database']['user'];
		self::$host = Config::$config['database']['host'];
		self::$base = Config::$config['database']['base'];
		self::$pass = Config::$config['database']['pass'];

		self::$conn_string  = self::$type;
		self::$conn_string .= ":host="   . self::$host;
		self::$conn_string .= ";dbname=" . self::$base;

		try{
			self::$pdo = new PDO(self::$conn_string, self::$user, self::$pass);
			self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		}
		catch (PDOException $e) {
			die($e->getMessage());
		}
	}

	public static function error($msg, $sql){
		$console  = "<pre>";
		$console .= "<h1>SYSTEM ERROR</h1>";
		$console .= "<br/>";
		$console .= "<h2>[SQL]</h2><br/>" . $sql;
		$console .= "<br/><br/>";
		$console .= "<h2>[ERROR]</h2><br/>" . $msg;
		$console .= "</pre>";
		return $console;
	}
}
?>