package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

import model.TodoItem;
import controller.OnAddItemInterface;

public class AddItemPanel extends JPanel
{
    // text field for entering item description
    private JTextField          itemDescription;
    // button that adds the item to the list
    private JButton             addItemButton;
    // a drop down menu for choosing priority
    private JComboBox<Integer>  priorities;
    // chosen priority
    private Integer             selectedPriority;
    // interface to use when the user clicks the addItemButton
    private OnAddItemInterface  onAdd;


    public AddItemPanel(int width, OnAddItemInterface onAdd)
    {
        this.onAdd = onAdd;
        JLabel addItemLabel = new JLabel("What do you need to do?");
        itemDescription = new JTextField(20);

        addItemButton = new JButton("+");
        Integer [] priorityValues = {1, 2, 3, 4, 5};

        selectedPriority = priorityValues[0];

        priorities = new JComboBox<Integer>(priorityValues);
        // set the selected priority from the drop down menu
        priorities.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               selectedPriority = (Integer)priorities.getSelectedItem();
            }
        });

        addItemButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String description = itemDescription.getText();
            TodoItem newItem = new TodoItem(description, selectedPriority);
            onAdd.addItem(newItem);
          }
        });

        this.add(addItemLabel);
        this.add(itemDescription);
        this.add(priorities);
        this.add(addItemButton);
    }

}
