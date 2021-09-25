/*
 * Example of how Line2D class can be used
 */

public class Driver
{
   public static void main(String []args)
   {
      Point2D s = new Point2D(1, 1);
      Circle2D c1 = new Circle2D();
      Circle2D c2 = new Circle2D(s, 10);

      System.out.println(c1);
      System.out.println(c2);
   }
}
