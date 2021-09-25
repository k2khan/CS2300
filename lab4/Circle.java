import java.lang.Math;
public class Circle extends Shape
{
    protected double radius;
    public Circle(double radius)
    {
        super("Circle");
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }
}
