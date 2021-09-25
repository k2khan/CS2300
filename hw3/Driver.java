import java.util.Scanner;
import java.io.*;

public class Driver {
   public static void main(String[] args) {
      if (args.length > 0) {
         PhoneBook book = new PhoneBook();
         try {
            book.loadRecords(new PhoneRecordReaderCSV(args[0]));
         } catch (ArrayIndexOutOfBoundsException e) {
            book.loadRecords(new PhoneRecordReaderTerminal());
         }
         book.search();
      }
      PhoneBook book = new PhoneBook();
      book.loadRecords(new PhoneRecordReaderTerminal());
      book.search();
   }
}
