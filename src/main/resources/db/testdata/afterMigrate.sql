set foreign_key_checks = 0;

delete from cliente;

set foreign_key_checks = 1;

alter table cliente auto_increment = 1;

insert into cliente (id, nome, email, cpf, cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_cidade) values (1, 'Gustavo', 'gtorre23@gmail.com', '123-000-000-11', '38400-999', 'Rua João Pinheiro', '1000', 'Centro', 'Brasília');





