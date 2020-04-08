package ui;

import javax.swing.*;
import java.awt.*;

//Creates a Settings Panel
public class Settings extends JPanel {

    public Settings() {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(new GridBagLayout());
    }

}
