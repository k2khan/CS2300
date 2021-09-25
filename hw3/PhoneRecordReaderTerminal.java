import java.util.ArrayList;
import java.util.Scanner;

public class PhoneRecordReaderTerminal extends PhoneRecordReader{
    public PhoneRecordReaderTerminal() {
        boolean bool = true;
        while (bool) {
            String first;
            String last;
            String number;
            String answer;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter first name: ");
            first = in.nextLine();
            System.out.println("Enter last name: ");
            last = in.nextLine();
            System.out.println("Enter phone number: ");
            number = in.nextLine();
            records.add(new PhoneRecord(first, last, number));

            System.out.println("Type ADD to add more or DONE to end entering data");
            answer = in.nextLine();
            if (answer.equals("ADD")) {
                bool = true;
            } else if (answer.equals("DONE")) {
                bool = false;
            }
        }
    }
    public ArrayList<PhoneRecord> getRecords() {
        return records;
    }



}