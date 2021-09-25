import java.util.ArrayList;

public class VendingMachine {
  private boolean isOn;
  private ArrayList<Snack> snacks;


  public VendingMachine() { 
    this.snacks = new ArrayList<Snack>();
    this.isOn = false;
  }

  public void add(Snack snack) {
    snacks.add(snack);
  }

  public void turnOn() {
    this.isOn = true;
  }

  public void turnOff() {
    this.isOn = false;
  }

  public Snack sell(String snackName) {
    if (isOn == false) {
      return null;
    } else {
      for (int i = 0; i < snacks.size(); i++) {
        if (snacks.get(i).getName().equals(snackName)) {
          return snacks.remove(i);
        }
      }
    }
    return null;
  }
}
