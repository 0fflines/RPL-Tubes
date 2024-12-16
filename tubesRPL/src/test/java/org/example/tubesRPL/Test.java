package org.example.tubesRPL;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.tubesRPL.Dosen.Nilai.NilaiKomponenTA;
import com.example.tubesRPL.Dosen.Nilai.NilaiKomponenTAController;
import com.example.tubesRPL.Dosen.Nilai.NilaiKomponenTARepository;


import java.util.Arrays;
import java.util.List;

class NilaiKomponenTAControllerTest {

    @Mock
    private NilaiKomponenTARepository nilaiKomponenTARepository;

    @InjectMocks
    private NilaiKomponenTAController nilaiKomponenTAController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadNilai() {
        // Mock data
        String role = "Dosen";
        int idTA = 1;
        String namaDosen = "Dr. John";
        List<NilaiKomponenTA> mockData = Arrays.asList(
                new NilaiKomponenTA(1, "bobot1", role, 80, idTA, role),
                new NilaiKomponenTA(2, "bobot2", role, 90, idTA, role));

        // Define behavior of mocked repository
        when(nilaiKomponenTARepository.loadNilai(role, idTA, namaDosen)).thenReturn(mockData);

        // Call the method to test
        List<NilaiKomponenTA> result = nilaiKomponenTAController.loadNilai(role, idTA, namaDosen);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(80, result.get(0).getNilai());
        verify(nilaiKomponenTARepository, times(1)).loadNilai(role, idTA, namaDosen);
    }

    @Test
    void testSaveNilai() {
        // Mock data
        List<Integer> listNilai = Arrays.asList(85, 90);
        List<Integer> listIdNilaiKomponenTA = Arrays.asList(1, 2);

        // Call the method to test
        nilaiKomponenTAController.saveNilai(listNilai, listIdNilaiKomponenTA);

        // Verify that the repository method was called
        verify(nilaiKomponenTARepository, times(1)).saveNilai(listNilai, listIdNilaiKomponenTA);
    }
}