package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Creates MainMenu panel
public class MainMenu extends JPanel {
    private JButton save;
    public JButton openRecords;
    private JButton clear;
    private JButton reload;
    private GridBagConstraints gc;


    //Initialises MainMenu Pane by adding title and 4 main function buttons
    public MainMenu(JTabbedPane pane, Manager manager) {
        //Set Default Settings for Pane
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder(" "));
        setLayout(new GridBagLayout());

        //Instantiate Components
        JLabel label = new JLabel("Made by Aditya Poluri");
        save = new JButton("Save Records");
        openRecords = new JButton("Open Records");
        clear = new JButton("Clear Records");
        reload = new JButton("Upload Records");

        JLabel imgLabel = new JLabel(new ImageIcon("src/images/mainmenu.png"));
        gc = new GridBagConstraints();

        //Add Components to Pane
        addComponents(imgLabel, label);
        addOpenRecords(pane);
        addSave(manager);
        addClear(manager);
        addReload(manager);
    }


    //Adds all components to the pane (Background image and Label)
    private void addComponents(JLabel img, JLabel credit) {
        gc.gridwidth = 0;
        gc.weighty = 1;
        gc.weightx = 0.5;

        gc.gridy = 0;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.PAGE_END;
        add(img, gc);

        gc.weighty = 0;
        gc.gridx = 3;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        add(credit, gc);
    }


    //Adds the Open record button to the pane with the Listener aswell
    private void addOpenRecords(JTabbedPane pane) {
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(25, 5, 300, 5);
        gc.gridwidth = 1;
        gc.gridy = 1;
        gc.gridx = 0;
        add(openRecords, gc);

        openRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(1);
            }
        });
    }


    //Adds the save button to the pane with the Listener aswell
    private void addSave(Manager manager) {
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        add(save, gc);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.save();
                    SoundPlayer snd = new SoundPlayer("src/images/ding.wav");
                    JOptionPane.showMessageDialog(null, "Data Saved", "Saved!", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    //Adds the clear records button to the pane with the Listener aswell
    private void addClear(Manager manager) {
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 2;
        add(clear, gc);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creaes message pop-up that makes sure you want to clear records
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you would like to delete the record data?\n"
                                + " The Data can not be recovered after this is done!",
                        "Warning!",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    SoundPlayer snd = new SoundPlayer("src/images/trash.wav");
                    manager.deleteRecords();
                    try {
                        manager.save();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }


    //Adds the reload from save file button to the pane with the Listener aswell
    private void addReload(Manager manager) {
        gc.fill = 0;
        gc.gridx = 3;
        add(reload, gc);

        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();

                int returnValue = jfc.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    try {
                        manager.reload(selectedFile.toString());
                        manager.save();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
