package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.*;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AdsDentalSurgeriesAppointmentMsApplication implements CommandLineRunner {

	@Autowired
	private AddressService addressService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DentistService dentistService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private SurgeryService surgeryService;

	public static void main(String[] args) {
		SpringApplication.run(AdsDentalSurgeriesAppointmentMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Data Persistence using Spring Data JPA");

		// Create a new address
		Address address1 = new Address(null, "123 Main Street", "New York", "NY", "10001");
		Address savedAddress = addressService.saveAddress(address1);

		// Create a new patient
		Patient patient = new Patient("Alice", "Smith", "987-654-3210", "alice.smith@example.com", new Date());
		// Set the patient's address
		patient.setAddress(savedAddress);
		Patient savedPatient = patientService.savePatient(patient);

		// Create a new dentist
		Dentist dentist = new Dentist("John", "Doe", "123-456-7890", "john.doe@example.com", "Orthodontist");
		Dentist savedDentist = dentistService.saveDentist(dentist);

		// Create a new appointment
		Appointment appointment = new Appointment();
		// Set other properties of the appointment
		appointment.setDentist(savedDentist);
		appointment.setPatient(savedPatient);
		appointmentService.saveAppointment(appointment);

		// Create a new surgery
		Surgery surgery = new Surgery("Dental Clinic", "123 Elm Street", "555-123-4567");
		// Create a new appointment for the surgery
		Appointment surgeryAppointment = new Appointment();
		// Set other properties of the appointment
		surgeryAppointment.setDentist(savedDentist);
		surgeryAppointment.setPatient(savedPatient);
		surgeryAppointment.setSurgery(surgery);
		Surgery savedSurgery = surgeryService.saveSurgery(surgery);
		// Associate appointments with the surgery
		savedSurgery.getAppointments().add(surgeryAppointment);
		surgeryService.saveSurgery(savedSurgery);

		// Query a specific patient
		Patient retrievedPatient = patientService.getPatientById(1L);

		// Update patient information
		Long patientId = 1L; // Replace with the actual patient ID
		Patient patientToUpdate = patientService.getPatientById(patientId);
		patientToUpdate.setFirstName("UpdatedFirstName");
		patientToUpdate.setLastName("UpdatedLastName");
		patientService.savePatient(patientToUpdate); // Save the updated patient information

//		// Delete a patient
//		patientService.deletePatient(1L);
//
//		// Delete an appointment
//		appointmentService.deleteAppointment(1L);
	}


}
