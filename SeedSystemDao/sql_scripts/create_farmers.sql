-- Table: usernew.farmer

-- DROP TABLE usernew.farmer;

CREATE TABLE usernew.farmer
(
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    firstname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    address character varying(50) COLLATE pg_catalog."default" NOT NULL,
    city character varying(50) COLLATE pg_catalog."default" NOT NULL,
    state character varying(50) COLLATE pg_catalog."default" NOT NULL,
    zip character varying(10) COLLATE pg_catalog."default" NOT NULL,
    officenumber character varying(10) COLLATE pg_catalog."default" NOT NULL,
    creditcardnumber character varying(20) COLLATE pg_catalog."default" NOT NULL,
    cvv character varying(10) COLLATE pg_catalog."default" NOT NULL,
    expdate date,
    salt character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT farmer_pkey PRIMARY KEY (email)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.farmer
    OWNER to postgres;