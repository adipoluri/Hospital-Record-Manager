package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class SoundPlayer {

    //Audio Player that plays sound with given SOund Name
    public SoundPlayer(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Critical Coding Error Occured.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

