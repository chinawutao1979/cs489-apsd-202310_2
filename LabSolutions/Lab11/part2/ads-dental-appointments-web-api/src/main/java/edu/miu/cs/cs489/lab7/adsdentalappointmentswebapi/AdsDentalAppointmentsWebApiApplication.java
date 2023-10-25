package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdsDentalAppointmentsWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsDentalAppointmentsWebApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello, Lab7. ADS Dental Appointments Web API server is starting...");
            System.out.println("ADS Dental Appointments Web API server started successfully.\n" +
                    "Listening on port 8080");
            System.out.println("To see list of Patients, send HTTP GET Request to the URI,\n" +
                    "http://localhost:8080/adsweb/api/v1/patient/list");
        };
    }

}
