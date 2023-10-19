package edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.impl;

import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.model.Appointment;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.repository.AppointmentRepository;
import edu.miu.cs.cs489.ADS_dental_Surgeries_Appointment_MS.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    // 其他业务方法的实现
}
