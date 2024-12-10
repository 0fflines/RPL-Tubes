--Data Masih Dummy

CREATE TABLE skripsi_penguji (
    id SERIAL PRIMARY KEY,
    nama_mahasiswa VARCHAR(100) NOT NULL,
    judul_skripsi VARCHAR(255),
    waktu TIMESTAMP,
    tempat VARCHAR(100),
    nilai INTEGER,
    tahun_akademik VARCHAR(9)
);

INSERT INTO skripsi_penguji (nama_mahasiswa, judul_skripsi, waktu, tempat, nilai, tahun_akademik) VALUES
('Kevin', 'Skripsi A', '2023-08-01 10:00:00', 'Ruang A', 90, '2023/2024'),
('Andini', 'Skripsi B', '2022-06-15 14:00:00', 'Ruang B', 85, '2021/2022'),
('Hafiz', 'Skripsi C', '2024-01-10 09:00:00', 'Ruang C', 88, '2023/2024'),
('Zaki', 'Skripsi A', '2024-08-10 10:00:00', 'Ruang C', 88, '2024/2025'),
('Fahza', 'Skripsi B', '2024-08-10 10:00:00', 'Ruang C', 88, '2024/2025'),
('Wombat', 'Skripsi A', '2022-09-10 13:00:00', 'Ruang D', 76, '2022/2023'),
('Kapibara', 'Skripsi B', '2023-02-8 14:00:00', 'Ruang B', 86, '2022/2023'),
('KapiDion', 'Skripsi B', '2020-02-8 16:00:00', 'Ruang D', 76, '2020/2021');

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

