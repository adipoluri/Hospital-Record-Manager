package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessionalTest {
    private Professional doctor;

    @BeforeEach
    void runBefore() {
        doctor = new Professional("Dr. John");
    }

    @Test
    void testConstructor() {
        Professional doctor = new Professional("Clifford");
        assertEquals("Clifford", doctor.getName());
        assertEquals(0, doctor.getAge());
        assertEquals("N/A", doctor.getSex());
        assertEquals("N/A", doctor.getExtra());
        assertEquals("N/A", doctor.getSpecialization());
        assertEquals("N/A", doctor.getTitle());
    }

    @Test
    void testAddTitle() {
        doctor.setTitle("Neurosurgeon");
        assertEquals("Neurosurgeon", doctor.getTitle());
    }

    @Test
    void testGetTitle() {
        assertEquals("N/A", doctor.getTitle());
    }

    @Test
    void testAddSpecialization() {
        doctor.setSpecialization("Degree in Medicine, CardioVascular Surgeon");
        assertEquals("Degree in Medicine, CardioVascular Surgeon", doctor.getSpecialization());
    }

    @Test
    void testGetSpecialization() {
        assertEquals("N/A", doctor.getSpecialization());
    }
}
