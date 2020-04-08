package model;

import exceptions.NotRealPhoneNumberException;

public abstract class Person {
    protected String name;
    protected int age;
    protected String sex;
    protected String extra;
    protected String image;
    protected String phoneNumber;

    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.sex = "N/A";
        this.extra = "N/A";
        this.image = "data/patientimages/No-image-found.png";
        this.phoneNumber = "0000000000";
    }


    // EFFECTS: getter for name
    public String getName() {
        return this.name;
    }


    // EFFECTS: getter for Age
    public int getAge() {
        return this.age;
    }


    // EFFECTS: getter for Sex
    public String getSex() {
        return this.sex;
    }


    // EFFECTS: getter for Description
    public String getExtra() {
        return this.extra;
    }


    // EFFECTS: getter for Image Path
    public String getImage() {
        return this.image;
    }

    // EFFECTS: getter for Phone Number
    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    // MODIFIES: this
    // EFFECTS: name value changed to the str input
    public void addName(String str) {
        this.name = str;
    }


    // REQUIRES: 0 < Num < 150
    // MODIFIES: this
    // EFFECTS: age value changed to the num inputted
    public void addAge(int num) {
        this.age = num;
    }


    // MODIFIES: this
    // EFFECTS: sex value changed to the str inputted
    public void addSex(String str) {
        this.sex = str;
    }


    // MODIFIES: this
    // EFFECTS: description value changed to the str inputted
    public void addDescription(String str) {
        this.extra = str;
    }


    // MODIFIES: this
    // EFFECTS: Changes image path to the one inputted
    public void addImage(String str) {
        this.image = str;
    }

    // MODIFIES: this
    // EFFECTS: sets Phone Number
    public void addPhoneNumber(String phoneNumber) throws NotRealPhoneNumberException {
        if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotRealPhoneNumberException("Not Real PhoneNumber");
        }
    }
}
