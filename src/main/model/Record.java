package model;

import java.util.ArrayList;


// Represents the Records made of a list of Patients
public class Record {
    private ArrayList<Patient> records;   //Contains every patient
    private ArrayList<Professional> doctors;

    // EFFECTS: Constructs a new Record with an empty ArrayList for Patients
    public Record() {
        records = new ArrayList<>();
        doctors = new ArrayList<>();
    }


    // EFFECTS: Getter for records
    public ArrayList<Patient> getRecords() {
        return this.records;
    }

    // EFFECTS: Getter for doctors
    public ArrayList<Professional> getDoctors() {
        return this.doctors;
    }


    // MODIFIES: this
    // EFFECTS: Constructs new patient with Name name and inputs it into the end of the list.
    public void addPatient(String name) {
        Patient patient = new Patient(name);
        getRecords().add(patient);
    }


    // MODIFIES: this
    // EFFECTS: Constructs new patient with Name name and inputs it into the end of the list.
    public void addDoctor(String name) {
        Professional doctor = new Professional(name);
        getDoctors().add(doctor);
    }


    // REQUIRES: num to be a patient ID in the Records,
    // MODIFIES: this
    // EFFECTS: removes specified patient from Records
    public void removePatient(int num) {
        getRecords().remove(num);
    }


    // EFFECTS: Returns Size of records
    public int recordLength() {
        return this.records.size();
    }


    // EFFECTS: Returns true if Records is empty
    public boolean isEmpty() {
        return this.recordLength() <= 0;
    }


    // MODIFIES: this
    // EFFECTS: Removes every patient from the Records
    public void clearRecords() {
        getRecords().clear();
        getDoctors().clear();
    }


    // MODIFIES: this
    //EFFECTS: Returns an array of names of the Patients
    public ArrayList<String> toListOfString() {
        ArrayList<String> str = new ArrayList<>();

        for (Person person : this.getRecords()) {
            str.add(person.getName());
        }

        return str;
    }
}
