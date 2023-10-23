package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.dto;

public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}

