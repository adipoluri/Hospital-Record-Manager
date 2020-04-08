package model;

import exceptions.NotCorrectFormatException;
import exceptions.NotRealPhoneNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    private Patient patient;

    @BeforeEach
    void runBefore() {
        patient = new Patient("John");
    }

    @Test
    void testConstructor() {
        Patient patient = new Patient("Clifford");
        assertEquals("Clifford", patient.getName());
        assertEquals(0, patient.getAge());
        assertEquals("N/A", patient.getSex());
        assertEquals("N/A", patient.getExtra());
        assertEquals("N/A", patient.getAddress());
        assertEquals("N/A", patient.getOccupation());
        assertEquals("N/A", patient.getCitizenShip());
        assertEquals("0000000000", patient.getCareCard());
        assertEquals("N/A", patient.getHistory());
    }

    @Test
    void testGetName() {
        assertEquals("John", patient.getName());
    }

    @Test
    void testAddName() {
        patient.addName("Biffo");
        assertEquals("Biffo", patient.getName());
    }

    @Test
    void testGetAge() {
        patient.addAge(9);
        assertEquals(9, patient.getAge());
    }

    @Test
    void testAddAge() {
        patient.addAge(102);
        assertEquals(102, patient.getAge());
    }

    @Test
    void testGetSex() {
        patient.addSex("Male");
        assertEquals("Male", patient.getSex());
    }

    @Test
    void testAddSex() {
        patient.addSex("Female");
        assertEquals("Female", patient.getSex());
    }

    @Test
    void testAddDescription() {
        patient.addDescription("Dead");
        assertEquals("Dead", patient.getExtra());
    }

    @Test
    void testGetDescription() {
        patient.addDescription("Alive!");
        assertEquals("Alive!", patient.getExtra());
    }

    @Test
    void testGetImage() {
        assertEquals("data/patientimages/No-image-found.png", patient.getImage());
    }

    @Test
    void testAddImage() {
        patient.addImage("LOL");
        assertEquals("LOL", patient.getImage());
    }

    @Test
    void testGetDoctor() {
        assertEquals("N/A", patient.getDoctor().getName());
    }

    @Test
    void testAddDoctor() {
        patient.addDoctor(new Professional("John"));
        assertEquals("John", patient.getDoctor().getName());
    }

    @Test
    void testGetAddress() {
        assertEquals("N/A", patient.getAddress());
    }

    @Test
    void testAddAddress() {
        patient.setAddress("Johnny Street");
        assertEquals("Johnny Street", patient.getAddress());
    }


    @Test
    void testGetOccupation() {
        assertEquals("N/A", patient.getOccupation());
    }

    @Test
    void testAddOccupation() {
        patient.setOccupation("Doctor");
        assertEquals("Doctor", patient.getOccupation());
    }

    @Test
    void testGetCitizenship() {
        assertEquals("N/A", patient.getCitizenShip());
    }

    @Test
    void testAddCitizenship() {
        patient.setCitizenship("Citizen of Nigeria");
        assertEquals("Citizen of Nigeria", patient.getCitizenShip());
    }


    @Test
    void testGetHistory() {
        assertEquals("N/A", patient.getHistory());
    }

    @Test
    void testAddHistory() {
        patient.setHistory("Citizen of Nigeria");
        assertEquals("Citizen of Nigeria", patient.getHistory());
    }


    //Tests for Phase 4:
    @Test
    void testGetCareCard() {
        assertEquals("0000000000", patient.getCareCard());
    }

    @Test
    void testAddCareCardCorrect() {
        try {
            patient.setCarecard("1234567890");
            assertEquals("1234567890", patient.getCareCard());
        } catch (NotCorrectFormatException e) {
            fail();
        }
    }

    @Test
    void testAddCareCardWrong() {
        try {
            patient.setCarecard("312f");
            fail();
        } catch (NotCorrectFormatException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }
        try {
            patient.setCarecard("ffffffffff");
            fail();
        } catch (NotCorrectFormatException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }

        try {
            patient.setCarecard("");
            fail();
        } catch (NotCorrectFormatException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }

        try {
            patient.setCarecard("000");
            fail();
        } catch (NotCorrectFormatException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }
    }


    @Test
    void testGetPhoneNumber() {
        assertEquals("0000000000", patient.getPhoneNumber());
    }

    @Test
    void testAddPhoneNumberCorrect() {
        try {
            patient.addPhoneNumber("1234567890");
            assertEquals("1234567890", patient.getPhoneNumber());
        } catch (NotRealPhoneNumberException e) {
            fail();
        }
    }

    @Test
    void testAddPhoneNumberWrong() {
        try {
            patient.addPhoneNumber("312f");
            fail();
        } catch (NotRealPhoneNumberException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }

        try {
            patient.addPhoneNumber("ffffffffff");
            fail();
        } catch (NotRealPhoneNumberException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }

        try {
            patient.addPhoneNumber("");
            fail();
        } catch (NotRealPhoneNumberException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }

        try {
            patient.addPhoneNumber("000");
            fail();
        } catch (NotRealPhoneNumberException e) {
            assertEquals("0000000000", patient.getCareCard());
            System.out.println("Exception Thrown Correctly!");
        }
    }

}