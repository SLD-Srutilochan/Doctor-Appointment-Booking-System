package com.app.controller;

import com.app.model.Appointment;
import com.app.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class DoctorController {

    private List<Doctor> doctors = new ArrayList<>();

    public DoctorController() {
        doctors.add(new Doctor(1, "Dr. Meera Nair", "Cardiology", "10:00 AM", "10:30 AM"));
        doctors.add(new Doctor(2, "Dr. Rahul Shetty", "Cardiology", "11:00 AM", "11:30 AM"));
        doctors.add(new Doctor(3, "Dr. Ajay Verma", "Neurology", "12:00 PM", "12:30 PM"));
        doctors.add(new Doctor(4, "Dr. Sneha Roy", "Neurology", "1:00 PM", "1:30 PM"));
        doctors.add(new Doctor(5, "Dr. Alok Das", "Orthopedics", "2:00 PM", "2:30 PM"));
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @PostMapping("/appointments")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        String refId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        appointment.setReferenceId(refId);
        System.out.println("Appointment Confirmed: " + refId);
        return appointment;
    }
}
