-- Table: usernew.companies

-- DROP TABLE usernew.companies;

CREATE TABLE usernew.companies
(
    companyid character varying(25) COLLATE pg_catalog."default" NOT NULL,
    "companyName" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "officeNumber" integer NOT NULL,
    address character varying(50) COLLATE pg_catalog."default" NOT NULL,
    city character varying(25) COLLATE pg_catalog."default" NOT NULL,
    state character varying(25) COLLATE pg_catalog."default" NOT NULL,
    zip integer NOT NULL,
    county character varying(25) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    websiteurl character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT companies_pkey PRIMARY KEY (companyid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.companies
    OWNER to postgres;