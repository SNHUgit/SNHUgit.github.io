
-- DB build script

DROP TABLE IF EXISTS public.authorities;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.appointment;
DROP TABLE IF EXISTS public.contact;
DROP TABLE IF EXISTS public.task;

CREATE TABLE public.appointment (
    appointment_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    description TEXT NOT NULL,
    appointment_date DATE NOT NULL
);

CREATE TABLE public.contact (
    contact_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    "number" VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE public.task (
    task_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "name" VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE public.users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE public.authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
        FOREIGN KEY (username) REFERENCES public.users (username),
    CONSTRAINT uk_authorities_username_authority
        UNIQUE (username, authority)
);

CREATE INDEX ix_auth_username ON public.authorities (username);