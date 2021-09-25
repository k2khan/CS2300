public class Driver {
   public static void main(String[] args) {
      if (args.length > 0) {
            PhoneRecordReaderCSV record = new PhoneRecordReaderCSV(args[0]);
            record.printRecords();
      }
   }
}