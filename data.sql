-- Query untuk membuat tabel mahasiswa
CREATE TABLE mahasiswa (
    nama_mahasiswa VARCHAR(255) PRIMARY KEY,
    npm VARCHAR(15) NOT NULL,
    email_mahasiswa VARCHAR(100) UNIQUE NOT NULL,
    password_mahasiswa VARCHAR(255) NOT NULL
);

-- Query untuk membuat tabel dosen
CREATE TABLE dosen (
    id_dosen SERIAL PRIMARY KEY,
    nama_dosen VARCHAR(100) NOT NULL,
    email_dosen VARCHAR(100) UNIQUE NOT NULL,
    password_dosen VARCHAR(255) NOT NULL
);

-- insert data mahasiswa

-- insert data dosen
INSERT INTO dosen (nama_dosen, email_dosen, password_dosen)
VALUES
('Keenan Adiwijaya Leman, S.T, M.T', 'keenan.leman@unpar.ac.id', 'dosen123'),
('Maria Veronica, S.T, M.T', 'maria.veronica@unpar.ac.id', 'dosen123'),
('Lionov, Ph.D', 'lionov@unpar.ac.id', 'dosen123'),
('Raymond Chandra Putra, S.T., M.T', 'raymond.chandra@unpar.ac.id', 'dosen123'),
('Mariskha Tri Adithia, S.Si., M.Sc., PDEng', 'mariskha@unpar.ac.id', 'dosen123'),
('Husnul Hakim, S.Kom., M.T', 'husnulhakim@unpar.ac.id', 'dosen123'),
('Pascal Alfadian Nugroho, S.Kom., M.Comp', 'pascal@unpar.ac.id', 'dosen123'),
('Natalia, S.Si., M.Si', 'natalia@unpar.ac.id', 'dosen123'),
('Vania Natali, S.Kom., M.T', 'vania.natali@unpar.ac.id', 'dosen123'),
('Luciana Abednego, S.Kom., M.T', 'luciana@unpar.ac.id', 'dosen123');

-- -- Query untuk membuat tabel daftar dosen penguji
-- CREATE TABLE penguji (
-- 	id_penguji VARCHAR(15) PRIMARY KEY REFERENCES dosen(id_dosen),
-- 	id_ta VARCHAR(100) REFERENCES ta_data(id_ta)
-- );
-- -- Query untuk membuat tabel daftar dosen penguji
-- CREATE TABLE pembimbing (
-- 	id_pembimbing VARCHAR(15) PRIMARY KEY REFERENCES dosen(id_dosen),
-- 	id_ta VARCHAR(100) REFERENCES ta_data(id_ta)
-- );

-- Query untuk membuat tabel TA
CREATE TABLE ta_data (
    id_ta SERIAL PRIMARY KEY,
    nama_mahasiswa VARCHAR(255)  REFERENCES mahasiswa(nama_mahasiswa)  NOT NULL,
    judul_skripsi VARCHAR(255) NOT NULL,
    jenis_ta VARCHAR(50) NOT NULL,
    ruangan VARCHAR(255) NOT NULL,
    tanggal_sidang TIMESTAMP NOT NULL,
    penguji_1 VARCHAR(255),
    penguji_2 VARCHAR(255),
    pembimbing VARCHAR(255),
    semester_akademik VARCHAR(50)
);

-- Query untuk membuat tabel ruangan
CREATE TABLE ruangan (
    id_ruangan SERIAL PRIMARY KEY,
    nama_ruangan VARCHAR(255) 
);

-- insert data ruangan yang tersedia
INSERT INTO ruangan (nama_ruangan) VALUES 
	('AG2U.06.01.01'),
	('AG2U.06.01.02'),
	('AG2U.06.01.03'),
	('AG2U.06.01.04'),
	('10.03.0017'),
	('10.03.0016'),
	('10.03.0023');

-- Query untuk membuat tabel catatan
CREATE TABLE catatan (
    id_catatan SERIAL PRIMARY KEY,
    id_ta INT REFERENCES ta_data(id_ta),
    isi_catatan TEXT
);

-- Query untuk membuat tabel semua nilai komponen ta
CREATE TABLE nilai_komponenTa (
    id_nilaiKomponenTa SERIAL PRIMARY KEY,
    nama_komponen VARCHAR(100),
	role_penilai VARCHAR(100),
    nilai NUMERIC(5, 2) CHECK (nilai >= 0 AND nilai <= 100),
    id_ta INT NOT NULL REFERENCES ta_data(id_ta)
);

-- Query untuk menyimpan rata-rata nilai semua komponen dari Penguji
CREATE TABLE avg_nilaiPenguji(
	id_ta INT REFERENCES ta_data(id_ta),
	id_dosen INT REFERENCES dosen(id_dosen),
	total_nilaiPenguji NUMERIC(5, 2)NOT NULL CHECK (total_nilaiPenguji >= 0 AND total_nilaiPenguji <= 100)
);

-- Query untuk menyimpan rata-rata nilai semua komponen dari Pembimbing
CREATE TABLE avg_nilaiPembimbing(
	id_ta INT REFERENCES ta_data(id_ta),
	id_dosen INT REFERENCES dosen(id_dosen),
	total_nilaiPembimbing NUMERIC(5, 2)NOT NULL CHECK (total_nilaiPembimbing >= 0 AND total_nilaiPembimbing  <= 100)
);

-- Query untuk menyimpan nilai kedisiplinan dari koordinator
CREATE TABLE nilai_kedisiplinan(
	id_ta INT REFERENCES ta_data(id_ta),
	nilai_disiplin NUMERIC(5, 2)NOT NULL CHECK (nilai_disiplin >= 0 AND nilai_disiplin <= 100)
);

-- Query untuk membuat tabel bobotNilai untuk komponen
CREATE TABLE bobot_nilaiKomponen (
	id_komponen SERIAL PRIMARY KEY,
	nama_role VARCHAR(100),
    nama_komponen VARCHAR(100),
    bobot NUMERIC(5, 2)NOT NULL CHECK (bobot >= 0 AND bobot <= 100)
);

-- Query untuk membuat tabel bobotNilai untuk setiap role
CREATE TABLE bobotRole (
	id_bobotRole SERIAL PRIMARY KEY,
	bobotPenguji NUMERIC(5, 2)NOT NULL CHECK (bobotPenguji  >= 0 AND bobotPenguji  <= 100),
	bobotPembimbing NUMERIC(5, 2)NOT NULL CHECK (bobotPembimbing >= 0 AND bobotPembimbing <= 100),
	bobotKoordinator NUMERIC(5, 2)NOT NULL CHECK (bobotKoordinator >= 0 AND bobotKoordinator <= 100)
);

-- Query untuk membuat tabel bap
CREATE TABLE bap (
    id_ta INT PRIMARY KEY REFERENCES ta_data(id_ta),
	nilai_penguji1 NUMERIC(5, 2)NOT NULL CHECK (nilai_penguji1 >= 0 AND nilai_penguji1 <= 100),
	nilai_penguji2 NUMERIC(5, 2)NOT NULL CHECK (nilai_penguji2 >= 0 AND nilai_penguji2 <= 100),
	nilai_pembimbing NUMERIC(5, 2)NOT NULL CHECK (nilai_pembimbing >= 0 AND nilai_pembimbing <= 100),
	id_bobot INT REFERENCES bobotRole(id_bobotRole),
    nilai_total NUMERIC(5, 2)NOT NULL CHECK (nilai_total >= 0 AND  nilai_total <= 100)
);