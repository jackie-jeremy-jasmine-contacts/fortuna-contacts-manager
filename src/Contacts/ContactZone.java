package Contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.nio.file.StandardOpenOption;
import static java.nio.file.Files.readAllLines;

public class ContactZone {

    Input input = new Input();
    List<String> contactList = new ArrayList<>();

    public void createFile() throws IOException {
        String directory = "data";
        String filename = "contacts.txt";


        //this is trying to grab the directory
        Path dataDirectory = Paths.get(directory);
        //this is trying to grab the file
        Path dataFile = Paths.get(directory, filename);

        //checking for the stuff then creating it if it doesn't exist
        //also won't do it but once
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
            List<String> contactList = Arrays.asList("Name | Phone Number", "--------------------", "Jack Black | 1231231234", "Jane Doe | 2342342345", "Sam Space | 3453453456");
            Path filepath = Paths.get("data", "contacts.txt");
            Files.write(filepath, contactList);
        }

        //make "title" (Name | Phone Number)



    }

    public void readContacts() throws IOException{
        Path contact = Paths.get("data", "contacts.txt");
        contactList = Files.readAllLines(contact);
    }

    public void getContacts () throws IOException {
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println(contactList.get(i));
        }
    }

    public void addContact(){
        String firstName = input.getString("What is the contact's first name?");
        String lastName =  input.getString("What is the contact's last name?");
        long phoneNumber = input.getNumber("What is the contact's phone number?");
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.add(firstName + " " + lastName + " | " + phoneNumber);

    }

    public void searchContact(){
        String contactName = input.getString("Please enter the name you want to search for: ");
        for (int i = 0; i < contactList.size(); i += 1) {
            if(contactList.get(i).contains(contactName)){
                System.out.println(contactList.get(i));
            }
        }
    }

    public void deleteContact(){

    }

    public void writeContacts() throws IOException {
        Files.write(
                Paths.get("data", "contacts.txt"),
                contactList
        );
    }


}
