package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);

    Patient getPatientById(Long id);

    void deletePatient(Long id);

    public List<Patient> getAllPatientsSortedByLastName();
    List<Patient> searchPatients(String searchString);
}
