
public class TriangleTest
{
    public static void isEquilateralExpectTrue()
    {
        Triangle t = new Triangle(10,10,10);
        boolean result = t.isEquilateral();
        if (!result)
        {

            System.out.println("ERROR in Triangle.isEquilateral "+t+": expected true, received "+result);
        }
    }

    public static void isIsoscelesExpectTrue() {
      Triangle t = new Triangle(5,4, 5);
      boolean result = t.isIsosceles();
      if (!result) {
        System.out.println("Error in Triangle.isIsosceles " + t + ": expected true, received " +result);
      }
    }

    public static void isTriangleExpectFalse() {
      Triangle t = new Triangle(0, 0, 0);
      boolean result = t.isEquilateral();
      if (result) {
        System.out.println("Error in Triangle.isEquilateral " + t + ": expected false, received " + result);
      }
    }

    public static void main(String []args)
    {
        isEquilateralExpectTrue();
        isIsoscelesExpectTrue();
        isTriangleExpectFalse();
    }
}
