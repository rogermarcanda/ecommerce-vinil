#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL

\connect bd_ecommerce_vinil
CREATE TABLE public.cashback (
	id int4 NOT NULL,
	dia_da_semana varchar(255) NULL,
	genero varchar(255) NULL,
	porcentagem int4 NULL,
	CONSTRAINT cashback_pkey PRIMARY KEY (id)
);

CREATE TABLE public.disco (
	id int4 NOT NULL,
	autor varchar(255) NULL,
	genero varchar(255) NULL,
	nome varchar(255) NULL,
	valor numeric(19,2) NULL,
	CONSTRAINT disco_pkey PRIMARY KEY (id)
);

CREATE TABLE public.venda (
	id int4 NOT NULL,
	"data" date NULL,
	valor_cash_back numeric(19,2) NULL,
	valor_total numeric(19,2) NULL,
	CONSTRAINT venda_pkey PRIMARY KEY (id)
);

CREATE TABLE public.venda_disco (
	id int4 NOT NULL,
	qtde int4 NULL,
	valor numeric(19,2) NULL,
	valor_cash_back numeric(19,2) NULL,
	valor_total numeric(19,2) NULL,
	disco int4 NULL,
	venda int4 NULL,
	CONSTRAINT venda_disco_pkey PRIMARY KEY (id),
	CONSTRAINT fkeoi51rbxose7kolr2eg9hesoo FOREIGN KEY (venda) REFERENCES venda(id),
	CONSTRAINT fknatnijfp47jnum4mbn5o18fvd FOREIGN KEY (disco) REFERENCES disco(id)
);


EOSQL