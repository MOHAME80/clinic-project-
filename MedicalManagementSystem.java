import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicalManagementSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}

class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Medical Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JLabel headerLabel = new JLabel("Medical Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel menuPanel = new JPanel(new GridLayout(1, 4));
        JButton btnPatients = new JButton("Patient Records");
        JButton btnDoctors = new JButton("Doctor Schedules");
        JButton btnAppointments = new JButton("Appointments");
        JButton btnMedicalHistory = new JButton("Medical Histories");

        // Add buttons to the menu panel
        menuPanel.add(btnPatients);
        menuPanel.add(btnDoctors);
        menuPanel.add(btnAppointments);
        menuPanel.add(btnMedicalHistory);

        // Create a main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());

        // Add different panels for each section
        contentPanel.add(new PatientRecordsPanel(), "Patient Records");
        contentPanel.add(new DoctorSchedulesPanel(), "Doctor Schedules");
        contentPanel.add(new AppointmentsPanel(), "Appointments");
        contentPanel.add(new MedicalHistoriesPanel(), "Medical Histories");

        // Add ActionListeners to buttons
        btnPatients.addActionListener(e -> switchPanel(contentPanel, "Patient Records"));
        btnDoctors.addActionListener(e -> switchPanel(contentPanel, "Doctor Schedules"));
        btnAppointments.addActionListener(e -> switchPanel(contentPanel, "Appointments"));
        btnMedicalHistory.addActionListener(e -> switchPanel(contentPanel, "Medical Histories"));

        // Add components to the frame
        add(headerLabel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.SOUTH);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void switchPanel(JPanel contentPanel, String panelName) {
        CardLayout cl = (CardLayout) (contentPanel.getLayout());
        cl.show(contentPanel, panelName);
    }
}

class PatientRecordsPanel extends JPanel {
    public PatientRecordsPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Patient Records", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.add(new JLabel("Patient Name:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Gender:"));
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        formPanel.add(genderBox);

        formPanel.add(new JLabel("Contact Number:"));
        JTextField contactField = new JTextField();
        formPanel.add(contactField);

        formPanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        formPanel.add(addressField);

        formPanel.add(new JLabel("Doctor Specialization:"));
        JTextField specializationField = new JTextField();
        formPanel.add(specializationField);

        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Patient");
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Patient Data Saved:\nName: " + nameField.getText() + "\nAge: " + ageField.getText() + "\nGender: " + genderBox.getSelectedItem() + "\nContact: " + contactField.getText() + "\nAddress: " + addressField.getText() + "\nDoctor Specialization: " + specializationField.getText()));

        add(saveButton, BorderLayout.SOUTH);
    }
}

class DoctorSchedulesPanel extends JPanel {
    public DoctorSchedulesPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Doctor Schedules", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(new JLabel("Doctor Name:"));
        JTextField doctorNameField = new JTextField();
        formPanel.add(doctorNameField);

        formPanel.add(new JLabel("Specialization:"));
        JTextField specializationField = new JTextField();
        formPanel.add(specializationField);

        formPanel.add(new JLabel("Available Days:"));
        JTextField daysField = new JTextField();
        formPanel.add(daysField);

        formPanel.add(new JLabel("Contact Number:"));
        JTextField contactField = new JTextField();
        formPanel.add(contactField);

        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Schedule");
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Schedule Data Saved:\nDoctor: " + doctorNameField.getText() + "\nSpecialization: " + specializationField.getText() + "\nDays: " + daysField.getText() + "\nContact: " + contactField.getText()));

        add(saveButton, BorderLayout.SOUTH);
    }
}

class AppointmentsPanel extends JPanel {
    public AppointmentsPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Appointments", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.add(new JLabel("Patient Name:"));
        JTextField patientNameField = new JTextField();
        formPanel.add(patientNameField);

        formPanel.add(new JLabel("Doctor Name:"));
        JTextField doctorNameField = new JTextField();
        formPanel.add(doctorNameField);

        formPanel.add(new JLabel("Date:"));
        JTextField dateField = new JTextField();
        formPanel.add(dateField);

        formPanel.add(new JLabel("Time:"));
        JTextField timeField = new JTextField();
        formPanel.add(timeField);

        formPanel.add(new JLabel("Reason:"));
        JTextField reasonField = new JTextField();
        formPanel.add(reasonField);

        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Appointment");
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Appointment Data Saved:\nPatient: " + patientNameField.getText() + "\nDoctor: " + doctorNameField.getText() + "\nDate: " + dateField.getText() + "\nTime: " + timeField.getText() + "\nReason: " + reasonField.getText()));

        add(saveButton, BorderLayout.SOUTH);
    }
}

class MedicalHistoriesPanel extends JPanel {
    public MedicalHistoriesPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Medical Histories", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        add(label, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(new JLabel("Patient Name:"));
        JTextField patientNameField = new JTextField();
        formPanel.add(patientNameField);

        formPanel.add(new JLabel("Disease:"));
        JTextField diseaseField = new JTextField();
        formPanel.add(diseaseField);

        formPanel.add(new JLabel("Treatment:"));
        JTextField treatmentField = new JTextField();
        formPanel.add(treatmentField);

        formPanel.add(new JLabel("Doctor Name:"));
        JTextField doctorNameField = new JTextField();
        formPanel.add(doctorNameField);

        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save History");
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Medical History Saved:\nPatient: " + patientNameField.getText() + "\nDisease: " + diseaseField.getText() + "\nTreatment: " + treatmentField.getText() + "\nDoctor: " + doctorNameField.getText()));

        add(saveButton, BorderLayout.SOUTH);
    }
}
