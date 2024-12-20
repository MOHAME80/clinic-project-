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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class HospitalManagementApp extends javax.swing.JFrame {
        private JTextArea patientListArea;
        private JTextArea appointmentListArea;

    /**
     * Creates new form HospitalManagementApp
     */
    public HospitalManagementApp() {
      
        setTitle("Hospital Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton addPatientButton = new JButton("Add Patient");
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        JButton viewDataButton = new JButton("View Data");

        buttonPanel.add(addPatientButton);
        buttonPanel.add(scheduleAppointmentButton);
        buttonPanel.add(viewDataButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Create text areas for displaying data
        patientListArea = new JTextArea();
        appointmentListArea = new JTextArea();
        patientListArea.setEditable(false);
        appointmentListArea.setEditable(false);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(patientListArea), new JScrollPane(appointmentListArea));
        mainPanel.add(splitPane, BorderLayout.CENTER);

        add(mainPanel);

        // Add action listeners
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        scheduleAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleAppointment();
            }
        });

        viewDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewData();
            }
        });
    }

    private void addPatient() {
        String name = JOptionPane.showInputDialog(this, "Enter patient name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter patient age:"));
        String medicalHistory = JOptionPane.showInputDialog(this, "Enter medical history:");

        Patient patient = new Patient(name, age, medicalHistory);
        PatientDatabaseManager.getInstance().addPatient(patient);
        JOptionPane.showMessageDialog(this, "Patient added successfully!");
    }

    private void scheduleAppointment() {
        String doctor = JOptionPane.showInputDialog(this, "Enter doctor name:");
        String patientName = JOptionPane.showInputDialog(this, "Enter patient name:");
        LocalDateTime time = LocalDateTime.now(); // For simplicity, using current time

        Patient patient = null;
        for (Patient p : PatientDatabaseManager.getInstance().getPatients()) {
            if (p.getName().equals(patientName)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Patient not found!");
            return;
        }

        Appointment appointment = new Appointment(time, doctor, patient);
        boolean success = AppointmentSchedulingSystem.getInstance().scheduleAppointment(appointment);
        if (success) {
            JOptionPane.showMessageDialog(this, "Appointment scheduled successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to schedule appointment. Slot already taken.");
        }
    }

    private void viewData() {
        StringBuilder patientData = new StringBuilder("Patients:\n");
        for (Patient patient : PatientDatabaseManager.getInstance().getPatients()) {
            patientData.append(patient.getName()).append(", Age: ").append(patient.getAge()).append(", History: ").append(patient.getMedicalHistory()).append("\n");
        }
        patientListArea.setText(patientData.toString());

        StringBuilder appointmentData = new StringBuilder("Appointments:\n");
        for (Appointment appointment : AppointmentSchedulingSystem.getInstance().getAppointments()) {
            appointmentData.append("Doctor: ").append(appointment.getDoctor()).append(", Patient: ").append(appointment.getPatient().getName()).append(", Time: ").append(appointment.getTime()).append("\n");
        }
        appointmentListArea.setText(appointmentData.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HospitalManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalManagementApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospitalManagementApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
