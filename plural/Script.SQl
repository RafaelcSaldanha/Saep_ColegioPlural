create database colegio;

create table responsaveis (
    responsavel_id serial primary key,
    responsavel_nome varchar(50),
    responsavel_cpf char(32)
);

create table alunos (
    aluno_id serial primary key,
    aluno_nome varchar(50),
    aluno_cpf char(32),
    responsavel_id int, foreign key (responsavel_id) references responsaveis(responsavel_id)
);

create table atendimentos (
    atendimento_id serial primary key,
    atendimento_nome varchar(50),
    atendimento_descricao text,
    atendimento_data date,
    aluno_id int, foreign key (aluno_id) references alunos(aluno_id)
);

insert into responsaveis(responsavel_nome, responsavel_cpf) values
('ricardo', md5('32511069587')),
('ajacio', md5('17032032561')),
('jg', md5('36018954862'));

insert into alunos(aluno_nome, aluno_cpf, responsavel_id) values 
('d mello', md5('19234099800'), 1),
('gabriel', md5('12345678910'), 3),
('pedro', md5('11092007130'), 2);

insert into atendimentos(atendimento_nome, atendimento_descricao, atendimento_data, aluno_id) values
('lasanha', 'frango', '2026-10-06', 1),
('lucas', 'lento', '2026-10-05', 2),
('neneias', 'careca', '2026-10-07', 3);