CREATE TABLE IF NOT EXISTS tbdocumento (
	uuid UUID PRIMARY KEY,
    id_plano BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    descricao_completa TEXT NOT NULL,
    situacao SMALLINT NOT NULL
);

ALTER TABLE tbdocumento ADD CONSTRAINT fk_tbplano FOREIGN KEY (id_plano) REFERENCES tbplano(id); 
