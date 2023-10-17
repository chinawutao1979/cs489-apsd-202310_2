package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;


import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Address;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.AddressRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(Math.toIntExact(id));
    }
}
