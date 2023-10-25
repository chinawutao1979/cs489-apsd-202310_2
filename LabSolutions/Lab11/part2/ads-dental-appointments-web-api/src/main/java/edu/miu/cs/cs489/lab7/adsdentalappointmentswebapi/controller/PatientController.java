package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.controller;

import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto.PatientResponse;
import edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/adsweb/api/v1/patient"})
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<PatientResponse>> listPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

}
