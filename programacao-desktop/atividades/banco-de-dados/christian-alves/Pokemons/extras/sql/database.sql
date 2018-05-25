create table pokemon (
	id int auto_increment,
	nome varchar(20) not null unique,
    nivel int not null,
    hp int not null,
    agilidade int not null,
    ataque int not null,
    defesa int not null,
    atqEspecial int not null,
    defEspecial int not null,
    primary key(id)
);
