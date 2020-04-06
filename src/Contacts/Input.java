package Contacts;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
    }

    public String getString(String prompt){
        System.out.println();
        System.out.println(prompt);
        System.out.println();
        return scanner.next();
    }

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        String bool = scanner.next();
        if(bool.toLowerCase().contains("y")) {
            return true;
        }
        return false;
    }

    public int getInt(int min, int max, String prompt){
        int check=0;
        check = getInt(prompt);
        if(check < min || check > max){
            System.out.println("That's not in range");
            check = getInt(min, max, prompt);
        }
        return check;
    }

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

    public long getNumber(String prompt){
        int length = 1;
        long phoneNumber = 1;
        do {
            phoneNumber = getLong(prompt);
            length = getRange(phoneNumber);
        }while(length != 7 && length != 10 );
        return phoneNumber;
    }

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
