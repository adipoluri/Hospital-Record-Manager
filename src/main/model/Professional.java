package model;

//Represents A Medical Professional
public class Professional extends Person {
    private String specialization;
    private String title;

    //Instantiates new Professional with Name name
    public Professional(String name) {
        super(name);
        this.specialization = "N/A";
        this.title = "N/A";
    }


    public String getSpecialization() {
        return this.specialization;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSpecialization(String str) {
        this.specialization = str;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
