package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Appointment;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    void deleteAppointment(Long id);

}
