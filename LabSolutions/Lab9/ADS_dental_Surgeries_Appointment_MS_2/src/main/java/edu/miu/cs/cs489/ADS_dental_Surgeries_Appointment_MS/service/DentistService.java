package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;


import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Dentist;

public interface DentistService {
    Dentist saveDentist(Dentist dentist);

    Dentist getDentistById(Long id);

    void deleteDentist(Long id);
}
