package dataVisualizer;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Set;

import dataReader.*;
public class BarChartPanel extends JPanel implements DataListener
{
    private HashMap<Color, Integer> bars;

    private Color []colors = {Color.BLUE, Color.RED, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.PINK, Color.BLACK};

    private int nextColor;
    public BarChartPanel()
    {
        bars = new HashMap<Color, Integer>();
        nextColor = 0;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(this.bars.size() * 10 + 2, 50);
    }

    @Override
    public void update(DataByKey<String> state)
    {
        bars.clear();
        nextColor = 0;
        Set<String> keys = state.getKeys();
        for (String k: keys)
        {
            Integer value = state.getValue(k);
            if (value != null)
            {
                bars.put(colors[nextColor], value);
                nextColor = ((nextColor+1) % colors.length);
            }
        }
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        if (bars.size() == 0)
        {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (Integer v: bars.values())
        {
            max = Math.max(max, v);
        }

        // paint bars
        int width = (getWidth() / bars.size())-2;
        int x = 1;
        for (Color c: bars.keySet())
        {
            Integer value = bars.get(c);
            int height = (int)((getHeight()-5)*((double)value/max));
            g.setColor(c);
            g.fillRect(x, getHeight() - height, width, height);
            x += (width+2);
        }
    }
}
