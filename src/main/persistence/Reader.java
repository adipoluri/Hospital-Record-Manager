package persistence;

import com.google.gson.Gson;
import model.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


// A reader that can read Record Data from a JSON file
public class Reader {
    private Gson gson = new Gson();
    private FileReader reader;



    //EFFECTS: constructs GSON reader from desired file path
    public Reader(String file) throws FileNotFoundException {
        reader = new FileReader(file);
    }




    // MODIFIES: this
    // EFFECTS: Returns Record Object parsed from JSON File using GSON
    public Record getRecords() {
        return gson.fromJson(reader, Record.class);
    }




    // EFFECTS: Returns true if File is found
    public boolean fileExists(String file) {
        File temp = new File(file);
        return temp.exists();
    }




    // MODIFIES: this
    // EFFECTS: closes FileReader
    // NOTE: you MUST call this method when you are done reading data!
    public void close() throws IOException {
        reader.close();
    }


}


