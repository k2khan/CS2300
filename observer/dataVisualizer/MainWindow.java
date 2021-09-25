package dataVisualizer;

import javax.swing.*;
import java.awt.Dimension;

public class MainWindow
{
    private JFrame mainFrame;
    private JPanel mainPanel;

    public MainWindow()
    {
        mainFrame = new JFrame("Data Window");
        mainFrame.setPreferredSize(new Dimension(300,200));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        mainFrame.add(mainPanel);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void addPanel(JPanel panel)
    {
        mainPanel.add(panel);

        mainFrame.pack();
    }
}
