package sample;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;


public class Controller {
    @FXML
    private TableView<Contact> contactTableView = new TableView<>();

    @FXML
    private TableColumn<Contact, String> firstNames;

    @FXML
    private TableColumn<Contact, String> lastNames;

    @FXML
    private TableColumn<Contact, String> phoneNumbers;

    @FXML
    private TableColumn<Contact, String> notes;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private VBox mainVBox;

    public void initialize() {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact contact = contactTableView.getSelectionModel().getSelectedItem();
                deleteItem(contact);
            }
        });
        MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact contact = contactTableView.getSelectionModel().getSelectedItem();
                editContactDialog(contact);

            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);
        listContextMenu.getItems().addAll(editMenuItem);

        try

        {
            ContactData.getInstance().loadContacts();
        } catch (IOException e) {

        }

        for (
                Contact con : ContactData.getInstance().

                getContactList())

        {
            System.out.println(con.getName());
        }
        if (ContactData.getInstance().getContactList().isEmpty()) {
            System.out.println("There is no data");
        } else

        {
            ObservableList<Contact> contactList = ContactData.getInstance().getContactList();
            contactTableView.setItems(contactList);
            firstNames.setCellValueFactory(new PropertyValueFactory("name"));
            lastNames.setCellValueFactory(new PropertyValueFactory("lastName"));
            phoneNumbers.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
            notes.setCellValueFactory(new PropertyValueFactory("notes"));
        }


        contactTableView.setContextMenu(listContextMenu);

    }


    public void deleteItem(Contact item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo item");
        alert.setHeaderText("Delete item: " + item.getName() + item.getLastName() + " from contacts?");
        alert.setContentText("Are You sure? Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ContactData.getInstance().deleteContact(item);
        }
    }

    public void editContactDialog(Contact contact) {
        Dialog<ButtonType> editContactDialog = new Dialog<>();
        editContactDialog.initOwner(mainVBox.getScene().getWindow());
        editContactDialog.setTitle("Edit a contact");

        FXMLLoader fxmlLoader = dialogTryCatchBlock(editContactDialog, "editContactDialog.fxml");

        Optional<ButtonType> result = editContactDialog.showAndWait();
        EditContactController controller = fxmlLoader.getController();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.editContact(contact);
        }
    }

    private FXMLLoader dialogTryCatchBlock(Dialog<ButtonType> dialog, String location) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(location));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException exeption) {
            System.out.println("Couldn't load the dialog");
            exeption.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        return fxmlLoader;
    }

    public void newContactDialog() {
        Dialog<ButtonType> addContactDialog = new Dialog<>();
        addContactDialog.initOwner(mainVBox.getScene().getWindow());
        addContactDialog.setTitle("Add new contact");

        FXMLLoader fxmlLoader = dialogTryCatchBlock(addContactDialog, "addNewContactDialog.fxml");

        Optional<ButtonType> result = addContactDialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddNewContactController controller = fxmlLoader.getController();
            controller.processResults();
        }

    }
}






