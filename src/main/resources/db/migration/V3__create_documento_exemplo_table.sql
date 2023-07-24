CREATE TABLE IF NOT EXISTS tbdocumentoexemplo (
	uuid UUID PRIMARY KEY,
    uuid_documento UUID NOT NULL,
    nome_original VARCHAR(100) NOT NULL,
    tamanho BIGINT NOT NULL,
    content BYTEA NOT NULL,
    UNIQUE(uuid, uuid_documento)
);

ALTER TABLE tbdocumentoexemplo ADD CONSTRAINT fk_tbdocumento FOREIGN KEY (uuid_documento) REFERENCES tbdocumento(uuid) ON DELETE CASCADE;
