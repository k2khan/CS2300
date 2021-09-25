package controller;

import model.TodoList;
import model.TodoItem;

public class TodoListController implements OnAddItemInterface, OnRemoveItemInterface
{
    TodoList list;

    public TodoListController(TodoList list)
    {
        this.list = list;
    }

    public void addItem(TodoItem item)
    {
        this.list.add(item);
    }

    public void removeItem(TodoItem item)
    {
        this.list.remove(item);
    }
}
