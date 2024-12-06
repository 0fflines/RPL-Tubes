toc.dat                                                                                             0000600 0004000 0002000 00000013523 14724350665 0014457 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP   0                    |            tubesrpl    17.2    17.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                    0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                    0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                    1262    16465    tubesrpl    DATABASE     �   CREATE DATABASE tubesrpl WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Indonesian_Indonesia.1252';
    DROP DATABASE tubesrpl;
                     postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                     pg_database_owner    false                    0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                        pg_database_owner    false    4         �            1259    16466    dosen    TABLE     �   CREATE TABLE public.dosen (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);
    DROP TABLE public.dosen;
       public         heap r       postgres    false    4         �            1259    16471    koordinator_ta    TABLE     �   CREATE TABLE public.koordinator_ta (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);
 "   DROP TABLE public.koordinator_ta;
       public         heap r       postgres    false    4         �            1259    16476 	   mahasiswa    TABLE     �   CREATE TABLE public.mahasiswa (
    npm integer NOT NULL,
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);
    DROP TABLE public.mahasiswa;
       public         heap r       postgres    false    4         �            1259    16481 
   pembimbing    TABLE     �   CREATE TABLE public.pembimbing (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL,
    notes_pembimbing bit varying NOT NULL
);
    DROP TABLE public.pembimbing;
       public         heap r       postgres    false    4         �            1259    16486    penguji    TABLE     �   CREATE TABLE public.penguji (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);
    DROP TABLE public.penguji;
       public         heap r       postgres    false    4         �            1259    16491    tugas_akhir    TABLE     M  CREATE TABLE public.tugas_akhir (
    id_ta integer NOT NULL,
    jenis_ta integer NOT NULL,
    nama_skripsi bit varying NOT NULL,
    tahun_akademik integer NOT NULL,
    tipe_semester bit varying NOT NULL,
    tanggal_sidang date NOT NULL,
    tempat_sidang bit varying NOT NULL,
    jam_sidang time without time zone NOT NULL
);
    DROP TABLE public.tugas_akhir;
       public         heap r       postgres    false    4                   0    16466    dosen 
   TABLE DATA           :   COPY public.dosen (email, username, password) FROM stdin;
    public               postgres    false    217       4867.dat           0    16471    koordinator_ta 
   TABLE DATA           C   COPY public.koordinator_ta (email, username, password) FROM stdin;
    public               postgres    false    218       4868.dat           0    16476 	   mahasiswa 
   TABLE DATA           C   COPY public.mahasiswa (npm, email, username, password) FROM stdin;
    public               postgres    false    219       4869.dat           0    16481 
   pembimbing 
   TABLE DATA           Q   COPY public.pembimbing (email, username, password, notes_pembimbing) FROM stdin;
    public               postgres    false    220       4870.dat           0    16486    penguji 
   TABLE DATA           <   COPY public.penguji (email, username, password) FROM stdin;
    public               postgres    false    221       4871.dat           0    16491    tugas_akhir 
   TABLE DATA           �   COPY public.tugas_akhir (id_ta, jenis_ta, nama_skripsi, tahun_akademik, tipe_semester, tanggal_sidang, tempat_sidang, jam_sidang) FROM stdin;
    public               postgres    false    222       4872.dat k           2606    16497    dosen dosen_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.dosen
    ADD CONSTRAINT dosen_pkey PRIMARY KEY (email);
 :   ALTER TABLE ONLY public.dosen DROP CONSTRAINT dosen_pkey;
       public                 postgres    false    217         m           2606    16499 "   koordinator_ta koordinator_ta_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.koordinator_ta
    ADD CONSTRAINT koordinator_ta_pkey PRIMARY KEY (email);
 L   ALTER TABLE ONLY public.koordinator_ta DROP CONSTRAINT koordinator_ta_pkey;
       public                 postgres    false    218         o           2606    16501    mahasiswa mahasiswa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT mahasiswa_pkey PRIMARY KEY (npm);
 B   ALTER TABLE ONLY public.mahasiswa DROP CONSTRAINT mahasiswa_pkey;
       public                 postgres    false    219         q           2606    16503    tugas_akhir tugas_akhir_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tugas_akhir
    ADD CONSTRAINT tugas_akhir_pkey PRIMARY KEY (id_ta);
 F   ALTER TABLE ONLY public.tugas_akhir DROP CONSTRAINT tugas_akhir_pkey;
       public                 postgres    false    222                                                                                                                                                                                     4867.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4868.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014272 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4869.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4870.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4871.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           4872.dat                                                                                            0000600 0004000 0002000 00000000005 14724350665 0014265 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000013307 14724350665 0015404 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE tubesrpl;
--
-- Name: tubesrpl; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE tubesrpl WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Indonesian_Indonesia.1252';


ALTER DATABASE tubesrpl OWNER TO postgres;

\connect tubesrpl

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: dosen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dosen (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);


ALTER TABLE public.dosen OWNER TO postgres;

--
-- Name: koordinator_ta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.koordinator_ta (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);


ALTER TABLE public.koordinator_ta OWNER TO postgres;

--
-- Name: mahasiswa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mahasiswa (
    npm integer NOT NULL,
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);


ALTER TABLE public.mahasiswa OWNER TO postgres;

--
-- Name: pembimbing; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pembimbing (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL,
    notes_pembimbing bit varying NOT NULL
);


ALTER TABLE public.pembimbing OWNER TO postgres;

--
-- Name: penguji; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.penguji (
    email bit varying NOT NULL,
    username bit varying NOT NULL,
    password bit varying NOT NULL
);


ALTER TABLE public.penguji OWNER TO postgres;

--
-- Name: tugas_akhir; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tugas_akhir (
    id_ta integer NOT NULL,
    jenis_ta integer NOT NULL,
    nama_skripsi bit varying NOT NULL,
    tahun_akademik integer NOT NULL,
    tipe_semester bit varying NOT NULL,
    tanggal_sidang date NOT NULL,
    tempat_sidang bit varying NOT NULL,
    jam_sidang time without time zone NOT NULL
);


ALTER TABLE public.tugas_akhir OWNER TO postgres;

--
-- Data for Name: dosen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dosen (email, username, password) FROM stdin;
\.
COPY public.dosen (email, username, password) FROM '$$PATH$$/4867.dat';

--
-- Data for Name: koordinator_ta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.koordinator_ta (email, username, password) FROM stdin;
\.
COPY public.koordinator_ta (email, username, password) FROM '$$PATH$$/4868.dat';

--
-- Data for Name: mahasiswa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mahasiswa (npm, email, username, password) FROM stdin;
\.
COPY public.mahasiswa (npm, email, username, password) FROM '$$PATH$$/4869.dat';

--
-- Data for Name: pembimbing; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pembimbing (email, username, password, notes_pembimbing) FROM stdin;
\.
COPY public.pembimbing (email, username, password, notes_pembimbing) FROM '$$PATH$$/4870.dat';

--
-- Data for Name: penguji; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.penguji (email, username, password) FROM stdin;
\.
COPY public.penguji (email, username, password) FROM '$$PATH$$/4871.dat';

--
-- Data for Name: tugas_akhir; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tugas_akhir (id_ta, jenis_ta, nama_skripsi, tahun_akademik, tipe_semester, tanggal_sidang, tempat_sidang, jam_sidang) FROM stdin;
\.
COPY public.tugas_akhir (id_ta, jenis_ta, nama_skripsi, tahun_akademik, tipe_semester, tanggal_sidang, tempat_sidang, jam_sidang) FROM '$$PATH$$/4872.dat';

--
-- Name: dosen dosen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dosen
    ADD CONSTRAINT dosen_pkey PRIMARY KEY (email);


--
-- Name: koordinator_ta koordinator_ta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.koordinator_ta
    ADD CONSTRAINT koordinator_ta_pkey PRIMARY KEY (email);


--
-- Name: mahasiswa mahasiswa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT mahasiswa_pkey PRIMARY KEY (npm);


--
-- Name: tugas_akhir tugas_akhir_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tugas_akhir
    ADD CONSTRAINT tugas_akhir_pkey PRIMARY KEY (id_ta);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         