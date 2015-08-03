--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: customer_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customer_tb (
    object_uuid uuid NOT NULL,
    login_ref uuid NOT NULL
);


ALTER TABLE public.customer_tb OWNER TO postgres;

--
-- Name: file_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE file_tb (
    object_uuid uuid NOT NULL,
    file_type integer,
    file_path text,
    original_name character varying(100),
    mime_type text NOT NULL,
    add_time timestamp with time zone DEFAULT now()
);


ALTER TABLE public.file_tb OWNER TO postgres;

--
-- Name: freelance_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE freelance_tb (
    object_uuid uuid NOT NULL,
    login_ref uuid NOT NULL
);


ALTER TABLE public.freelance_tb OWNER TO postgres;

--
-- Name: freelancer_skills_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE freelancer_skills_ref (
    freelancer_uuid uuid NOT NULL,
    skill_uuid uuid NOT NULL,
    current_level double precision NOT NULL
);


ALTER TABLE public.freelancer_skills_ref OWNER TO postgres;

--
-- Name: freelanser_task_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE freelanser_task_ref (
    freelancer_uuid uuid NOT NULL,
    task_uuid uuid NOT NULL
);


ALTER TABLE public.freelanser_task_ref OWNER TO postgres;

--
-- Name: frelancer_file_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE frelancer_file_ref (
    freelancer_uuid uuid NOT NULL,
    file_uuid uuid NOT NULL
);


ALTER TABLE public.frelancer_file_ref OWNER TO postgres;

--
-- Name: login_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE login_tb (
    object_uuid uuid NOT NULL,
    email text,
    password_h text,
    username character varying(30),
    reg_date date,
    active boolean,
    last_login timestamp with time zone,
    status character varying(2)
);


ALTER TABLE public.login_tb OWNER TO postgres;

--
-- Name: manager_skills_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE manager_skills_ref (
    manager_uuid uuid NOT NULL,
    skill_uuid uuid NOT NULL
);


ALTER TABLE public.manager_skills_ref OWNER TO postgres;

--
-- Name: manager_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE manager_tb (
    object_uuid uuid NOT NULL,
    login_ref uuid NOT NULL
);


ALTER TABLE public.manager_tb OWNER TO postgres;

--
-- Name: order_file_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE order_file_ref (
    order_uuid uuid NOT NULL,
    file_uuid uuid NOT NULL
);


ALTER TABLE public.order_file_ref OWNER TO postgres;

--
-- Name: order_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE order_tb (
    object_uuid uuid NOT NULL,
    manager_ref uuid NOT NULL,
    customer_ref uuid NOT NULL,
    creation_date timestamp with time zone NOT NULL,
    description text,
    name text
);


ALTER TABLE public.order_tb OWNER TO postgres;

--
-- Name: skill_task_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skill_task_ref (
    skill_uuid uuid NOT NULL,
    task_uuid uuid NOT NULL,
    required_level double precision
);


ALTER TABLE public.skill_task_ref OWNER TO postgres;

--
-- Name: skills_table; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skills_table (
    object_uuid uuid NOT NULL,
    description text,
    name character varying(100)
);


ALTER TABLE public.skills_table OWNER TO postgres;

--
-- Name: solution_file_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE solution_file_ref (
    file_uuid uuid NOT NULL,
    solution_uuid uuid NOT NULL
);


ALTER TABLE public.solution_file_ref OWNER TO postgres;

--
-- Name: solution_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE solution_tb (
    object_uuid uuid NOT NULL,
    task_ref uuid NOT NULL,
    creation_date timestamp with time zone,
    status character(1),
    description text
);


ALTER TABLE public.solution_tb OWNER TO postgres;

--
-- Name: task_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE task_tb (
    object_uuid uuid NOT NULL,
    order_ref uuid NOT NULL,
    description text,
    creation_date timestamp with time zone NOT NULL
);


ALTER TABLE public.task_tb OWNER TO postgres;

--
-- Name: technical_task_file_ref; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE technical_task_file_ref (
    technical_task_uuid uuid NOT NULL,
    file_uuid uuid NOT NULL
);


ALTER TABLE public.technical_task_file_ref OWNER TO postgres;

--
-- Name: technical_task_tb; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE technical_task_tb (
    object_uuid uuid NOT NULL,
    order_ref uuid NOT NULL,
    creation_date timestamp with time zone DEFAULT now(),
    description text
);


ALTER TABLE public.technical_task_tb OWNER TO postgres;

--
-- Data for Name: customer_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY customer_tb (object_uuid, login_ref) FROM stdin;
\.


--
-- Data for Name: file_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY file_tb (object_uuid, file_type, file_path, original_name, mime_type, add_time) FROM stdin;
\.


--
-- Data for Name: freelance_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY freelance_tb (object_uuid, login_ref) FROM stdin;
\.


--
-- Data for Name: freelancer_skills_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY freelancer_skills_ref (freelancer_uuid, skill_uuid, current_level) FROM stdin;
\.


--
-- Data for Name: freelanser_task_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY freelanser_task_ref (freelancer_uuid, task_uuid) FROM stdin;
\.


--
-- Data for Name: frelancer_file_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY frelancer_file_ref (freelancer_uuid, file_uuid) FROM stdin;
\.


--
-- Data for Name: login_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY login_tb (object_uuid, email, password_h, username, reg_date, active, last_login, status) FROM stdin;
827938cb-2151-47a7-ae9b-d6adc45b3561	some.item@gmail.com	\N	userOne	\N	\N	\N	\N
33fbe8a3-2f15-4a9b-a5bf-78b5d24b62b0	fumosync@gmail.com	\N	userTwo	\N	\N	\N	\N
\.


--
-- Data for Name: manager_skills_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY manager_skills_ref (manager_uuid, skill_uuid) FROM stdin;
\.


--
-- Data for Name: manager_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY manager_tb (object_uuid, login_ref) FROM stdin;
\.


--
-- Data for Name: order_file_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY order_file_ref (order_uuid, file_uuid) FROM stdin;
\.


--
-- Data for Name: order_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY order_tb (object_uuid, manager_ref, customer_ref, creation_date, description, name) FROM stdin;
\.


--
-- Data for Name: skill_task_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skill_task_ref (skill_uuid, task_uuid, required_level) FROM stdin;
\.


--
-- Data for Name: skills_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skills_table (object_uuid, description, name) FROM stdin;
\.


--
-- Data for Name: solution_file_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY solution_file_ref (file_uuid, solution_uuid) FROM stdin;
\.


--
-- Data for Name: solution_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY solution_tb (object_uuid, task_ref, creation_date, status, description) FROM stdin;
\.


--
-- Data for Name: task_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY task_tb (object_uuid, order_ref, description, creation_date) FROM stdin;
\.


--
-- Data for Name: technical_task_file_ref; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY technical_task_file_ref (technical_task_uuid, file_uuid) FROM stdin;
\.


--
-- Data for Name: technical_task_tb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY technical_task_tb (object_uuid, order_ref, creation_date, description) FROM stdin;
\.


--
-- Name: file_tb_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY file_tb
    ADD CONSTRAINT file_tb_pkey PRIMARY KEY (object_uuid);


--
-- Name: freelancer_skills_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY freelancer_skills_ref
    ADD CONSTRAINT freelancer_skills_ref_pkey PRIMARY KEY (freelancer_uuid, skill_uuid);


--
-- Name: freelanser_task_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY freelanser_task_ref
    ADD CONSTRAINT freelanser_task_ref_pkey PRIMARY KEY (freelancer_uuid, task_uuid);


--
-- Name: frelancer_file_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY frelancer_file_ref
    ADD CONSTRAINT frelancer_file_ref_pkey PRIMARY KEY (freelancer_uuid, file_uuid);


--
-- Name: manager_skills_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY manager_skills_ref
    ADD CONSTRAINT manager_skills_ref_pkey PRIMARY KEY (manager_uuid, skill_uuid);


--
-- Name: order_file_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY order_file_ref
    ADD CONSTRAINT order_file_ref_pkey PRIMARY KEY (order_uuid, file_uuid);


--
-- Name: pk_customer_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customer_tb
    ADD CONSTRAINT pk_customer_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_file_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY file_tb
    ADD CONSTRAINT pk_file_tb UNIQUE (object_uuid);


--
-- Name: pk_freelance_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY freelance_tb
    ADD CONSTRAINT pk_freelance_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_login_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY login_tb
    ADD CONSTRAINT pk_login_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_manager_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY manager_tb
    ADD CONSTRAINT pk_manager_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_order_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY order_tb
    ADD CONSTRAINT pk_order_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_skills_table; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skills_table
    ADD CONSTRAINT pk_skills_table PRIMARY KEY (object_uuid);


--
-- Name: pk_solution_table; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solution_tb
    ADD CONSTRAINT pk_solution_table PRIMARY KEY (object_uuid);


--
-- Name: pk_task_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY task_tb
    ADD CONSTRAINT pk_task_tb PRIMARY KEY (object_uuid);


--
-- Name: pk_technical_task_tb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY technical_task_tb
    ADD CONSTRAINT pk_technical_task_tb PRIMARY KEY (object_uuid);


--
-- Name: skill_task_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill_task_ref
    ADD CONSTRAINT skill_task_ref_pkey PRIMARY KEY (skill_uuid, task_uuid);


--
-- Name: solution_file_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solution_file_ref
    ADD CONSTRAINT solution_file_ref_pkey PRIMARY KEY (file_uuid, solution_uuid);


--
-- Name: technical_task_file_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY technical_task_file_ref
    ADD CONSTRAINT technical_task_file_ref_pkey PRIMARY KEY (technical_task_uuid, file_uuid);


--
-- Name: idx_customer_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_customer_tb ON customer_tb USING btree (login_ref);


--
-- Name: idx_freelance_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_freelance_tb ON freelance_tb USING btree (login_ref);


--
-- Name: idx_freelancer_skills_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_freelancer_skills_ref ON freelancer_skills_ref USING btree (freelancer_uuid);


--
-- Name: idx_freelancer_skills_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_freelancer_skills_ref_0 ON freelancer_skills_ref USING btree (skill_uuid);


--
-- Name: idx_freelanser_task_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_freelanser_task_ref ON freelanser_task_ref USING btree (task_uuid);


--
-- Name: idx_frelancer_file_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_frelancer_file_ref ON frelancer_file_ref USING btree (freelancer_uuid);


--
-- Name: idx_frelancer_file_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_frelancer_file_ref_0 ON frelancer_file_ref USING btree (file_uuid);


--
-- Name: idx_manager_skills_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_manager_skills_ref ON manager_skills_ref USING btree (manager_uuid);


--
-- Name: idx_manager_skills_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_manager_skills_ref_0 ON manager_skills_ref USING btree (skill_uuid);


--
-- Name: idx_manager_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_manager_tb ON manager_tb USING btree (login_ref);


--
-- Name: idx_order_file_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_order_file_ref ON order_file_ref USING btree (order_uuid);


--
-- Name: idx_order_file_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_order_file_ref_0 ON order_file_ref USING btree (file_uuid);


--
-- Name: idx_order_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_order_tb ON order_tb USING btree (manager_ref);


--
-- Name: idx_order_tb_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_order_tb_0 ON order_tb USING btree (customer_ref);


--
-- Name: idx_skill_task_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_skill_task_ref ON skill_task_ref USING btree (skill_uuid);


--
-- Name: idx_skill_task_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_skill_task_ref_0 ON skill_task_ref USING btree (task_uuid);


--
-- Name: idx_solution_file_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_solution_file_ref ON solution_file_ref USING btree (file_uuid);


--
-- Name: idx_solution_file_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_solution_file_ref_0 ON solution_file_ref USING btree (solution_uuid);


--
-- Name: idx_solution_table; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_solution_table ON solution_tb USING btree (task_ref);


--
-- Name: idx_task_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_task_tb ON task_tb USING btree (order_ref);


--
-- Name: idx_technical_task_file_ref; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_technical_task_file_ref ON technical_task_file_ref USING btree (technical_task_uuid);


--
-- Name: idx_technical_task_file_ref_0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_technical_task_file_ref_0 ON technical_task_file_ref USING btree (file_uuid);


--
-- Name: idx_technical_task_tb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_technical_task_tb ON technical_task_tb USING btree (order_ref);


--
-- Name: fk_customer_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer_tb
    ADD CONSTRAINT fk_customer_tb FOREIGN KEY (login_ref) REFERENCES login_tb(object_uuid) ON DELETE RESTRICT;


--
-- Name: fk_freelance_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY freelance_tb
    ADD CONSTRAINT fk_freelance_tb FOREIGN KEY (login_ref) REFERENCES login_tb(object_uuid);


--
-- Name: fk_freelancer_skills_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY freelancer_skills_ref
    ADD CONSTRAINT fk_freelancer_skills_ref FOREIGN KEY (freelancer_uuid) REFERENCES freelance_tb(object_uuid);


--
-- Name: fk_freelancer_skills_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY freelancer_skills_ref
    ADD CONSTRAINT fk_freelancer_skills_ref_0 FOREIGN KEY (skill_uuid) REFERENCES skills_table(object_uuid);


--
-- Name: fk_freelanser_task_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY freelanser_task_ref
    ADD CONSTRAINT fk_freelanser_task_ref FOREIGN KEY (freelancer_uuid) REFERENCES freelance_tb(object_uuid);


--
-- Name: fk_freelanser_task_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY freelanser_task_ref
    ADD CONSTRAINT fk_freelanser_task_ref_0 FOREIGN KEY (task_uuid) REFERENCES task_tb(object_uuid);


--
-- Name: fk_frelancer_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY frelancer_file_ref
    ADD CONSTRAINT fk_frelancer_file_ref FOREIGN KEY (freelancer_uuid) REFERENCES freelance_tb(object_uuid);


--
-- Name: fk_frelancer_file_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY frelancer_file_ref
    ADD CONSTRAINT fk_frelancer_file_ref_0 FOREIGN KEY (file_uuid) REFERENCES file_tb(object_uuid);


--
-- Name: fk_manager_skills_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY manager_skills_ref
    ADD CONSTRAINT fk_manager_skills_ref FOREIGN KEY (manager_uuid) REFERENCES manager_tb(object_uuid);


--
-- Name: fk_manager_skills_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY manager_skills_ref
    ADD CONSTRAINT fk_manager_skills_ref_0 FOREIGN KEY (skill_uuid) REFERENCES skills_table(object_uuid);


--
-- Name: fk_manager_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY manager_tb
    ADD CONSTRAINT fk_manager_tb FOREIGN KEY (login_ref) REFERENCES login_tb(object_uuid) ON DELETE RESTRICT;


--
-- Name: fk_order_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_file_ref
    ADD CONSTRAINT fk_order_file_ref FOREIGN KEY (order_uuid) REFERENCES order_tb(object_uuid);


--
-- Name: fk_order_file_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_file_ref
    ADD CONSTRAINT fk_order_file_ref_0 FOREIGN KEY (file_uuid) REFERENCES file_tb(object_uuid);


--
-- Name: fk_order_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_tb
    ADD CONSTRAINT fk_order_tb FOREIGN KEY (manager_ref) REFERENCES manager_tb(object_uuid);


--
-- Name: fk_order_tb_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY order_tb
    ADD CONSTRAINT fk_order_tb_0 FOREIGN KEY (customer_ref) REFERENCES customer_tb(object_uuid);


--
-- Name: fk_skill_task_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill_task_ref
    ADD CONSTRAINT fk_skill_task_ref FOREIGN KEY (skill_uuid) REFERENCES skills_table(object_uuid);


--
-- Name: fk_skill_task_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill_task_ref
    ADD CONSTRAINT fk_skill_task_ref_0 FOREIGN KEY (task_uuid) REFERENCES task_tb(object_uuid);


--
-- Name: fk_solution_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solution_file_ref
    ADD CONSTRAINT fk_solution_file_ref FOREIGN KEY (file_uuid) REFERENCES file_tb(object_uuid);


--
-- Name: fk_solution_file_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solution_file_ref
    ADD CONSTRAINT fk_solution_file_ref_0 FOREIGN KEY (solution_uuid) REFERENCES solution_tb(object_uuid);


--
-- Name: fk_solution_table; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solution_tb
    ADD CONSTRAINT fk_solution_table FOREIGN KEY (task_ref) REFERENCES task_tb(object_uuid);


--
-- Name: fk_task_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY task_tb
    ADD CONSTRAINT fk_task_tb FOREIGN KEY (order_ref) REFERENCES order_tb(object_uuid) ON DELETE RESTRICT;


--
-- Name: fk_technical_task_file_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY technical_task_file_ref
    ADD CONSTRAINT fk_technical_task_file_ref FOREIGN KEY (technical_task_uuid) REFERENCES technical_task_tb(object_uuid);


--
-- Name: fk_technical_task_file_ref_0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY technical_task_file_ref
    ADD CONSTRAINT fk_technical_task_file_ref_0 FOREIGN KEY (file_uuid) REFERENCES file_tb(object_uuid);


--
-- Name: fk_technical_task_tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY technical_task_tb
    ADD CONSTRAINT fk_technical_task_tb FOREIGN KEY (order_ref) REFERENCES order_tb(object_uuid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

