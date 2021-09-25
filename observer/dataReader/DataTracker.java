package dataReader;

import java.util.Iterator;
import java.util.ArrayList;

public class DataTracker
{
    private DataByKey<String> values;
    private DataProvider provider;
    private ArrayList<DataListener> listeners;

    public DataTracker(DataProvider provider)
    {
        this.provider = provider;
        this.values = new DataByKey<String>();
        this.listeners = new ArrayList<DataListener>();
    }

    public void update()
    {
        Iterator<Pair<String, Integer>> newDataIterator = this.provider.getNewDataIterator();
        boolean stateChanged = false;
        while(newDataIterator.hasNext())
        {
            Pair<String, Integer> v = newDataIterator.next();
            this.values.add(v.getKey(), v.getValue());
            stateChanged = true;
        }

        if (stateChanged)
        {
           notifyListeners();
        }
    }

    public void register(DataListener listener)
    {
        this.listeners.add(listener);
        listener.update(this.values);
    }

    private void notifyListeners()
    {
        for (DataListener l: this.listeners)
        {
            l.update(this.values);
        }
    }
}
