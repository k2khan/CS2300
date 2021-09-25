public class PhoneRecord {
   private String firstName;
   private String lastName;
   private String phoneNumber;

   /*
    * Creates a PhoneRecord object with the values specified in the constructor
    */
   public PhoneRecord(String firstName, String lastName, String phoneNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
   }

   /**
    * Returns first name (in all upper case) associated with the record
    */
   public String getFirstName() {
      return this.firstName.toUpperCase();

   }

   /**
    * Returns last name (in all upper case) associated with the record
    */
   public String getLastName() {
      return this.lastName.toUpperCase();
   }

   /**
    * Returns phone number (with no dashes)
    */
   public String getPhoneNumber() {
      return this.phoneNumber.replaceAll("\\D", "");
   }

   public String toString() {
      return getFirstName() + getLastName() + " " + getPhoneNumber();

   }
}
