CREATE TABLE java_item (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
	PRIMARY KEY (id)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO `java_item` (`id`, `name`) VALUES
(1, 'José da Silva'),
(2, 'Jonas'),
(3, 'João Moreira');