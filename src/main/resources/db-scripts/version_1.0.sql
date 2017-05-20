create table PESSOA (
	id integer not null,
	nome varchar(60) not null,
	foto varchar(120),        
constraint pessoaPK primary key(id)
);

create table USUARIO (
	id integer not null,
	id_pessoa integer not null REFERENCES PESSOA(id),
	email varchar(120) not null,
	telefone varchar(20),
	apelido varchar(30),
	tipo varchar(11),
	ativo boolean,
constraint usuarioPK primary key(id)
);

create sequence pessoa_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create sequence usuario_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;