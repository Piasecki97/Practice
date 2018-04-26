package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

public class EditContactController {
    @FXML
    private TextField editFirstName;

    @FXML
    private TextField editLastName;

    @FXML
    private TextField editPhone;

    @FXML
    private TextArea editContactNotes;
    public void initialize(Contact contact){

        editFirstName.setText(contact.getName());
        editLastName.setText(contact.getLastName());
        editPhone.setText(contact.getPhoneNumber());
        editContactNotes.setText(contact.getNotes());
    }
    public Contact editContact(Contact previousContact){


        String name;
        String lastName;
        String phoneNumber;
        String notes;

        if (editFirstName.getText().isEmpty()){
            name = previousContact.getName();
        } else {
            name = editFirstName.getText();
        }
        if (editLastName.getText().isEmpty()){
            lastName = previousContact.getLastName();
        } else {
            lastName = editLastName.getText();
        }
        if (editPhone.getText().isEmpty()){
            phoneNumber = previousContact.getPhoneNumber();
        } else {
            phoneNumber = editPhone.getText();
        }
        if (editContactNotes.getText().isEmpty()){
            notes = previousContact.getNotes();
        } else {
            notes = editContactNotes.getText();
        }

        Contact contact = new Contact(name, lastName, phoneNumber, notes);

        ContactData.getInstance().deleteContact(previousContact);
        ContactData.getInstance().addContact(contact);

        return contact;
    }
}
