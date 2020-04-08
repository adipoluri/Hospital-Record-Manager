package persistence;

import model.Record;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    private static final String TEST_FILE = "./data/testdata/testRecords.json";
    private Reader reader;


    @Test
    void testConstructor() {
        try {
            reader = new Reader(TEST_FILE);
        } catch (FileNotFoundException e) {
            fail("Exception should not be thrown");
        }

        try {
            reader = new Reader("d.af3r.g,a/afs.3r,g");
            fail("This Should Not Work!!!");
        } catch (FileNotFoundException e) {
            System.out.print("Great, Exception thrown correctly!");
        }
    }

    @Test
    void FileExists() {

        try {
            reader = new Reader(TEST_FILE);
            assertTrue(reader.fileExists(TEST_FILE));
            assertFalse(reader.fileExists("COLUMBUS"));
        } catch (FileNotFoundException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testClose() {
        try {
            reader = new Reader(TEST_FILE);
            Record record = reader.getRecords();
            reader.close();
            assertFalse(record.isEmpty());
        } catch (IOException e) {
            fail("This should not be thrown!!");
        }

        try {
            reader = new Reader("a/adag/g.ea.sda");
            Record record = reader.getRecords();
            reader.close();
            assertFalse(record.isEmpty());
            fail("This should not be thrown!!");
        } catch (IOException e) {
            System.out.print("Great, Exception was thrown correctly!");
        }
    }


    @Test
    void testGetRecords() {
        try {
            reader = new Reader(TEST_FILE);
            Record record = reader.getRecords();
            reader.close();
            assertEquals(2, record.getRecords().size());
            assertFalse(record.isEmpty());
            assertEquals("Jonathon", record.getRecords().get(0).getName());
        } catch (IOException e) {
            fail("This should not be thrown!!");
        }
    }
}
