package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Surgery;

public interface SurgeryService {
    Surgery saveSurgery(Surgery surgery);

    Surgery getSurgeryById(Long id);

    void deleteSurgery(Long id);

}
