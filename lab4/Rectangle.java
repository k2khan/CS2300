public class Rectangle extends Shape {
  protected double width;
  protected double height;

  public Rectangle(double width, double height) {
    super("Rectangle");
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return this.width * this.height;
  }
}
