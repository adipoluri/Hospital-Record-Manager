package ui.recordpanel;

import model.Patient;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//Contains the Implementaion for the Panels that Display Patient Info
public abstract class PatientPanel extends JPanel {
    protected GridBagConstraints gc;
    //creates Labels, and Fields
    protected JLabel nameLabel;
    protected JLabel ageLabel;
    protected JLabel sexLabel;
    protected JLabel extraLabel;
    protected JLabel phoneLabel;
    protected JLabel addressLabel;
    protected JLabel doctorLabel;
    protected JLabel occupationLabel;
    protected JLabel citizenshipLabel;
    protected JLabel carecardLabel;
    protected JLabel historyLabel;
    protected JTextField nameField;
    protected JTextField ageField;
    protected JTextField sexField;
    protected JTextField phoneField;
    protected JTextField occupationField;
    protected JTextField citizenshipField;
    protected JTextField carecardField;
    protected JTextArea historyField;
    protected JTextArea descField;
    protected JTextArea addressField;

    //Initialises the Panel
    public PatientPanel(String str, int num, int num2) {
        Dimension size = getPreferredSize();
        size.width = num;
        size.height = num2;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder(str));
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
    }

    //Initialises the Labels
    protected void intialiseLabels() {
        nameLabel = new JLabel("Name: ");
        ageLabel = new JLabel("Age: ");
        sexLabel = new JLabel("Sex: ");
        extraLabel = new JLabel("Extra: ");
        doctorLabel = new JLabel("Doctor: ");
        addressLabel = new JLabel("Address: ");
        phoneLabel = new JLabel("Phone Number: ");
        occupationLabel = new JLabel("Occupation: ");
        citizenshipLabel = new JLabel("Citizenship: ");
        carecardLabel = new JLabel("CareCard Number: ");
        historyLabel = new JLabel("Medical History: ");
    }

    //Initialises the Fields
    protected void initaliseFields(Patient patient) {
        nameField = new JTextField(patient.getName(), 10);
        ageField = new JTextField(Integer.toString(patient.getAge()), 10);
        sexField = new JTextField(patient.getSex(), 10);
        addressField = new JTextArea(patient.getAddress(), 2, 5);
        phoneField = new JTextField(patient.getPhoneNumber(), 10);
        occupationField = new JTextField(patient.getOccupation(), 10);
        citizenshipField = new JTextField(patient.getCitizenShip(), 10);
        carecardField = new JTextField(patient.getCareCard(), 10);
        historyField = new JTextArea(patient.getHistory(), 5, 5);
        descField = new JTextArea(patient.getExtra(), 5, 5);
    }

    //Adjusts the Fields for their specific use
    protected void setFieldQualities() {
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        descField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        historyField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        addressField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        descField.setLineWrap(true);
        descField.setWrapStyleWord(true);
        historyField.setLineWrap(true);
        historyField.setWrapStyleWord(true);
        addressField.setLineWrap(true);
        addressField.setWrapStyleWord(true);

        nameField.setEditable(false);
        ageField.setEditable(false);
        sexField.setEditable(false);
        descField.setEditable(false);
        addressField.setEditable(false);
        phoneField.setEditable(false);
        occupationField.setEditable(false);
        citizenshipField.setEditable(false);
        carecardField.setEditable(false);
        historyField.setEditable(false);
    }

    //Adds Labels onto the Panel
    protected void addLabels() {
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        add(nameLabel, gc);
        gc.gridy = 2;
        add(ageLabel, gc);
        gc.gridy = 3;
        add(sexLabel, gc);
        gc.gridy = 4;
        add(addressLabel, gc);
        gc.gridy = 5;
        add(phoneLabel, gc);
        gc.gridy = 6;
        add(occupationLabel, gc);
        gc.gridy = 7;
        add(citizenshipLabel, gc);
        gc.gridy = 8;
        add(carecardLabel, gc);
        gc.gridy = 9;
        add(historyLabel, gc);
        gc.gridy = 10;
        add(extraLabel, gc);
    }

    //Adds Fields Onto the Panel
    protected void addFields() {
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(nameField, gc);
        gc.gridy = 2;
        add(ageField, gc);
        gc.gridy = 3;
        add(sexField, gc);
        gc.gridy = 4;
        add(addressField, gc);
        gc.gridy = 5;
        add(phoneField, gc);
        gc.gridy = 6;
        add(occupationField, gc);
        gc.gridy = 7;
        add(citizenshipField, gc);
        gc.gridy = 8;
        add(carecardField, gc);
        gc.gridy = 9;
        add(historyField, gc);
        gc.gridy = 10;
        add(descField, gc);
    }
}
