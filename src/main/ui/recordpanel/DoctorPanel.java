package ui.recordpanel;

import exceptions.NotRealPhoneNumberException;
import model.Professional;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Creates Doctor Panel to display Doctor's information
public class DoctorPanel extends JPanel {
    private GridBagConstraints gc;
    private Professional doctor;
    //Createa Labels, Fields, and buttons.
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel sexLabel;
    private JLabel extraLabel;
    private JLabel phoneLabel;
    private JLabel specializationLabel;
    private JLabel titleLabel;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField sexField;
    private JTextField phoneField;
    private JTextField specializationField;
    private JTextField titleField;
    private JTextArea extraField;
    private JButton addBtn;
    private JButton addPic;
    private JButton viewBtn;

    //Instantiates the panel, creates components and adds components
    public DoctorPanel(Professional doctor) {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("View information"));
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();

        this.doctor = doctor;

        intialiseLabels();
        initaliseFields(doctor);
        setFieldQualities();

        addBtn = new JButton("Save");
        addPic = new JButton("Upload Image");
        viewBtn = new JButton("View Image");

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        addLabels();
        addFields();
        addBtn();
        saveBtn();
        viewBtn();
    }

    //Initialises the Labels for the panel
    private void intialiseLabels() {
        nameLabel = new JLabel("Name: ");
        ageLabel = new JLabel("Age: ");
        sexLabel = new JLabel("Sex: ");
        extraLabel = new JLabel("Extra: ");
        phoneLabel = new JLabel("Phone Number: ");
        specializationLabel = new JLabel("Specialization: ");
        titleLabel = new JLabel("Title: ");
    }

    //Intialises the Fields for the Panel
    private void initaliseFields(Professional doctor) {
        nameField = new JTextField(doctor.getName(), 10);
        ageField = new JTextField(Integer.toString(doctor.getAge()), 10);
        sexField = new JTextField(doctor.getSex(), 10);
        phoneField = new JTextField(doctor.getPhoneNumber(), 10);
        extraField = new JTextArea(doctor.getExtra(), 5, 5);
        specializationField = new JTextField(doctor.getSpecialization(), 10);
        titleField = new JTextField(doctor.getTitle(), 10);
    }


    //Sets the Field Properties for the panel
    private void setFieldQualities() {
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        extraField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        extraField.setLineWrap(true);
        extraField.setWrapStyleWord(true);

        nameField.setEditable(true);
        ageField.setEditable(true);
        sexField.setEditable(true);
        phoneField.setEditable(true);
        specializationField.setEditable(true);
        titleField.setEditable(true);
    }


    //Adds the Labels to the Panel
    private void addLabels() {
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 1;
        add(nameLabel, gc);
        gc.gridy = 2;
        add(ageLabel, gc);
        gc.gridy = 3;
        add(sexLabel, gc);
        gc.gridy = 4;
        add(phoneLabel, gc);
        gc.gridy = 5;
        add(specializationLabel, gc);
        gc.gridy = 6;
        add(titleLabel, gc);
        gc.gridy = 7;
        add(extraLabel, gc);
    }


    //Adds Fields to the Panel
    private void addFields() {
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
        add(nameField, gc);
        gc.gridy = 2;
        add(ageField, gc);
        gc.gridy = 3;
        add(sexField, gc);
        gc.gridy = 4;
        add(phoneField, gc);
        gc.gridy = 5;
        add(specializationField, gc);
        gc.gridy = 6;
        add(titleField, gc);
        gc.gridy = 7;
        add(extraField, gc);
    }


    //creates Button that saves Information to the Doctor Object
    private void saveBtn() {
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 8;
        add(addBtn, gc);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctor.addName(nameField.getText());
                doctor.addAge(Integer.parseInt(ageField.getText()));
                doctor.addSex(sexField.getText());
                doctor.addDescription(extraField.getText());
                doctor.setSpecialization(specializationField.getText());
                doctor.setTitle(titleField.getText());
                try {
                    doctor.addPhoneNumber(phoneField.getText());
                } catch (NotRealPhoneNumberException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Phone Number not in correct format or is not real!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    //Creates the button that lets the user add a picture of the doctor.
    private void addBtn() {
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(addPic, gc);

        addPic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int returnValue = jfc.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    try {
                        Files.move(Paths.get(selectedFile.getAbsolutePath()),
                                Paths.get("data/doctorimages/" + doctor.getName() + ".png"));
                        doctor.addImage("data/doctorimages/" + doctor.getName() + ".png");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error Loading File", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    //Creates the button that lets the user view the doctor's image
    private void viewBtn() {
        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 0;
        add(viewBtn, gc);

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon img = new ImageIcon(doctor.getImage());

                JOptionPane jop = new JOptionPane();
                JDialog dialog = jop.createDialog(doctor.getName());
                dialog.setSize(img.getIconWidth(), img.getIconHeight());

                JLabel imgLabel = new JLabel(img);
                add(imgLabel);

                dialog.setContentPane(imgLabel);
                dialog.setVisible(true);
            }
        });
    }
}
