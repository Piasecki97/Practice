package sample.datamodel;

public class Contact {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String notes;

    public Contact(String name, String lastName, String phoneNumber, String notes) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
