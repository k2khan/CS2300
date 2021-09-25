package ui;

import javax.swing.*;
import java.awt.Dimension;

public class TodoListWindow
{
   private JFrame mainFrame;
   private JPanel mainPanel;

   public TodoListWindow(int width)
   {
       mainFrame = new JFrame("Todo List");
       mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainPanel = new JPanel();
       mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
       mainPanel.setPreferredSize(new Dimension(width, width*2/3));
       mainFrame.add(mainPanel);
   }

   public void add(JPanel panel)
   {
       mainPanel.add(panel); 
   }

   public void show()
   {
       mainFrame.pack();
       mainFrame.setVisible(true);
   }
}
