package ui;

import com.formdev.flatlaf.*;
import model.Record;
import org.omg.CORBA.PUBLIC_MEMBER;
import persistence.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //Initializes Frame and sets basic startup
        FlatLightLaf.install();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Screen("Medical Records Manager");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 800);
                Image icon = Toolkit.getDefaultToolkit().getImage(
                        "src/images/logo.png");
                frame.setIconImage(icon);
                frame.setVisible(true);
            }
        });
    }
}



