package ui.recordpanel;

import ui.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Creates the main record viewing panel that consists of 3 other panels
public class Records extends JPanel {
    private RecordList rl;
    private DisplayPanel dp;
    private Manager manager;

    //Instantiates Panel and creates components
    public Records(Manager manager) {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Records"));
        this.manager = manager;

        //creates the two main panels in the record panel
        dp = new DisplayPanel();
        rl = new RecordList(manager, dp);

        Dimension minSize = new Dimension(600, 600);
        dp.setMinimumSize(minSize);
        rl.setMinimumSize(minSize);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rl, dp);
        splitPane.setOneTouchExpandable(false);
        splitPane.setDividerLocation(400);

        JButton reload = new JButton("  Refresh  ");
        JButton addPat = new JButton("Add a Patient");
        JButton delBtn = new JButton("Delete Patient");
        reload.setMinimumSize(new Dimension(120, 20));
        addPat.setMinimumSize(new Dimension(120, 20));
        delBtn.setMinimumSize(new Dimension(120, 20));

        createComponents(splitPane, addPat, delBtn, reload);
        addPatientBtn(addPat);
        delBtn(delBtn);
        addReload(reload);
    }

    // Creates the components
    private void createComponents(JSplitPane pane, JButton bt1, JButton bt2, JButton reload) {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 0;
        gc.weightx = 0.1;

        gc.gridwidth = 5;
        gc.gridx = 3;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        add(pane, gc);

        gc.insets = new Insets(10, 100, 0, 0);
        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.WEST;
        add(reload, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        add(bt1, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        add(bt2, gc);

    }

    //Adds Reload Button onto the Records Panel
    private void addReload(JButton reload) {
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.save();
                    rl.reload();
                } catch (IOException x) {
                    JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    // Adds Button 1 (Add Patient) to panel
    private void addPatientBtn(JButton bt1) {
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = JOptionPane.showInputDialog(null,
                        "What is the Patients Name?", "Add Patient", JOptionPane.QUESTION_MESSAGE);
                manager.records.addPatient(response);
                rl.reload();
                try {
                    manager.save();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    // Adds Button 2 (Delete Patient) to panel
    private void delBtn(JButton bt1) {
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = rl.getJList().getSelectedIndex();
                manager.getRecords().removePatient(num);
                rl.reload();
                try {
                    manager.save();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving Data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    //Returns RecordList panel for other panels to use.
    public RecordList getRecordList() {
        return rl;
    }

}
