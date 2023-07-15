#drop database bd_felipe_vieira;
create database bd_felipe_vieira;
use bd_felipe_vieira;

create table produto(
	id int primary key auto_increment,
	preco float,
	nome varchar(255),
	caminhoFoto varchar(255),
	contatoDistribuidora varchar(255),
	localproduzido varchar(255),
	descricao varchar(255),
	categoria varchar(255)
);

create table user_info(
	id int primary key auto_increment,
	usuario varchar(45),
	senha varchar(255)
);

insert into user_info(usuario, senha) values("usuario","123");
