import java.util.Iterator;
import java.io.FileNotFoundException;

import dataReader.*;
import dataVisualizer.*;
public class Driver
{
    public static void main(String []args)
    {
        FileDataProvider provider = null;
        DataTracker      tracker  = null;

        // Check if data file name was given at command line
        if (args.length < 1)
        {
            System.out.println("Provide data file name as command line argument");
            return;
        }

        try
        {
           provider = new FileDataProvider(args[0]);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        tracker = new DataTracker(provider);

        DataLogPanel dataLog = new DataLogPanel();
        tracker.register(dataLog);

        BarChartPanel barChart = new BarChartPanel();
        tracker.register(barChart);

        MainWindow window = new MainWindow();

        window.addPanel(dataLog);
        window.addPanel(barChart);

        try
        {
            while(true)
            {
               tracker.update();
               Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("INterrupted");
        }
    }
}
