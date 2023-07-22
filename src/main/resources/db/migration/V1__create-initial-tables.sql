CREATE TABLE IF NOT EXISTS departamentos (
    id SERIAL NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    CONSTRAINT departamentos_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pessoas (
	id bigserial NOT NULL,
	nome varchar(255) NOT NULL,
	id_departamento int NULL,
	CONSTRAINT pessoas_pkey PRIMARY KEY (id),
	CONSTRAINT pessoas_departamentos_fkey FOREIGN KEY (id_departamento) REFERENCES public.departamentos(id)
);

CREATE TABLE IF NOT EXISTS tarefas (
	id bigserial NOT NULL,
	descricao varchar(255) NULL,
	duracao int NULL,
	finalizado bool NULL,
	prazo timestamp NULL,
	titulo varchar(255) NULL,
	id_departamento int NULL,
	id_pessoa int NULL,
	CONSTRAINT tarefas_pkey PRIMARY KEY (id),
	CONSTRAINT tarefas_departamento_fkey FOREIGN KEY (id_departamento) REFERENCES departamentos(id),
	CONSTRAINT tarefas_pessoa_fkey FOREIGN KEY (id_pessoa) REFERENCES pessoas(id)
);