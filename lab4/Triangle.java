public class Triangle extends Shape
{
    protected double base;
    protected double height;

    public Triangle(double base, double height)
    {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    public double getArea()
    {
        return this.base * this.height/2;
    }
}
