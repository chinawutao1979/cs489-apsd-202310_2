package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model.Patient;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.repository.PatientRepository;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindPatientByIdExists() {

        // When we look for this patient
        Patient foundPatient = patientService.findPatientById(1);

        // Then we should get a non-null result
        assertNotNull(foundPatient);
        assertEquals(1, foundPatient.getPatientId().intValue());
    }

    @Test
    public void testFindPatientByIdInvalid() {
        // Assuming there's no patient with ID 12345 in the database
        Patient foundPatient = patientService.findPatientById(12345);

        // Then the result should be null
        assertNull(foundPatient);
    }
}
