package ui.recordpanel;

import exceptions.NotCorrectFormatException;
import exceptions.NotRealPhoneNumberException;
import model.Patient;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


//Creates EditPanel so User can edit a Patients Information
public class EditPanel extends PatientPanel {
    private JButton addBtn;
    private JButton addPic;

    public EditPanel(Patient patient) {
        super("Edit Information", 600, 1200);


        intialiseLabels();
        initaliseFields(patient);
        setFieldQualities();


        addBtn = new JButton("Save");
        addPic = new JButton("Upload Image");

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.insets = new Insets(0, 50, 0, 0);
        addLabels();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 0, 10);
        addFields();
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill = 0;

        addButton(patient);
        addChangePic(addPic, patient);
    }

    //OverRides SetFieldQualities() method to add distinct functionality to the edit Panel
    @Override
    protected void setFieldQualities() {
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        descField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        historyField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        descField.setLineWrap(true);
        descField.setWrapStyleWord(true);
        historyField.setLineWrap(true);
        historyField.setWrapStyleWord(true);

        nameField.setEditable(true);
        ageField.setEditable(true);
        sexField.setEditable(true);
        descField.setEditable(true);
        addressField.setEditable(true);
        phoneField.setEditable(true);
        occupationField.setEditable(true);
        citizenshipField.setEditable(true);
        carecardField.setEditable(true);
        historyField.setEditable(true);
    }


    //Adds Button that lets user change the Patient's photo
    private void addChangePic(JButton button, Patient patient) {
        gc.gridx = 1;
        gc.gridy = 0;
        add(button, gc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int returnValue = jfc.showOpenDialog(null);
                //Opens File Chooser to let user select image, then moves image to Data folder.
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    try {
                        Files.move(Paths.get(selectedFile.getAbsolutePath()),
                                Paths.get("data/patientimages/" + patient.getName() + ".png"));
                        patient.addImage("data/patientimages/" + patient.getName() + ".png");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error Loading File", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }


    //Adds Save Button onto the panel
    private void addButton(Patient patient) {
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 11;
        add(addBtn, gc);
        addBtnLister(patient);
    }

    //Helper Function for Save Button
    private void addBtnLister(Patient patient) {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patient.addName(nameField.getText());
                patient.addAge(Integer.parseInt(ageField.getText()));
                patient.addSex(sexField.getText());
                patient.addDescription(descField.getText());
                patient.setAddress(addressField.getText());
                patient.setOccupation(occupationField.getText());
                patient.setCitizenship(citizenshipField.getText());
                patient.setHistory(historyField.getText());
                try {
                    patient.addPhoneNumber(phoneField.getText());
                    patient.setCarecard(carecardField.getText());
                } catch (NotRealPhoneNumberException ex) {
                    JOptionPane.showMessageDialog(null, "Not Real PhoneNumber!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NotCorrectFormatException ex) {
                    JOptionPane.showMessageDialog(null, "CareCard not correct!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
