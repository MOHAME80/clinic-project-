/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test2;

/**
 *
 * @author user
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



// Abstract class for Medical Records
abstract class MedicalRecord {
    protected String details;

    public abstract String getDetails();

    // Adds or updates details for a medical record
    public void AddDetails(String details) {
        this.details = details;
    }

    // Validate if the record is complete
    public boolean ValidateRecord() {
        return details != null && !details.isEmpty();
    }

    // Simulate saving to a database
    public void saveToDatabase() {
        if (ValidateRecord()) {
            System.out.println("Saving record to database: " + getDetails());
        } else {
            System.out.println("Record validation failed, cannot save.");
        }
    }

    // Print the medical record in a readable format
    public void printRecord() {
        System.out.println("Medical Record: " + getDetails());
    }
}


class PatientHistory extends MedicalRecord {

    private String medicalHistory;

    @Override
    public String getDetails() {
        return "Patient History: " + (medicalHistory != null ? medicalHistory : "No history available.");
    }

    // Add a new entry to the patient's medical history
    public void addMedicalHistory(String history) {
        this.medicalHistory = history;
    }

    // Get the patient's medical history
    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Update the existing medical history
    public void updateMedicalHistory(String newHistory) {
        this.medicalHistory = newHistory;
    }
}



class Prescription extends MedicalRecord {

    private List<String> medications = new ArrayList<>();

    @Override
    public String getDetails() {
        return "Prescription: " + (medications.isEmpty() ? "No medications prescribed." : String.join(", ", medications));
    }

    // Add a new medication to the prescription
    public void addMedication(String medication) {
        medications.add(medication);
    }

    // Get the list of medications in the prescription
    public List<String> getMedicationList() {
        return medications;
    }

    // Update an existing medication
    public void updateMedication(String oldMedication, String newMedication) {
        int index = medications.indexOf(oldMedication);
        if (index != -1) {
            medications.set(index, newMedication);
        }
    }

    // Remove a medication from the prescription
    public void removeMedication(String medication) {
        medications.remove(medication);
    }
}


class LabResult extends MedicalRecord {

    private Map<String, String> labTests = new HashMap<>();

    @Override
    public String getDetails() {
        if (labTests.isEmpty()) {
            return "Lab Result: No test results available.";
        } else {
            StringBuilder result = new StringBuilder("Lab Result:\n");
            for (Map.Entry<String, String> entry : labTests.entrySet()) {
                result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            return result.toString();
        }
    }

    // Add a new lab test result
    public void addLabTestResult(String test, String result) {
        labTests.put(test, result);
    }

    // Get the lab test results
    public Map<String, String> getLabTestResults() {
        return labTests;
    }

    // Update an existing lab test result
    public void updateLabTestResult(String test, String newResult) {
        if (labTests.containsKey(test)) {
            labTests.put(test, newResult);
        }
    }

    // Remove a lab test result
    public void removeLabTestResult(String test) {
        labTests.remove(test);
    }
}


// MedicalRecord Factory
class MedicalRecordFactory {
    public static MedicalRecord createMedicalRecord(String type) {
        if (type.equalsIgnoreCase("Patient History")) {
            return new PatientHistory();
        } else if (type.equalsIgnoreCase("Prescription")) {
            return new Prescription();
        } else if (type.equalsIgnoreCase("Lab Result")) {
            return new LabResult();
        }
        return null;
    }
}

// Abstract class for Doctor Specializations
abstract class Doctor {
    public abstract String getSpecialization();
}

class Cardiologist extends Doctor {
    @Override
    public String getSpecialization() {
        return "Cardiologist: Heart specialist.";
    }
}

class Neurologist extends Doctor {
    @Override
    public String getSpecialization() {
        return "Neurologist: Brain and nervous system specialist.";
    }
}

class GeneralPractitioner extends Doctor {
    @Override
    public String getSpecialization() {
        return "General Practitioner: General medical care provider.";
    }
}

// Doctor Factory
class DoctorFactory {
    public static Doctor createDoctor(String specialization) {
        if (specialization.equalsIgnoreCase("Cardiologist")) {
            return new Cardiologist();
        } else if (specialization.equalsIgnoreCase("Neurologist")) {
            return new Neurologist();
        } else if (specialization.equalsIgnoreCase("General Practitioner")) {
            return new GeneralPractitioner();
        }
        return null;
    }
}



public class MedicalRecordDoctorGUI extends JFrame {
    private JComboBox<String> medicalRecordComboBox;
    private JTextArea resultArea;
    private JButton addButton;

    public MedicalRecordDoctorGUI() {
        setTitle("Medical Records");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        medicalRecordComboBox = new JComboBox<>(new String[] {
            "Patient History", "Prescription", "Lab Result"
        });
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        addButton = new JButton("Add Details");

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Select Medical Record Type:"));
        add(medicalRecordComboBox);
        add(addButton);
        add(new JScrollPane(resultArea));

        // Action Listener for addButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResult();
            }
        });
    }

    private void updateResult() {
        String selectedRecord = (String) medicalRecordComboBox.getSelectedItem();
        MedicalRecord medicalRecord = MedicalRecordFactory.createMedicalRecord(selectedRecord);
        
        if (medicalRecord != null) {
            medicalRecord.AddDetails("Some example details for " + selectedRecord);
            resultArea.setText(medicalRecord.getDetails());
        } else {
            resultArea.setText("Invalid selection for Medical Record.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MedicalRecordDoctorGUI gui = new MedicalRecordDoctorGUI();
                gui.setVisible(true);
            }
        });
    }
}




