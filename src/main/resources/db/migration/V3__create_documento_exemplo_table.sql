CREATE TABLE IF NOT EXISTS tbdocumentoexemplo (
	uuid UUID PRIMARY KEY,
    uuid_documento UUID NOT NULL,
    content BYTEA NOT NULL,
    UNIQUE(uuid, uuid_documento)
);

ALTER TABLE tbdocumentoexemplo ADD CONSTRAINT fk_tbdocumento FOREIGN KEY (uuid_documento) REFERENCES tbdocumento(uuid); 
