package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.util.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtValidationService {

    private UserService userService;
    private JWTManagementUtilityService jwtManagementUtilityService;

    @Autowired
    public JwtValidationService(UserService userService,
                                JWTManagementUtilityService jwtManagementUtilityService) {
        this.userService = userService;
        this.jwtManagementUtilityService = jwtManagementUtilityService;
    }

    public UserDetails validateAndLoadUser(String jwtToken) {
        String username = jwtManagementUtilityService.extractUsername(jwtToken);
        UserDetails userDetails = null;
        if(username != null) {
            userDetails = userService.loadUserByUsername(username);
            if(!jwtManagementUtilityService.validateToken(jwtToken, userDetails)) {
                return null;
            }
        }
        return userDetails;
    }
}

