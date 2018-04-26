package sample.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;

public class ContactData {
    private static ContactData instance = new ContactData();
    private static String filename = "ContactDataItems.txt";

    private ObservableList<Contact> contactList;

    public static ContactData getInstance() {
        return instance;
    }

    public ObservableList<Contact> getContactList() {
        return contactList;
    }
    public void addContact(Contact contact){
        System.out.println(contact.getName() + " " + contact.getLastName() + " " + contact.getPhoneNumber() + " " + contact.getNotes());
        contactList.add(contact);
        System.out.println("error");
        try {
            storeContacts();
        }catch (IOException e){

        }
    }

    public void storeContacts() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Contact> iter = contactList.iterator();
            while (iter.hasNext()){
                Contact contact = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                            contact.getName(),
                            contact.getLastName(),
                            contact.getPhoneNumber(),
                            contact.getNotes()));
                bw.newLine();
            }
        } finally {
            if(bw != null){
                bw.close();
            }
        }
    }
    public void deleteContact(Contact contact){
        contactList.remove(contact);
    }

    public void loadContacts() throws IOException {

        contactList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String name= itemPieces[0];
                String lastName = itemPieces[1];
                String number = itemPieces[2];
                String notes = itemPieces[3];

                Contact contact = new Contact(name, lastName, number, notes);
                contactList.add(contact);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
