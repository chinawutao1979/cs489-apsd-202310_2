package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
