-- Table: usernew."companiesSeed"

-- DROP TABLE usernew."companiesSeed";

CREATE TABLE usernew."companiesSeed"
(
    "companyId" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "seedId" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    priceperbag integer NOT NULL,
    CONSTRAINT "companiesSeed_pkey" PRIMARY KEY ("companyId", "seedId")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew."companiesSeed"
    OWNER to postgres;