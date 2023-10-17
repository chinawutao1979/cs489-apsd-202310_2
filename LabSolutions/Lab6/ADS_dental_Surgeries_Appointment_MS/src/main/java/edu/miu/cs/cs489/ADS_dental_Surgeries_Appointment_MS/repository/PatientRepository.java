package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}