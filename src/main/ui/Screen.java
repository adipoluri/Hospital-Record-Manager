package ui;

import model.Record;
import ui.recordpanel.Records;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//Creates the main screen for the application
public class Screen extends JFrame {
    private Manager manager;
    private Records records;
    private MainMenu mainMenu;
    private Settings settings;
    private JTabbedPane pane;

    // Initialises the program with title and automatically reloads data from Backup file.
    public Screen(String title) {
        super(title);
        manager = new Manager();
        try {
            manager.reload();           //Reload method to get data
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Back-up not Found!");
            manager.records = new Record();
        }

        // set layout manager
        setLayout(new GridLayout());

        // Create Swing Component
        pane = new JTabbedPane();
        pane.setTabPlacement(SwingConstants.LEFT);

        records = new Records(manager);
        mainMenu = new MainMenu(pane, manager);
        settings = new Settings();

        pane.addTab("Main Menu", mainMenu);
        pane.addTab("Records", records);
        pane.addTab("Settings", settings);

        Container cont = getContentPane();
        cont.add(pane);
    }


    //Returns records pane
    public Records getRecords() {
        return this.records;
    }
}
