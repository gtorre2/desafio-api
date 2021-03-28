create table cliente (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	email varchar(80) not null,
	cpf varchar(30),
	cep varchar(9),

	endereco_cidade varchar(100),
	endereco_logradouro varchar(100),
	endereco_numero varchar(20),
	endereco_complemento varchar(60),
	endereco_bairro varchar(60),
	
	primary key (id)
) engine=InnoDB default charset=utf8;