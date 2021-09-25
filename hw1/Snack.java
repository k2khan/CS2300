import java.text.DecimalFormat;

public class Snack {
  private int price;
  private String name;

  public Snack(String description, int price) {
    this.price = price;
    this.name = description;
  }

  public String getName() {
    return this.name;
  }

  public int getPrice() {
    return this.price;
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");
    return name + ": $" + df.format(this.price / 100.0);
  }
}

