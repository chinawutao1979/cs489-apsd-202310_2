package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.controller;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.AddressResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.PatientResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListAllPatients() {
        // Mocking the behavior of patientService
        when(patientService.getAllPatients()).thenReturn(List.of(new PatientResponse(
                1,                       // patientId
                "P001",                  // patientNo
                "John",                  // firstName
                "Doe",                   // lastName
                LocalDate.of(1990, 1, 1),// dateOfBirth
                new AddressResponse(
                        1,                   // addressId
                        "123 Main St",       // street
                        "Anytown",           // city
                        "CA",                // state
                        "12345"              // zipCode
                )
        ), new PatientResponse(
                2,                       // patientId
                "P002",                  // patientNo
                "Jane",                  // firstName
                "Smith",                 // lastName
                LocalDate.of(1992, 2, 2),// dateOfBirth
                new AddressResponse(
                        2,                   // addressId
                        "456 Elm St",        // street
                        "Othertown",         // city
                        "TX",                // state
                        "67890"              // zipCode
                )
        )));

        // Calling the actual REST endpoint
        ResponseEntity<List<PatientResponse>> response = patientController.listPatients();

        // Verifying the response
        assertThat(response.getStatusCodeValue()).isEqualTo(200);  // OK status
        assertThat(response.getBody()).hasSize(2);  // Assuming you returned 2 mocked patients
        // ... further assertions on patient data if needed
    }
}