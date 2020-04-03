import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ContactZone {



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
        List<String> contactList = Arrays.asList("Name | Phone Number");
        Path filepath = Paths.get("data", "contacts.txt");
        Files.write(filepath, contactList);

    }
}
