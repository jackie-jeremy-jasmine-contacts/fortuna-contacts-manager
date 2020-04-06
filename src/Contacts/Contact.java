package Contacts;

public class Contact {

   private String firstName = "";
   private String lastName = "";
   private long phoneNumber = 0;

   public Contact(String fName, String lName, long number){
       setFirstName(fName);
       setLastName(lName);
       setPhoneNumber(number);
   }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
