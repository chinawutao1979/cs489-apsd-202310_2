package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.controller;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Patient;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatientsSortedByLastName() {
        List<Patient> patients = patientService.getAllPatientsSortedByLastName();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {
        try {
            Patient patient = patientService.getPatientById(id);
            if (patient != null) {
                return new ResponseEntity<>(patient, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle other exceptions, e.g., database errors
            return new ResponseEntity<>("An error occurred while fetching the patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatientData) {
        try {
            Patient existingPatient = patientService.getPatientById(id);
            if (existingPatient != null) {
                // Update the patient data with the provided data
                updatedPatientData.setId(id);
                Patient updatedPatient = patientService.savePatient(updatedPatientData);
                return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Handle other exceptions, e.g., database errors
            return new ResponseEntity<>("An error occurred while updating the patient", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        Patient existingPatient = patientService.getPatientById(id);
        if (existingPatient != null) {
            patientService.deletePatient(id);
            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatients(@PathVariable String searchString) {
        List<Patient> matchingPatients = patientService.searchPatients(searchString);
        return new ResponseEntity<>(matchingPatients, HttpStatus.OK);
    }
}


