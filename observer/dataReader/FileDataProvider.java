package dataReader;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileDataProvider implements DataProvider
{
    private ArrayList<Pair<String, Integer>> myData;
    private BufferedReader reader;

    public FileDataProvider(String fileName) throws FileNotFoundException
    {
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        this.myData = new ArrayList<Pair<String, Integer>>();
    }

    public Iterator<Pair<String, Integer>> getNewDataIterator()
    {
       myData.clear();
       String line;
       try
       {
       while ((line = reader.readLine()) != null )
       {
           String []lineValues = line.split(",");
           if (lineValues.length >= 2)
           {
               myData.add(new Pair<String, Integer>(lineValues[0].trim(), Integer.parseInt(lineValues[1].trim())));
           }
       }
       }
       catch(IOException e)
       {
           System.out.println(e.getMessage());
       }
       return myData.iterator();
    }

}
