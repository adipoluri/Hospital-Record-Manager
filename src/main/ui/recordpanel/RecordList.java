package ui.recordpanel;

import model.Patient;
import ui.Manager;
import ui.recordpanel.DisplayPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

//Creates RecordList panel that displays all of the records in a list
public class RecordList extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<Patient> list;
    private DisplayPanel displayPanel;
    private Manager manager;

    //Instantiates RecordList Panel
    public RecordList(Manager manager, DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
        this.manager = manager;
        reload();
    }

    //"Refreshes" List so all changes are shown so there is no discrepancy between that is in the records and
    // what is shown.
    public void reload() {
        this.removeAll();
        this.revalidate();
        this.repaint();
        listModel = new DefaultListModel<>();       //Creates Li-st Model of Patient Names, Easier to display Strings
        for (String str : manager.getRecords().toListOfString()) {
            listModel.addElement(str);
        }
        initializeJList(); //Initialises the List of Patients
    }


    //Initialises List with ListModel and sets basic controls to navigate through the list
    private void initializeJList() {
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(400, 600));
        add(listScroller);

        //Listener detects selection of patient and displays the appropriate Data
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selected = list.getSelectedIndex();
                displayPanel.removeAll();
                displayPanel.revalidate();
                displayPanel.repaint();
                displayPanel.displayInfo(manager.getRecords().getRecords().get(selected));
            }
        });
    }

    //Returns JLIST object so that other classes can operate on it.
    public JList getJList() {
        return this.list;
    }


}
