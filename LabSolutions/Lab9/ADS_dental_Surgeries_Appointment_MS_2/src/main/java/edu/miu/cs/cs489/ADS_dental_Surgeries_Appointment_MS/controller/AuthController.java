package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.controller;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.dto.AuthenticationRequest;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.dto.AuthenticationResponse;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.User;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.UserService;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.util.JwtUtil;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.util.service.JWTManagementUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adsweb/api/v1/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JWTManagementUtilityService jwtManagementUtilityService;
    private UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JWTManagementUtilityService jwtManagementUtilityService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtManagementUtilityService = jwtManagementUtilityService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
//            userService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("username and password is wrong!", e);
        }

//        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwtManagementUtilityService.generateToken(authenticationRequest.getUsername())));
    }

//    POST http://localhost:8080/adsweb/api/v1/auth/register
//    {
//        "username": "testuser",
//            "password": "testpassword"
//    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

