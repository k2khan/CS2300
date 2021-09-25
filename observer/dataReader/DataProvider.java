package dataReader;

import java.util.Iterator;

public interface DataProvider
{
    public Iterator<Pair<String, Integer>> getNewDataIterator();
}
