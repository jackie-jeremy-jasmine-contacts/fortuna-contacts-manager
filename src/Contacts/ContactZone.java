package Contacts;

import jdk.swing.interop.SwingInterOpUtils;

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
    // creates file if it doesn't exist
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
            List<String> contactList = Arrays.asList("");
            Path filepath = Paths.get("data", "contacts.txt");
            Files.write(filepath, contactList);
        }

        //make "title" (Name | Phone Number)



    }
    //reads memory to find contacts
    public void readContacts() throws IOException{
        Path contact = Paths.get("data", "contacts.txt");
        contactList = Files.readAllLines(contact);
    }
    //loops through contacts and prints them to the console
    public void getContacts () throws IOException {
        System.out.println("Name                      | Phone Number");
        System.out.println("--------------------------|-------------");
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println(contactList.get(i));
        }
    }
    //prompts and adds info to array list
    public void addContact(){
        int index = 0;
        boolean overwriteConfirm = false;
        String newNumber = "";
        String firstName = input.getString("What is the contact's first name?");
        String lastName =  input.getString("What is the contact's last name?");


        for (int i = 0; i < contactList.size(); i += 1) {
            // if there is a match, grab that index
            if(contactList.get(i).contains(firstName + " " + lastName)) {
                index = i;
                System.out.println(firstName + " " + lastName + " already exists in the contact list - do you want to" +
                        " overwrite?");
                overwriteConfirm = input.yesNo("");
                if(!overwriteConfirm){
                    addContact();
                    return;
                } else if (overwriteConfirm){
                    contactList.remove(index);
                }
            }
        }



        long phoneNumber = input.getNumber("What is the contact's phone number?");
        String number = Long.toString(phoneNumber);
        if(number.length() == 7){
            newNumber = number.substring(0, 3) + "-" + number.substring(3);
        } else if(number.length() == 10) {
            newNumber = number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
        }
        String name = firstName + " " + lastName;
            String contactLine = String.format("%-25s %s %-10s", name, "|", newNumber);
//        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.add(contactLine);

    }


    public int searchContact(){
        //Gets user's response and stores it as a string
        String contactName = input.getString("Enter a name: ");
        //Initially set to name not existing
        int contactIndex = -1;
        //loops through contactList
        for (int i = 0; i < contactList.size(); i += 1) {
            // if there is a match, grab that index
            if(contactList.get(i).contains(contactName)){
                contactIndex = i;
            }
        }
        //if the name is not a match then print this
        if(contactIndex == -1){
            System.out.println("Sorry, that person isn't in the list!");
        } else {
            //print out matching contact
            System.out.println(contactList.get(contactIndex));
        }
        return contactIndex;


    }

    public void deleteContact(){
        //finding name of person entered and returning the index
        int nameToDelete = searchContact();
        //call yesNo method to make sure user wants to delete person
        boolean continueToDelete = input.yesNo("Are you sure you want to delete this person? YES/NO");
        //if the above returns true, delete name from contact list
            if(continueToDelete) {
                System.out.printf("%s Deleted\n", contactList.get(nameToDelete));
            contactList.remove(nameToDelete);
            }
    }

    //this clears the file and adds and saves to contacts.txt
    public void writeContacts() throws IOException {
        Files.write(
                Paths.get("data", "contacts.txt"),
                contactList
        );
    }


}
