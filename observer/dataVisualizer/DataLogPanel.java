package dataVisualizer;

import javax.swing.*;
import java.util.Set;

import dataReader.DataListener;
import dataReader.DataByKey;

public class DataLogPanel extends JPanel implements DataListener
{
    private JTextArea text;

    public DataLogPanel()
    {
        text = new JTextArea();
        text.setText("DATA GOES HERE");
        this.add(text);

    }
    @Override
    public void update(DataByKey<String> data)
    { 
        text.setText("");
        Set<String> keys = data.getKeys();
        for (String k: keys)
        {
            Integer value = data.getValue(k);
            if (value != null)
            {
                text.setText(text.getText() + k + ": " + value + "\n");
            }
        }
        this.revalidate();
    }
}
