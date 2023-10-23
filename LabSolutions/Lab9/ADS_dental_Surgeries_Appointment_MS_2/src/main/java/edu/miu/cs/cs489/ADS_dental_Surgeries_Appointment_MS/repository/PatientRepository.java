package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Custom query method to find all patients and sort them by last name in ascending order
    List<Patient> findAllByOrderByLastNameAsc();
    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}