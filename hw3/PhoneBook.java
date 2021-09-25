import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBook {
    protected ArrayList<PhoneRecord> records = new ArrayList<PhoneRecord>();
    protected ArrayList<PhoneRecord> matches = new ArrayList<PhoneRecord>();

    public PhoneBook() {
    }

    public void loadRecords(PhoneRecordReader val) {
        this.records = val.getRecords();
    }

    public void search() {
        Scanner in = new Scanner(System.in);
        System.out.println("SEARCH PHONE BOOK");
        System.out.println("Enter a first name, last name, or phone number you want to find (press enter to exit)");
        String s = in.nextLine();

        while (!s.equals("")) {
            for (PhoneRecord i : records) {
                if (i.containsValue(s)) {
                    matches.add(i);
                    System.out.println(i);
                }
            }
            System.out.println("Enter a first name, last name, or phone number you want to find (press enter to exit)");
            s = in.nextLine();
        }
    }

    public void printRecords(ArrayList<PhoneRecord> matches) {
        for (PhoneRecord i : matches) {
            System.out.println(i);
        }
        matches.clear();
    }
}