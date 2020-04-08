package persistence;


import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Record;


// A writer that writes Record Data to JSON File
public class Writer {
    private Gson gson;
    private FileWriter file;



    // EFFECTS: constructs a Writer that will turn Object data into JSON
    public Writer(String str) throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();
        file = new FileWriter(str);
    }



    // MODIFIES: this
    // EFFECTS: closes FileWriter
    // NOTE: you MUST call this method when you are done writing data!
    public void close() throws IOException {
        this.file.close();
    }



    // MODIFIES: this
    // EFFECTS: writes Record Object to JSON file
    public void write(Record record) {
        gson.toJson(record, file);
    }
}
