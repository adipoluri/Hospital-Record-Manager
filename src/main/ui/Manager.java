package ui;

import java.awt.*;
import java.io.IOException;

import model.Record;
import persistence.Reader;
import persistence.Writer;

import javax.swing.*;


public class Manager {
    public Record records;
    private String file = "data/RecordData.json";
    // EFFECTS: Constructs the Manager and starts the program

    public Manager() {
    }

    // returns the Records object
    public Record getRecords() {
        return records;
    }

    // MODIFIES: this
    //  EFFECTS: Creates new Writer Object and Writes current Record Object to savefile
    // Saves all records at that instance and overwrites old Save File
    public void save() throws IOException {
        Writer writer = new Writer(file);
        writer.write(records);
        writer.close();
    }


    //  EFFECTS: Initializes new Reader Object and reads data off of save file
    //           If Reader Object does not find an existing file, Function will return
    //           new empty Record Object
    public void reload() throws IOException {
        Reader reader = new Reader(file);
        records = reader.getRecords();
        reader.close();
    }

    //  EFFECTS: Initializes new Reader Object and reads data off of GIVEN save file
    public void reload(String str) throws IOException {
        Reader reader = new Reader(str);
        records = reader.getRecords();
        reader.close();
    }


    // MODIFIES: this
    // EFFECTS: Clears all Records
    public void deleteRecords() {
        records.clearRecords();
    }
}
