-- Table: usernew.seed

-- DROP TABLE usernew.seed;

CREATE TABLE usernew.seed
(
    "seedId" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "seedName" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    quality integer NOT NULL,
    CONSTRAINT seed_pkey PRIMARY KEY ("seedId")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.seed
    OWNER to postgres;