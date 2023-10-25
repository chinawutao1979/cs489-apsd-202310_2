package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.PatientResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Patient;

import java.util.List;

public interface PatientService {
    Patient registerNewPatient(Patient newPatient);
    List<PatientResponse> getAllPatients();
    Patient findPatientById(Integer patientId);
}
