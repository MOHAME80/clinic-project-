/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitala;

/**
 *
 * @author A1
 */
import java.time.LocalDateTime;

public class Appointment {
    
     private LocalDateTime time;
    private String doctor;
    private Patient patient;

    // Constructor, getters, and setters
    public Appointment(LocalDateTime time, String doctor, Patient patient) {
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }
}
