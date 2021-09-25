public class Driver {
  public static void main(String[] args) {
    VendingMachine Ven = new VendingMachine();
    Snack Chips = new Snack("Chips", 75);
    Snack Twix = new Snack("Twix", 100);
    Snack Cookies = new Snack("Cookies", 125);
    Snack Gum = new Snack("Gum", 85);
    Snack Pretzels = new Snack("Pretzels", 105);
    Ven.add(Chips);
    Ven.add(Twix);
    Ven.add(Cookies);
    Ven.add(Gum);
    Ven.add(Pretzels);
    System.out.println(Ven.sell("Twix"));
    Ven.turnOn();
    System.out.println(Ven.sell("Twix"));
    System.out.println(Ven.sell("Twix"));
    System.out.println(Ven.sell("Gum"));
    System.out.println(Ven.sell("Pretzels"));
  }
}
