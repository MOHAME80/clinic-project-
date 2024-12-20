/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitala;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A1
 */
public class PatientDatabaseManager {
    private static PatientDatabaseManager instance;

   
    private List<Patient> patients;

    private PatientDatabaseManager() {
        patients = new ArrayList<>();
    }

    public static PatientDatabaseManager getInstance() {
        if (instance == null) {
            instance = new PatientDatabaseManager();
        }
        return instance;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
    
}
