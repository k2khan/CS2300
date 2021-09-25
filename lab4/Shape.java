public abstract class Shape
{
    protected String shapeName;
    public Shape(String name)
    {
        this.shapeName = name;
    }
    public abstract double getArea();

    @Override
    public String toString()
    {
        return shapeName+" has area " + getArea();
    }
}
