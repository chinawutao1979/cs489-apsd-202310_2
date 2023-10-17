package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.PatientRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
