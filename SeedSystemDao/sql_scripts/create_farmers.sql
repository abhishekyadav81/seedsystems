-- Table: usernew.farmers

-- DROP TABLE usernew.farmers;

CREATE TABLE usernew.farmers
(
    user_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "first name" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    title character varying(50) COLLATE pg_catalog."default",
    "office number" integer NOT NULL,
    address character varying(50) COLLATE pg_catalog."default",
    city character varying(20) COLLATE pg_catalog."default" NOT NULL,
    state character varying(10) COLLATE pg_catalog."default" NOT NULL,
    county character varying(10) COLLATE pg_catalog."default" NOT NULL,
    zip integer NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    creditcardnumber integer NOT NULL,
    expedate date NOT NULL,
    cvv integer NOT NULL,
    CONSTRAINT farmers_pkey PRIMARY KEY (user_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.farmers
    OWNER to postgres;