import model.*;
import controller.*;
import ui.*;

public class Driver
{
    public static void main(String []args)
    {
        // Create some todo items with different priorities
        TodoItem watchTv = new TodoItem("Watch  my favorite show", 10);
        TodoItem csci2300Homework = new TodoItem("Complete team project", 1);
        TodoItem lunch = new TodoItem("Eat lunch", 1);

        // add items to the list
        TodoList myList = new TodoList(new TodoListStringComparator());
        myList.add(watchTv);
        myList.add(csci2300Homework);
        myList.add(lunch);

        // print the list to the terminal
        for (TodoItem item: myList)
        {
            System.out.println(item);
        }

        // create a graphical user interface for the todo list
        int width = 600;
        TodoListController controller = new TodoListController(myList);
        ListItemsPanel listItems = new ListItemsPanel(controller);
        AddItemPanel addItem = new AddItemPanel(width/2, controller);
        myList.register(listItems);

        TodoListWindow listWindow= new TodoListWindow(width);
        listWindow.add(addItem);
        listWindow.add(listItems);
        listWindow.show();
    }
}
