public class Exponential implements Function2D {
  private double value;

  public Exponential(double val) {
    this.value = val;
  }


  @Override
  public double eval(double x) {
    return java.lang.Math.pow(this.value, x);
  }
}
