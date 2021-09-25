package ui;

import javax.swing.*;
import java.awt.*;

import model.TodoItem;
import model.TodoList;
import model.TodoListener;
import controller.OnRemoveItemInterface;

public class ListItemsPanel extends JPanel implements TodoListener 
{
    OnRemoveItemInterface onRemove;
    public ListItemsPanel(OnRemoveItemInterface onRemove)
    {
        this.onRemove = onRemove;
        this.setLayout(new GridBagLayout());
    }

    /**
     * Refresh the view of the list in the user interface
     */
    @Override
    public void update(TodoList list)
    {
        // clear the old list
        this.removeAll();

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth=1;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 0.5;
        int row = 0;

        // display each TodoItem in the list using ItemPanel
        for (TodoItem i: list)
        {
            ItemPanel p = new ItemPanel(i, onRemove);
            c.gridx = 1;
            c.gridy = GridBagConstraints.RELATIVE;
            this.add(p, c);
            row++;
        }

        // make the new list show up
        this.revalidate();
        this.repaint();
    }
}
