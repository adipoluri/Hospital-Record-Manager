package persistence;

import model.Patient;
import model.Record;
import model.Record.*;
import persistence.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class WriterTest {
    private static final String TEST_FILE = "./data/testdata/testRecords.json";
    private static final String TEST_FILE2 = "./data/testdata/testRecords2.json";

    private Record records;
    private Record record;
    private Writer testWriter2;
    private Writer writer = null;
    private Writer testWriter;
    private Reader reader;
    private Reader reader2;



    @BeforeEach
    void runBefore() {
        records = new Record();
        records.addPatient("Jonathon");
        records.addPatient("Claudia");
    }

    @Test
    void testConstructor() {

        try {
            testWriter = new Writer(TEST_FILE);
            testWriter.write(records);
            testWriter.close();
            reader = new Reader(TEST_FILE);
            assertTrue(reader.fileExists(TEST_FILE));
        } catch (IOException e) {
            fail("Exception should not be thrown!");
        }

        try {
            writer = new Writer("Columbusro536/47");
            fail("This should not work!!!");
        } catch (IOException e) {
            System.out.print("Great!");
        }
    }


    @Test
    void testClose() {
        try {
            testWriter = new Writer(TEST_FILE);
            testWriter.close();
        } catch (IOException e) {
            fail("Exception should not be thrown!");
        }

        try {
            writer = new Writer(".dad341/ad3145");
            testWriter.close();
            fail("This should not work!!!");
        } catch (IOException e) {
            System.out.print("Great!");
        }
    }


    @Test
    void testWrite() {
        try {
            testWriter2 = new Writer(TEST_FILE2);
            testWriter2.write(records);
            testWriter2.close();

            reader2 = new Reader(TEST_FILE2);
            record = reader2.getRecords();
            reader2.close();
        } catch (IOException e) {
            fail("Exception should not be thrown!");
        }
        assertEquals(2, record.getRecords().size());
        assertTrue(!record.isEmpty());
        assertEquals("Jonathon", record.getRecords().get(0).getName());
    }
}
