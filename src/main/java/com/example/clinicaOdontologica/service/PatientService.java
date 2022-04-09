package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Patient;
import com.example.clinicaOdontologica.repository.impl.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IEntityService<Patient>{

    private IPatientRepository patientRepository;

    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public IPatientRepository getPatientRepository() {
        return patientRepository;
    }

    public void setPatientRepository(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        patient.setEntryDate(new Date(System.currentTimeMillis()));
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient update(Patient patient) {
        Patient pat = patientRepository.getById(patient.getId());
        pat.setName(patient.getName());
        pat.setLastName(patient.getLastName());
        pat.setDni(patient.getDni());
        pat.setEntryDate(patient.getEntryDate());
        pat.setAddress(patient.getAddress());
        patientRepository.save(pat);
        return pat;
    }

    @Override
    public void delete(Integer id) {
        Patient pat = patientRepository.getById(id);
        patientRepository.delete(pat);
    }
}
