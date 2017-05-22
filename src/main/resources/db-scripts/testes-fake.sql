insert into PESSOA(id,nome,foto) values (nextval('pessoa_id_seq'),'Luciano Ortiz Silva', 'https://lh3.googleusercontent.com/-LVGRdtZdGbM/AAAAAAAAAAI/AAAAAAAAAAA/AHalGhpZORTKWLj3SXQu1_GQg3nv3J3WpQ/s96-c-mo/photo.jpg');
insert into USUARIO(id, id_pessoa, email, telefone, apelido, tipo, ativo) values(nextval('usuario_id_seq'), 1, 'lucianoortizsilva@gmail.com', '51 982012911', 'ortiz', 'RESPONSAVEL', true);
             
             
--RESET ALL
drop table USUARIO
drop table PESSOA
drop sequence usuario_id_seq 
drop sequence pessoa_id_seq