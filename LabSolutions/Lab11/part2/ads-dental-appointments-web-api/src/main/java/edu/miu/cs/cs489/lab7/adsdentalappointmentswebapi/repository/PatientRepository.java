package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.repository;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
