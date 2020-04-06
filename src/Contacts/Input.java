package Contacts;

import java.util.Scanner;

public class Input {
    //defining variable scanner
    private Scanner scanner;

    public Input(){
        //created scanner
        scanner = new Scanner(System.in);
    }
    //this returns what the user put in
    public String getString(String prompt){
        System.out.println();
        System.out.println(prompt);
        System.out.println();
        return scanner.nextLine();
    }
    //if the user entered "Y", this returns true
    public boolean yesNo(String prompt){
        System.out.println(prompt);
        String bool = scanner.nextLine();
        if(bool.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }
    //this will create the prompt for user to enter a number between 1-5 and check if it is in range
    public int getInt(int min, int max, String prompt){
        int check=0;
        check = getInt(prompt);
        if(check < min || check > max){
            System.out.println("That's not in range");
            check = getInt(min, max, prompt);
        }
        return check;
    }
    //this will test if the response is able to be made into a number
    public int getInt(String prompt){
        int v = 0;
        boolean validInput = false;
        while(!validInput) {
            try {
                String s = getString(prompt);
                v = Integer.parseInt(s);
                validInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("\n" + nfe);
                System.out.println("That is not an option, please try again.\n");
            }
        }
        System.out.println();
        return v;
    }
    //checking if it is a valid number
    public long getLong(String prompt){
        long v = 0;
        boolean validInput = false;
        while(!validInput) {
            try {
                String s = getString(prompt);
                v =Long.parseLong(s);
                validInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("\n" + nfe);
                System.out.println("This is not a phone number.\n");
            }
        }
        System.out.println();
        return v;
    }
    //checks the length of the number
    public long getNumber(String prompt){
        int length = 1;
        long phoneNumber = 1;
        do {
            phoneNumber = getLong(prompt);
            length = getRange(phoneNumber);
        }while(length != 7 && length != 10 );
        return phoneNumber;
    }
    //math stuff for big ass number
    public int getRange(long number){
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

}
