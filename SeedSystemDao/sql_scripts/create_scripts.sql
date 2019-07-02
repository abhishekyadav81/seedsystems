CREATE SCHEMA usernew
    AUTHORIZATION postgres;
    
--------------------------    
    
CREATE TABLE usernew."user"
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email character varying(355) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp without time zone NOT NULL,
    last_login timestamp without time zone,
    salt character varying COLLATE pg_catalog."default",
    CONSTRAINT "User_pkey" PRIMARY KEY (user_id),
    CONSTRAINT "User_email_key" UNIQUE (email)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew."user"
    OWNER to postgres;    
    
--------------------------    
    
 
CREATE TABLE usernew.role
(
    role_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    role_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    role_desc character varying COLLATE pg_catalog."default",
    CONSTRAINT "Role_pkey" PRIMARY KEY (role_id),
    CONSTRAINT "Role_role_name_key" UNIQUE (role_name)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.role
    OWNER to postgres;
    
--------------------------

    
    CREATE TABLE usernew.userrole
(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    grant_date timestamp without time zone,
    CONSTRAINT "UserRole_pkey" PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES usernew.role (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES usernew."user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE usernew.userrole
    OWNER to postgres;
    