import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class ContactZone {



    public static void getContacts () throws IOException {
        Path contact = Paths.get("data", "contacts.txt");
        List<String> contactList = Files.readAllLines(contact);
        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println(contactList.get(i));
        }
    }



    public static void main(String[] args) throws IOException {
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
        }

        //make "title" (Name | Phone Number)
        List<String> contactList = Arrays.asList("Name | Phone Number", "--------------------", "Jack Black | 1231231234", "Jane Doe | 2342342345", "Sam Space | 3453453456");
        Path filepath = Paths.get("data", "contacts.txt");
        Files.write(filepath, contactList);

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");


        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1){
            getContacts();
        }



    }


}
