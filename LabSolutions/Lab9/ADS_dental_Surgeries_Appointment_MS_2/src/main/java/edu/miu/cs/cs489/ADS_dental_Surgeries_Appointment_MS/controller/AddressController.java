package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.controller;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Address;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Address>> getAllAddressesSortedByCity() {
        List<Address> addresses = addressService.getAllAddressesSortedByCity();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}

