/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nadook
 * Created: 21/05/2018
 */

CREATE DATABASE pokedex;

-- use pokedex;

CREATE TABLE pokemon(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name varchar(40),
    level INTEGER,
    hp INTEGER,
    agility INTEGER,
    attack INTEGER,
    defense INTEGER,
    specialAttack INTEGER,
    specialDefense INTEGER
);

-- PARA TESTES DE BUSCA INICIAL

INSERT INTO pokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES ("Bulbasaur", 1, 45, 45, 49, 49, 65, 65);
INSERT INTO pokemon (name, level, hp, agility, attack, defense, specialAttack, specialDefense) VALUES ("Cubone", 1, 50, 35, 50, 95, 40, 50);

