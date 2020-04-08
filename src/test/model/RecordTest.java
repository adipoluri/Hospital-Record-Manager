package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecordTest {
    private Record records;

    @BeforeEach
    void runBefore() {
        records = new Record();
    }

    @Test
    void testConstructor() {
        assertTrue(records.isEmpty());
    }

    @Test
    void testGetRecords() {
        records.addPatient("George");
        assertEquals(1, records.getRecords().size());
        records.addPatient("George");
        records.addPatient("George");
        records.addPatient("George");
        assertEquals(4, records.getRecords().size());
    }

    @Test
    void testAddPatient() {
        records.addPatient("Biffo");
        assertEquals(1, records.recordLength());
        records.addPatient("Biffo2");
        records.addPatient("Biffo3");
        assertEquals(3, records.recordLength());

    }

    @Test
    void testRemovePatient() {
        records.addPatient("Biffo");
        records.addPatient("Biffo2");
        records.addPatient("Biffo3");
        assertEquals(3, records.recordLength());
        records.removePatient(2);
        records.removePatient(1);
        records.removePatient(0);
        assertEquals(0, records.recordLength());
        assertTrue(records.isEmpty());
    }

    @Test
    void testRecordLength() {
        records.addPatient("Biffo");
        records.addPatient("Biffo2");
        records.addPatient("Biffo3");
        assertEquals(3, records.recordLength());
    }

    @Test
    void testIsEmpty() {
        assertTrue(records.isEmpty());
        records.addPatient("Boy");
        assertFalse(records.isEmpty());
    }

    @Test
    void testClearRecords() {
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        assertFalse(records.isEmpty());
        records.clearRecords();
        assertTrue(records.isEmpty());
    }

    @Test
    void testToListOfString() {
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        records.addPatient("Boy");
        ArrayList<String> str = new ArrayList<>();
        str.add("Boy");
        str.add("Boy");
        str.add("Boy");
        str.add("Boy");
        str.add("Boy");
        assertEquals(str, records.toListOfString());
    }

    @Test
    void testAddDoctor() {
        assertEquals(0, records.getDoctors().size());
        records.addDoctor("John");
        assertEquals(1, records.getDoctors().size());
    }
}
