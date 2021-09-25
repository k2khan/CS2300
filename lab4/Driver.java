public class Driver
{
    public static void main(String []args)
    {
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(20, 5);
        System.out.println(circle);
        System.out.println(triangle);
        Rectangle rectangle = new Rectangle(20, 5);
        System.out.println(rectangle);
    }
}
