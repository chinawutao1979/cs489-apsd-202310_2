package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Patient;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class PatientServiceImplTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindPatientByIdExists() {
        // Create and save a patient
        Patient savedPatient = entityManager.persistAndFlush(new Patient(/* your patient details here */));

        // Find the patient by ID
        Patient foundPatient = patientService.findPatientById(savedPatient.getPatientId());

        // Assert the patient was found
        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getPatientId()).isEqualTo(savedPatient.getPatientId());
        // ... further assertions on other fields if needed
    }

    @Test
    public void testFindPatientByIdNotExists() {
        // Try finding a patient by a non-existing ID
        Patient foundPatient = patientService.findPatientById(-1);

        // Assert the patient was not found
        assertThat(foundPatient).isNull();
    }
}