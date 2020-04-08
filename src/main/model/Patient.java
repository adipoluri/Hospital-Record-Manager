package model;

import exceptions.NotCorrectFormatException;
import exceptions.NotRealPhoneNumberException;

// Represents a patient and their information
public class Patient extends Person {
    private Professional doctor;
    private String address;
    private String occupation;
    private String citizenship;
    private String carecard;
    private String history;


    // EFFECTS: Constructs patient with name name, age = 0, sex = "N/A" and description of "N/A"
    public Patient(String name) {
        super(name);
        this.addDoctor(new Professional("N/A"));
        this.address = "N/A";
        this.occupation = "N/A";
        this.citizenship = "N/A";
        this.carecard = "0000000000";
        this.history = "N/A";
    }

    // EFFECTS: getter for doctor
    public Professional getDoctor() {
        return doctor;
    }

    // EFFECTS: getter for address
    public String getAddress() {
        return address;
    }

    // EFFECTS: getter for occupation
    public String getOccupation() {
        return occupation;
    }

    // EFFECTS: getter for citizenship
    public String getCitizenShip() {
        return citizenship;
    }

    // EFFECTS: getter for carecard
    public String getCareCard() {
        return carecard;
    }

    // EFFECTS: getter for history
    public String getHistory() {
        return history;
    }

    // MODIFIES: this
    // EFFECTS: address value changed to the str input
    public void setAddress(String str) {
        this.address = str;
    }

    // MODIFIES: this
    // EFFECTS: occupation value changed to the str input
    public void setOccupation(String str) {
        this.occupation = str;
    }

    // MODIFIES: this
    // EFFECTS: citizenship value changed to the str input
    public void setCitizenship(String str) {
        this.citizenship = str;
    }

    // MODIFIES: this
    // EFFECTS: CareCard value changed to the str input
    public void setCarecard(String num) throws NotCorrectFormatException {
        if (num.matches("[0-9]+") && num.length() == 10) {
            this.carecard = num;
        } else {
            throw new NotCorrectFormatException("Not Correct Format!");
        }
    }


    // MODIFIES: this
    // EFFECTS: history value changed to the str input
    public void setHistory(String str) {
        this.history = str;
    }

    // MODIFIES: this
    // EFFECTS: doctor changed to the one given.
    public void addDoctor(Professional doctor) {
        this.doctor = doctor;
    }


}
