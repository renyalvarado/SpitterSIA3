--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.12
-- Dumped by pg_dump version 9.1.12
-- Started on 2014-02-28 21:12:06 VET

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 165 (class 3079 OID 11677)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1910 (class 0 OID 0)
-- Dependencies: 165
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 177 (class 1255 OID 25196)
-- Dependencies: 495 5
-- Name: holamundo(character varying); Type: FUNCTION; Schema: public; Owner: springinaction
--

CREATE FUNCTION holamundo(miparam character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $$begin
return 'Hola ' || miparam || ' !';
end;$$;


ALTER FUNCTION public.holamundo(miparam character varying) OWNER TO springinaction;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 25199)
-- Dependencies: 5
-- Name: spitter; Type: TABLE; Schema: public; Owner: springinaction; Tablespace: 
--

CREATE TABLE spitter (
    id integer NOT NULL,
    username character varying(30) NOT NULL,
    fullname character varying(100),
    password character varying(50),
    email character varying(100),
    updatebyemail boolean
);


ALTER TABLE public.spitter OWNER TO springinaction;

--
-- TOC entry 161 (class 1259 OID 25197)
-- Dependencies: 162 5
-- Name: spitter_id_seq; Type: SEQUENCE; Schema: public; Owner: springinaction
--

CREATE SEQUENCE spitter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spitter_id_seq OWNER TO springinaction;

--
-- TOC entry 1911 (class 0 OID 0)
-- Dependencies: 161
-- Name: spitter_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: springinaction
--

ALTER SEQUENCE spitter_id_seq OWNED BY spitter.id;


--
-- TOC entry 164 (class 1259 OID 25207)
-- Dependencies: 1792 5
-- Name: spittle; Type: TABLE; Schema: public; Owner: springinaction; Tablespace: 
--

CREATE TABLE spittle (
    id integer NOT NULL,
    text character varying(140),
    "when" timestamp with time zone DEFAULT now() NOT NULL,
    spitter_id integer NOT NULL
);


ALTER TABLE public.spittle OWNER TO springinaction;

--
-- TOC entry 163 (class 1259 OID 25205)
-- Dependencies: 5 164
-- Name: spittle_id_seq; Type: SEQUENCE; Schema: public; Owner: springinaction
--

CREATE SEQUENCE spittle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spittle_id_seq OWNER TO springinaction;

--
-- TOC entry 1912 (class 0 OID 0)
-- Dependencies: 163
-- Name: spittle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: springinaction
--

ALTER SEQUENCE spittle_id_seq OWNED BY spittle.id;


--
-- TOC entry 1790 (class 2604 OID 25202)
-- Dependencies: 162 161 162
-- Name: id; Type: DEFAULT; Schema: public; Owner: springinaction
--

ALTER TABLE ONLY spitter ALTER COLUMN id SET DEFAULT nextval('spitter_id_seq'::regclass);


--
-- TOC entry 1791 (class 2604 OID 25210)
-- Dependencies: 163 164 164
-- Name: id; Type: DEFAULT; Schema: public; Owner: springinaction
--

ALTER TABLE ONLY spittle ALTER COLUMN id SET DEFAULT nextval('spittle_id_seq'::regclass);


--
-- TOC entry 1900 (class 0 OID 25199)
-- Dependencies: 162 1903
-- Data for Name: spitter; Type: TABLE DATA; Schema: public; Owner: springinaction
--

INSERT INTO spitter (id, username, fullname, password, email, updatebyemail) VALUES (1, 'thucydides', 'Thucydides', '123456', 'thucydides@hellas.gov', true);
INSERT INTO spitter (id, username, fullname, password, email, updatebyemail) VALUES (2, 'aristotle', 'Aristotle', '789012', 'aristotle@philosophy.org', true);
INSERT INTO spitter (id, username, fullname, password, email, updatebyemail) VALUES (4, 'plato', 'Plato', 'p3dr0', 'plato@academy.edu', true);
INSERT INTO spitter (id, username, fullname, password, email, updatebyemail) VALUES (5, 'pericles', 'Pericles', 'p3dr02', 'pericles@athens.gov', true);
INSERT INTO spitter (id, username, fullname, password, email, updatebyemail) VALUES (6, 'nicias', 'Nicias', 'p3dr03', 'nicias@athens.gov', true);


--
-- TOC entry 1913 (class 0 OID 0)
-- Dependencies: 161
-- Name: spitter_id_seq; Type: SEQUENCE SET; Schema: public; Owner: springinaction
--

SELECT pg_catalog.setval('spitter_id_seq', 6, true);


--
-- TOC entry 1902 (class 0 OID 25207)
-- Dependencies: 164 1903
-- Data for Name: spittle; Type: TABLE DATA; Schema: public; Owner: springinaction
--

INSERT INTO spittle (id, text, "when", spitter_id) VALUES (1, 'In fine, I have written my work, not as an essay which is to win the applause of the moment, but as a possession for all time. ', '2013-12-29 12:01:57.471455-04:30', 1);
INSERT INTO spittle (id, text, "when", spitter_id) VALUES (2, 'They stood where they stood by the power of the sword. ', '2013-12-29 12:02:22.806769-04:30', 1);
INSERT INTO spittle (id, text, "when", spitter_id) VALUES (3, 'Man is by nature a political animal.', '2013-12-29 12:02:36.679315-04:30', 2);


--
-- TOC entry 1914 (class 0 OID 0)
-- Dependencies: 163
-- Name: spittle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: springinaction
--

SELECT pg_catalog.setval('spittle_id_seq', 3, true);


--
-- TOC entry 1794 (class 2606 OID 25204)
-- Dependencies: 162 162 1904
-- Name: pk_spitter; Type: CONSTRAINT; Schema: public; Owner: springinaction; Tablespace: 
--

ALTER TABLE ONLY spitter
    ADD CONSTRAINT pk_spitter PRIMARY KEY (id);


--
-- TOC entry 1796 (class 2606 OID 25212)
-- Dependencies: 164 164 1904
-- Name: pk_spittle; Type: CONSTRAINT; Schema: public; Owner: springinaction; Tablespace: 
--

ALTER TABLE ONLY spittle
    ADD CONSTRAINT pk_spittle PRIMARY KEY (id);


--
-- TOC entry 1797 (class 2606 OID 25228)
-- Dependencies: 1793 164 162 1904
-- Name: fk_spittle_spitter; Type: FK CONSTRAINT; Schema: public; Owner: springinaction
--

ALTER TABLE ONLY spittle
    ADD CONSTRAINT fk_spittle_spitter FOREIGN KEY (spitter_id) REFERENCES spitter(id);


--
-- TOC entry 1909 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-02-28 21:12:06 VET

--
-- PostgreSQL database dump complete
--

