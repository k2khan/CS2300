import java.util.Scanner;

public class Driver
{
    public static void getInput(Converter converter) {
        System.out.println("Enter amount ");
        Scanner scanner = new Scanner(System.in);
        converter.setFrom(Double.valueOf(scanner.nextLine()));
     } 
    public static void main(String []args)
    {
      FahrenheitToCelsius tempConverter = new FahrenheitToCelsius();
      getInput(tempConverter);
      tempConverter.convert();
       System.out.println(tempConverter.getConversionResult());
    }
}
