package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.AddressResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.PatientResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Patient;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.repository.PatientRepository;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;


//    public PatientServiceImpl() {
//        this.patientRepository = patientRepository;
//    }

    @Override
    public Patient registerNewPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll(Sort.by("lastName"))
                .stream()
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getPatientNo(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getDateOfBirth(),
                        new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                                p.getPrimaryAddress().getStreet(),
                                p.getPrimaryAddress().getCity(),
                                p.getPrimaryAddress().getState(),
                                p.getPrimaryAddress().getZipCode()
                        )
                ))
                .toList();
    }

    @Override
    public Patient findPatientById(Integer patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        return optionalPatient.orElse(null);
    }

}
