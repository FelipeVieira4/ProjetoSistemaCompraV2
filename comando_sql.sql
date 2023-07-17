drop database bd_felipe_vieira;
create database bd_felipe_vieira;
use bd_felipe_vieira;

create table produto(
	id int primary key auto_increment,
	preco float not null,
	nome varchar(255) not null,
	caminhoFoto varchar(255) not null,
	contatoDistribuidora varchar(255) not null,
	localproduzido varchar(255) not null,
	descricao varchar(255) not null,
	categoria varchar(25) not null
);

create table user_info(
	id int primary key auto_increment,
	usuario varchar(45) not null,
	senha varchar(255) not null
);

insert into user_info(usuario, senha) values("usuario","123");
insert into user_info(usuario, senha) values("usuario","test");
