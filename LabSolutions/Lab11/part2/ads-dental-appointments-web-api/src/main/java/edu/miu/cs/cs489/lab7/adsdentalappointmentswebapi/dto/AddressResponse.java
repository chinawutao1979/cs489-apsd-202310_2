package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.dto;

public record AddressResponse(
        Integer addressId,
        String street,
                String city,
                String state,
                String zipCode
) {
}
