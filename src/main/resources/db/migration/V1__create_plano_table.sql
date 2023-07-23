CREATE TABLE IF NOT EXISTS tbplano (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    criador VARCHAR(100) NOT NULL,
    descricao TEXT,
    UNIQUE(nome)
);
