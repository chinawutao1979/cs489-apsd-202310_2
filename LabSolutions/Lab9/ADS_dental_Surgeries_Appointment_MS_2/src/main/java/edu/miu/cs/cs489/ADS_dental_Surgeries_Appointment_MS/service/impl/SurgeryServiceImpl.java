package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Surgery;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.SurgeryRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @Override
    public Surgery saveSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery getSurgeryById(Long id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSurgery(Long id) {
        surgeryRepository.deleteById(id);
    }
}
