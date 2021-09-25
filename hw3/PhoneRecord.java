public class PhoneRecord extends PhoneBook {
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
      return this.firstName.toUpperCase().replaceAll("\\s", "");

   }

   /**
    * Returns last name (in all upper case) associated with the record
    */
   public String getLastName() {
      return this.lastName.toUpperCase().replaceAll("\\s", "");
   }

   /**
    * Returns phone number (with no dashes)
    */
   public String getPhoneNumber() {
      return this.phoneNumber.replaceAll("\\s", "");
   }

   public String toString() {
      return this.getFirstName() + " " + this.getLastName() + " " + this.getPhoneNumber();

   }

   public boolean containsValue(String val) {
      val = val.replaceAll("\\s", "");
      val = val.toUpperCase();
      if (val.equals(this.getFirstName()) || val.equals(this.getLastName()) || val.replaceAll("[^0-9]+", "").equals(this.getPhoneNumber())) {
         return true;
      }
      return false;
   }
}
