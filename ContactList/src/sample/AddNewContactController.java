package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

public class AddNewContactController {

    @FXML
    private TextField newFirstName;

    @FXML
    private TextField newLastName;

    @FXML
    private TextField newPhone;

    @FXML
    private TextArea newContactNotes;

    public Contact processResults() {
        String nameToAdd = newFirstName.getText();
        String lastNameToAdd = newLastName.getText();
        String phoneNum = newPhone.getText();
        String contactNotes = newContactNotes.getText().trim();

        Contact addedContact = new Contact(nameToAdd, lastNameToAdd, phoneNum, contactNotes);


        ContactData.getInstance().addContact(new Contact(nameToAdd, lastNameToAdd, phoneNum, contactNotes));

        return addedContact;
    }


}
