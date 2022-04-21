package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.entity.Address;
import com.example.clinicaOdontologica.entity.Appointment;
import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.entity.Patient;
import com.example.clinicaOdontologica.exception.DniException;
import com.example.clinicaOdontologica.service.AppointmentService;
import com.example.clinicaOdontologica.service.DentistService;
import com.example.clinicaOdontologica.service.PatientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppointmentServiceTest {

    @Autowired
    private DentistService dentistService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;

    Address address;
    Patient patient;
    Dentist dentist;
    Appointment appointment;

    @BeforeEach
    void init() {
        address = new Address("San Martin", "981", "CABA", "CABA");
        dentist = new Dentist("4567", "Juan", "Perez");
        patient = new Patient("Julio", "Rodriguez", "3098676", Date.valueOf("2022-04-13"), address);
        appointment = new Appointment(LocalDateTime.now(), patient, dentist);
    }

    @Test
    @Order(1)
    @DisplayName("Save an appointment")
    void saveAppointment() throws DniException {
        Dentist den = dentistService.save(dentist);
        Patient pat = patientService.save(patient);
        Appointment app = appointmentService.save(appointment);

        Assertions.assertNotNull(app);
    }

    @Test
    @Order(2)
    @DisplayName("Find an appointment by ID")
    void findAppointmentById() {
        Appointment app = appointmentService.findById(1).orElse(null);
        Assertions.assertNotNull(app);
    }

    @Test
    @Order(3)
    @DisplayName("Delete an appointment")
    void deleteAppointment() {
        Appointment app = appointmentService.findById(1).orElse(null);
        appointmentService.delete(app.getId());
        Appointment appDeleted = appointmentService.findById(1).orElse(null);
        Assertions.assertNull(appDeleted);
    }

}
