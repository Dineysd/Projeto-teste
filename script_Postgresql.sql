-- Database: projeto01

-- DROP DATABASE projeto01;

CREATE DATABASE projeto01
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

       -- Table: public.cliente

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
  id character varying(46) NOT NULL,
  nome character varying(50) NOT NULL,
  datanacimento date NOT NULL,
  dataempresa date NOT NULL,
  cpf character varying(20) NOT NULL,
  CONSTRAINT cliente_pkey PRIMARY KEY (id),
  CONSTRAINT cliente_cpf_key UNIQUE (cpf)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cliente
  OWNER TO postgres;
  
  
  CREATE TABLE public.contato
(
  id character varying(46) NOT NULL,
  ddd integer NOT NULL,
  telefone character varying(36) NOT NULL,
  cliente_id character varying(36) NOT NULL,
  CONSTRAINT contato_pkey PRIMARY KEY (id),
  CONSTRAINT contato_cliente_id_fkey FOREIGN KEY (cliente_id)
      REFERENCES public.cliente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contato
  OWNER TO postgres;
  
  
  CREATE TABLE public.endereco
(
  id character varying(46) NOT NULL,
  logradouro character varying(50) NOT NULL,
  numero integer NOT NULL,
  bairro character varying(50) NOT NULL,
  cidade character varying(50) NOT NULL,
  cep character varying(20) NOT NULL,
  cliente_end_id character varying(36) NOT NULL,
  CONSTRAINT endereco_pkey PRIMARY KEY (id),
  CONSTRAINT endereco_cliente_end_id_fkey FOREIGN KEY (cliente_end_id)
      REFERENCES public.cliente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.endereco
  OWNER TO postgres;


