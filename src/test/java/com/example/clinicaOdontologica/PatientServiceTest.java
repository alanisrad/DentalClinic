package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.entity.Address;
import com.example.clinicaOdontologica.entity.Patient;
import com.example.clinicaOdontologica.exception.DniException;
import com.example.clinicaOdontologica.service.PatientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceTest {

    @Autowired
    PatientService patientService;
    Patient patient;

    @BeforeEach
    void init() {
        patient = new Patient("Natalia", "Rondon", "95707811", Date.valueOf("2022-04-13"),
                new Address("San Martin", "981", "CABA", "CABA"));
    }

    @Test
    @Order(1)
    @DisplayName("Save a patient")
    void savePatient() throws DniException {
        Patient pat = patientService.save(patient);
        Assertions.assertNotNull(pat);
    }

    @Test
    @Order(2)
    @DisplayName("Find a patient by ID")
    void findPatientById() {
        Patient pat = patientService.findById(1).orElse(null);
        Assertions.assertNotNull(pat);
    }

    @Test
    @Order(3)
    @DisplayName("Delete a patient")
    void deletePatient() {
        Patient pat = patientService.findById(1).orElse(null);
        patientService.delete(pat.getId());
        Patient result = patientService.findById(1).orElse(null);
        Assertions.assertNull(result);
    }

    @Test
    @Order(4)
    @DisplayName("List all patients")
    void listAllPatients() throws DniException {
        Patient patient2 = new Patient("Angel", "Rondon", "95656650", Date.valueOf("2022-04-13"),
                new Address("San Martin", "981", "CABA", "CABA"));

        patientService.save(patient);
        patientService.save(patient2);
        List<Patient> patients = patientService.findAll();
        Assertions.assertTrue(patients.size() == 2);
        Assertions.assertFalse(patients.isEmpty());
    }
}
