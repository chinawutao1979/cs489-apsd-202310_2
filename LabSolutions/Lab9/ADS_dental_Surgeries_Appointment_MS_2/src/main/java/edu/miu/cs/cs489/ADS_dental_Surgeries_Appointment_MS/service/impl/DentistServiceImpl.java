package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;



import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Dentist;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.DentistRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist getDentistById(Long id) {
        return dentistRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(Math.toIntExact(id));
    }

}
