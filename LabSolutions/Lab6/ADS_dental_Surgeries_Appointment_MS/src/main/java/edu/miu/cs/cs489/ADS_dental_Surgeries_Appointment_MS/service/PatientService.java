package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;

public interface PatientService {
    Patient savePatient(Patient patient);

    Patient getPatientById(Long id);

    void deletePatient(Long id);
}
