--Data Masih Dummy

CREATE TABLE ta_data (
    id SERIAL PRIMARY KEY,
    nama_mahasiswa VARCHAR(255) NOT NULL,
    judul_skripsi VARCHAR(255) NOT NULL,
    jenis_ta VARCHAR(50) NOT NULL,
    tempat VARCHAR(255),
    tanggal_sidang TIMESTAMP NOT NULL,
    penguji_1 VARCHAR(255),
    penguji_2 VARCHAR(255),
    pembimbing_utama VARCHAR(255),
    pembimbing_pendamping VARCHAR(255),
    semester_akademik VARCHAR(50)
);

create table nama_dosen (
	nama_dosen VARCHAR(255) PRIMARY KEY,
	email_dosen VARCHAR(255),
	password VARCHAR(50)
)

INSERT INTO nama_dosen (nama_dosen, email_dosen, password)
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


--buat bagian siapa aja penguji sama pembibing nyimpennya gimana belum kepikir sori
-- CREATE TABLE tugas_akhir(
--     id SERIAL PRIMARY KEY,
--     nama_mahasiswa VARCHAR(100) NOT NULL,
--     judul_skripsi VARCHAR(100),
--     waktu_sidang TIMESTAMP,
--     tempat_sidang VARCHAR(100),
--     tipe_sidang INTEGER,
--     bap_file BYTEA NOT NULL
-- )

-- CREATE TABLE ta_data (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     nama_mahasiswa VARCHAR(100) NOT NULL,
--     judul_skripsi VARCHAR(255) NOT NULL,
--     jenis_ta ENUM('TA1', 'TA2') NOT NULL,
--     tempat VARCHAR(100),
--     tanggal_sidang DATETIME,
--     penguji_1 VARCHAR(100),
--     penguji_2 VARCHAR(100),
--     pembimbing_utama VARCHAR(100),
--     pembimbing_pendamping VARCHAR(100),
--     semester_akademik VARCHAR(50)
-- );

