CREATE DATABASE pokedesk;
USE pokedesk;

CREATE TABLE pokemon (
  id int PRIMARY KEY NOT NULL,
  name varchar(40) NOT NULL,
  level int(11),
  hp int(11),
  agility int(11),
  attack int(11),
  defense int(11),
  specialAttack int(11),
  specialDefense int(11)
)