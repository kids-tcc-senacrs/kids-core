create table ENDERECO (
	id integer not null,
	cep varchar(8),
	logradouro varchar(80),
	complemento varchar(100),
constraint enderecoPK primary key(id)
);

create table USUARIO (
	id integer not null,
	id_endereco integer REFERENCES ENDERECO(id),
	nome varchar(60) not null,
	email varchar(255) not null unique,
	telefone varchar(20),
	tipo varchar(8),
	ativo boolean,
constraint usuarioPK primary key(id)
);

create sequence endereco_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create sequence usuario_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;