package ui.recordpanel;

import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Display Panel that displays patient information
public class DisplayPanel extends PatientPanel {
    private Patient patient;

    public DisplayPanel() {
        super("View Information", 600, 600);
    }

    //Displays the info of the given patient on the DisplayPanel panel
    public void displayInfo(Patient patient) {
        this.patient = patient;
        JButton editBtn = new JButton("      Edit       ");
        JButton docBtn = new JButton("View Doctor info");
        JButton viewBtn = new JButton("View Image");

        intialiseLabels();
        initaliseFields(patient);
        setFieldQualities();

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        addLabels();
        addFields();

        addEditButton(editBtn);
        addDoctorBtn(docBtn);
        addViewBtn(viewBtn);
    }


    //Creates button that lets users view the Patient's image
    private void addViewBtn(JButton button) {
        button.setMinimumSize(new Dimension(120, 20));
        gc.gridx = 1;
        gc.gridy = 0;
        add(button, gc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon img = new ImageIcon(patient.getImage());

                JOptionPane jop = new JOptionPane();
                JDialog dialog = jop.createDialog(patient.getName());
                dialog.setSize(img.getIconWidth(), img.getIconHeight());

                JLabel imgLabel = new JLabel(img);
                add(imgLabel);

                dialog.setContentPane(imgLabel);
                dialog.setVisible(true);
            }
        });
    }


    //Creates the button that lets users view the Designated Doctor's information.
    private void addDoctorBtn(JButton button2) {
        button2.setMinimumSize(new Dimension(120, 20));
        gc.gridx = 1;
        gc.gridy = 11;
        add(button2, gc);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane jop = new JOptionPane();
                JDialog dialog = jop.createDialog("View Doctor");
                dialog.setSize(400, 450);

                DoctorPanel doctorPanel = new DoctorPanel(patient.getDoctor());
                add(doctorPanel);

                dialog.setContentPane(doctorPanel);
                dialog.setVisible(true);
            }
        });
    }


    //Creates the button that lets the user Edit the Patient.
    private void addEditButton(JButton button) {
        button.setMinimumSize(new Dimension(120, 20));
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 12;
        gc.weighty = 0.1;
        add(button, gc);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane jop = new JOptionPane();
                JDialog dialog = jop.createDialog("Edit Patient");
                dialog.setSize(400, 450);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                EditPanel edp = new EditPanel(patient);
                add(edp);

                dialog.setContentPane(edp);
                dialog.setVisible(true);
            }
        });

    }


}
