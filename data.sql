CREATE TABLE users (
id_users SERIAL PRIMARY KEY,
nama_users VARCHAR(100) NOT NULL,
email_users VARCHAR(100) UNIQUE NOT NULL,
nomor_induk VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(100) NOT NULL
);

CREATE TABLE mahasiswa (
nama_mahasiswa VARCHAR(255) PRIMARY KEY,
npm VARCHAR(15) NOT NULL,
email_mahasiswa VARCHAR(100) UNIQUE NOT NULL,
password_mahasiswa VARCHAR(255) NOT NULL
);


CREATE TABLE dosen (
id_dosen SERIAL PRIMARY KEY,
nama_dosen VARCHAR(100) NOT NULL,
email_dosen VARCHAR(100) UNIQUE NOT NULL,
password_dosen VARCHAR(255) NOT NULL
);


CREATE TABLE koordinator (
id_dosen SERIAL PRIMARY KEY,
nama_dosen VARCHAR(100) NOT NULL,
no_dosen VARCHAR(100) NOT NULL,
email_dosen VARCHAR(100) UNIQUE NOT NULL,
password_dosen VARCHAR(255) NOT NULL
);


CREATE TABLE penguji (
id_penguji VARCHAR(15) PRIMARY KEY REFERENCES dosen(id_dosen),
id_ta VARCHAR(100) REFERENCES ta_data(id_ta)
);

CREATE TABLE pembimbing (
id_pembimbing VARCHAR(15) PRIMARY KEY REFERENCES dosen(id_dosen),
id_ta VARCHAR(100) REFERENCES ta_data(id_ta)
);


CREATE TABLE ta_data (
id_ta SERIAL PRIMARY KEY,
nama_mahasiswa VARCHAR(255) REFERENCES mahasiswa(nama_mahasiswa) NOT NULL,
judul_skripsi VARCHAR(255) NOT NULL,
jenis_ta VARCHAR(50) NOT NULL,
ruangan VARCHAR(255) NOT NULL,
tanggal_sidang TIMESTAMP NOT NULL,
penguji_1 VARCHAR(255),
penguji_2 VARCHAR(255),
pembimbing VARCHAR(255),
semester_akademik VARCHAR(50)
);


CREATE TABLE ruangan (
id_ruangan SERIAL PRIMARY KEY,
nama_ruangan VARCHAR(255)
);

INSERT INTO ruangan (nama_ruangan) 
VALUES 
('AG2U.06.01.01'), 
('AG2U.06.01.02'), 
('AG2U.06.01.03'), 
('AG2U.06.01.04'), 
('10.03.0017'), 
('10.03.0016'), 
('10.03.0023');

CREATE TABLE catatan (
id_catatan SERIAL PRIMARY KEY,
id_ta INT REFERENCES ta_data(id_ta),
isi_catatan TEXT
);

CREATE TABLE nilai_komponenTa (
id_nilaiKomponenTa SERIAL PRIMARY KEY,
nama_komponen VARCHAR(100),
role_penilai VARCHAR(100),
nilai NUMERIC(5, 2) CHECK (nilai >= 0 AND nilai <= 100),
id_ta INT NOT NULL REFERENCES ta_data(id_ta)
);


CREATE TABLE avg_nilaiPenguji (
id_ta INT REFERENCES ta_data(id_ta),
id_dosen INT REFERENCES dosen(id_dosen),
total_nilaiPenguji NUMERIC(5, 2) NOT NULL CHECK (total_nilaiPenguji >= 0 AND total_nilaiPenguji <= 100)
);


CREATE TABLE avg_nilaiPembimbing (
id_ta INT REFERENCES ta_data(id_ta),
id_dosen INT REFERENCES dosen(id_dosen),
total_nilaiPembimbing NUMERIC(5, 2) NOT NULL CHECK (total_nilaiPembimbing >= 0 AND total_nilaiPembimbing <= 100)
);

Tabel Nilai Kedisiplinan
CREATE TABLE nilai_kedisiplinan (
id_ta INT REFERENCES ta_data(id_ta),
nilai_disiplin NUMERIC(5, 2) NOT NULL CHECK (nilai_disiplin >= 0 AND nilai_disiplin <= 100)
);

Tabel Bobot Nilai Komponen
CREATE TABLE bobot_nilaiKomponen (
id_komponen SERIAL PRIMARY KEY,
nama_role VARCHAR(100),
nama_komponen VARCHAR(100),
bobot NUMERIC(5, 2) NOT NULL CHECK (bobot >= 0 AND bobot <= 100)
);