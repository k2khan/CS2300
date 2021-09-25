public class Driver
{
    public static void main(String[] args)
    {  
                  
        Plot2D p = new Plot2D();

        Constant2D five = new Constant2D(5);
        p.plot(five);

        Exponential two = new Exponential(2);
        p.plot(two);
    }  
}
