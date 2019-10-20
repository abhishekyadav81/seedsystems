-- Table: usernew.dealers

-- DROP TABLE usernew.dealers;

CREATE TABLE usernew.dealers
(
    dealertitle character varying(20) COLLATE pg_catalog."default" NOT NULL,
    contactperson character varying(20) COLLATE pg_catalog."default" NOT NULL,
    contactnumber character varying(20) COLLATE pg_catalog."default" NOT NULL,
    state character varying(10) COLLATE pg_catalog."default" NOT NULL,
    county character varying(10) COLLATE pg_catalog."default" NOT NULL,
    crop character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT dealers_pkey PRIMARY KEY (dealertitle)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.dealers
    OWNER to postgres;