package com.example.tubesRPL.Koordinator.TA;

import java.util.List;


public interface TAInterface {

    // Method to save TA data
    int save(TAData taData);

    int saveNilaiDisiplin(TAData taData);

    // Method to fetch all TA data
    List<TAData> findAll();

    // Method to check if TA data exists by ID
    boolean existsById(Integer id);

    // Method to delete TA data by ID
    int deleteById(Integer id);

    // Method to update TA data
    int update(TAData taData);

    //Method to fetch TA data by semesterAkademik
    List<TAData> findBysemesterAkademik( String semesterAkademik);

    //Method to fetch all TA data by semesterAkademik
    List<String> findAllSemesterAkademik();

    //Method to fetch TA data by nama dosen as Penguji
    List<TAData> findBySemesterAkademikPenguji(String semesterAkademik, String nama);

    //Method to fetch TA data by nama dosen as Pembimbing
    List<TAData> findBySemesterAkademikPembimbing(String semesterAkademik, String nama);

    //Method to fetch all TA data by semesterAkademik
    List<String> findAllSemesterAkademikPembimbing(String namaDosen);

    //Method to fetch all TA data by semesterAkademik
    List<String> findAllSemesterAkademikPenguji(String namaDosen);

    List<String> findAllDosen();

    List<String> findAllMahasiswa();

    List<String> findAllTempat();

}
