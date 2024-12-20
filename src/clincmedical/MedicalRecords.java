/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clincmedical;

/**
 *
 * @author user
 */
public class MedicalRecords
{
    
    // MedicalRecord.java


// PatientHistory.java
static public class PatientHistory extends MedicalRecord {

    public void displayRecord() 
    {
        System.out.println("Displaying Patient History Record");
    }
}

// Prescription.java
static public class Prescription extends MedicalRecord 
{
    public void displayRecord() {
        System.out.println("Displaying Prescription Record");
    }
}

// LabResult.java
static public class LabResult extends MedicalRecord {

    public void displayRecord() {
        System.out.println("Displaying Lab Result Record");
    }
}
 
}
