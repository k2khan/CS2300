package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

import model.TodoItem;
import controller.OnRemoveItemInterface;

public class ItemPanel extends JPanel
{
    JLabel   itemLabel;
    TodoItem item;
    JButton  done;
    OnRemoveItemInterface onRemove;

    public ItemPanel(TodoItem todo, OnRemoveItemInterface onRemove)
    {
        this.item = todo;
        this.onRemove = onRemove;
        done = new JButton("-");

        itemLabel = new JLabel(this.item.getDescription());

        done.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            onRemove.removeItem(item);
          }
        });

        this.add(done);
        this.add(itemLabel);
        this.onRemove = onRemove;
    }

}

