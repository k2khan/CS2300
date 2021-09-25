package dataReader;

import java.util.HashMap;
import java.util.Set;

public class DataByKey<K>
{
    private HashMap<K,Integer> dataMap;

    public DataByKey()
    {
        dataMap = new HashMap<K,Integer>(200);
    }

    public Integer getValue(K key)
    {
        return dataMap.get(key);
    }

    public Set<K> getKeys()
    {
        return dataMap.keySet();
    }

    protected void add(K key, Integer value)
    {
        Integer currentValue = getValue(key);
        if (currentValue != null)
        {
            dataMap.replace(key, currentValue + value);
        }
        else
        {
            dataMap.put(key, value);
        }
    }
}
