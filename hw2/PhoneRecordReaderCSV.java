import java.io.*;
import java.util.ArrayList;

public class PhoneRecordReaderCSV {
   private BufferedReader br;
   private ArrayList<PhoneRecord> phoneRecords;

   public PhoneRecordReaderCSV(String fileName) {
      try {
         File file = new File(fileName);
         this.br = new BufferedReader(new FileReader(file));
         String line = "";
         this.phoneRecords = new ArrayList<PhoneRecord>();
         while ((line = this.br.readLine()) != null) {
            String[] fields = line.split(",");
            this.phoneRecords.add(new PhoneRecord(fields[0], fields[1], fields[2]));
         }
     } catch (FileNotFoundException e) {
         System.out.println("Could not read from " + fileName);
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("Could not read from " + fileName);
         e.printStackTrace();
      } catch (IndexOutOfBoundsException e) {
         System.out.println("Could not read from " + fileName);
         e.printStackTrace();
      } catch (Exception e) {
         System.out.println("Could not read from " + fileName);
         e.printStackTrace();
      }
   }
      
    /**
    * Returns an ArrayList of records read from the file. 
    * If no records were read returns an empty array. 
    * The return value should never be null.
    * If file cannot be read, prints an error message
    */
   public ArrayList<PhoneRecord> getRecords() {
      return this.phoneRecords;
   }

   public void printRecords() {
      for (int i = 0; i < phoneRecords.size(); i++) {
         System.out.println(phoneRecords.get(i));
      }
   }
}
