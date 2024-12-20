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
import java.util.ArrayList;
import java.util.List;

public class AppointmentSchedulingSystem {
    private static AppointmentSchedulingSystem instance;

   
    private List<Appointment> appointments;

    private AppointmentSchedulingSystem() {
        appointments = new ArrayList<>();
    }

    public static synchronized AppointmentSchedulingSystem getInstance() {
        if (instance == null) {
            instance = new AppointmentSchedulingSystem();
        }
        return instance;
    }

    public boolean scheduleAppointment(Appointment appointment) {
        // تحقق من توافر الموعد
        for (Appointment a : appointments) {
            if (a.getTime().equals(appointment.getTime()) && a.getDoctor().equals(appointment.getDoctor())) {
                return false; // الموعد غير متاح
            }
        }
        appointments.add(appointment);
        return true; // الموعد تم حجزه بنجاح
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
