package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class ContactZoneMain {


    public static void main(String[] args) throws IOException {
        ContactZone contacting = new ContactZone();
        Input input = new Input();
        int userInput = 0;
        boolean userContinue = true;
        boolean userConfirm = true;

    contacting.createFile();
    contacting.readContacts();

    do {


        System.out.println("\n1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");


        userInput = input.getInt(1, 5, "Enter an option (1, 2, 3, 4 or 5):\n");

        switch(userInput){
            case 1: contacting.getContacts();
                input.yesNo("\nEnter [C] to continue.");
                    break;
            case 2:   userContinue = true;
                    while(userContinue) {
                        contacting.addContact();
                        userContinue = input.yesNo("\nWould you like to add someone else?");
                    }
                    break;
            case 3:  userContinue = true;
                    while(userContinue) {
                        contacting.searchContact();
                        userContinue = input.yesNo("\nWould you like to search for someone else?");
                }
                    break;
            case 4: userContinue = true;
                    while(userContinue) {
                        contacting.deleteContact();
                        userContinue = input.yesNo("\nWould you like to delete another contact?");
                }
                    break;
            case 5: contacting.writeContacts();
                    System.out.println("\nThanks for using our application! Goodbye!");
                    userConfirm = false;
        }

    }while(userConfirm);


}
}
