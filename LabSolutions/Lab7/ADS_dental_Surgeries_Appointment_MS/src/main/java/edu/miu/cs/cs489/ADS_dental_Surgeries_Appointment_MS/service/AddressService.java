package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);

    Address getAddressById(Long id);

    void deleteAddress(Long id);
    List<Address> getAllAddressesSortedByCity();
}
