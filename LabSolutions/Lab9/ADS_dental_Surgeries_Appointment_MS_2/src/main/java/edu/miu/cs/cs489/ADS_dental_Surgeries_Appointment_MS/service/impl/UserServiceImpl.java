package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.User;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.UserRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Lazy
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user is not exist!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

//    @Override
//    public void authenticate(String username, String password) throws Exception {
//        User user = userRepository.findByUsername(username);
//        if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
//            throw new Exception("username and password is wrong!");
//        }
//    }

    @Override
    public void register(User user) {
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }
}
