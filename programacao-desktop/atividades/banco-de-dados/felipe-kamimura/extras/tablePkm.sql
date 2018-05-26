CREATE DATABASE cadPokemon;
USE cadPokemon;

CREATE TABLE cadpokemon (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
    level INT NOT NULL,
    hp INT NOT NULL,
    agility INT NOT NULL,
    attack INT NOT NULL,
    defense INT NOT NULL,
    specialAttack INT NOT NULL,
    specialDefense INT NOT NULL,
	PRIMARY KEY (id)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO `cadpokemon`.`cadpokemon` (`name`, `level`, `hp`, `agility`, `attack`, `defense`, `specialAttack`, `specialDefense`) VALUES ('pikachu', '25', '250', '300', '100', '100', '250', '150');
INSERT INTO `cadpokemon`.`cadpokemon` (`name`, `level`, `hp`, `agility`, `attack`, `defense`, `specialAttack`, `specialDefense`) VALUES ('magikarp', '5', '5', '5', '5', '5', '5', '5');
INSERT INTO `cadpokemon`.`cadpokemon` (`name`, `level`, `hp`, `agility`, `attack`, `defense`, `specialAttack`, `specialDefense`) VALUES ('tododile', '13', '150', '210', '51', '123', '561', '21');
