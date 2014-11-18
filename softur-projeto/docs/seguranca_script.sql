create table usuario (
nome_usuario varchar(15) not null primary key,
senha varchar(15) not null
);
create table permissao_usuario (
nome_usuario varchar(15) not null,
nome_permissao varchar(15) not null,
primary key (nome_usuario, nome_permissao),
foreign key (nome_usuario) references usuario (nome_usuario)
);
insert into usuario values ('Mário', 'mario');
insert into usuario values ('Bernardo', 'bernardo');
insert into usuario values ('Tayrone', 'tayrone');
insert into permissao_usuario values ('mario', 'admin');
insert into permissao_usuario values ('bernardo', 'admin');
insert into permissao_usuario values ('tayrone', 'admin');