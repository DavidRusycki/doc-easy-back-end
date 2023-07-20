create table if not exists tbplano (
    id bigserial primary key,
    nome varchar(100) not null,
    descricao text
);
