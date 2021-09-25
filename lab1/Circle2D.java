public class Circle2D {
  private Point2D center;
  private double radius;

  public Circle2D() {
    this.center = new Point2D(0, 0);
    this.radius = 1;
  }
  
  public Circle2D(Point2D point, double rad) {
    this.center = new Point2D(point.getX(), point.getY()); 
    this.radius = rad;
  }

  public String toString() {
    return "Center: " + center.toString() + " Radius: " + this.radius;
  }
}

