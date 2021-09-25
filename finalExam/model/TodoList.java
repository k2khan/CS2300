package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TodoList implements Iterable<TodoItem>, TodoListener
{
    ArrayList<TodoItem> todoList;
    Comparator<TodoItem> compareStrategy;
    ArrayList<TodoListener> todoListeners;


    public TodoList(Comparator<TodoItem> compareStrategy)
    {
        this.todoList = new ArrayList<TodoItem>();
        this.compareStrategy = compareStrategy;
        this.todoListeners= new ArrayList<TodoListener>();
    }

    /**
     * Add an item to the list
     */
    public void add(TodoItem item)
    {
        todoList.add(item);
        Collections.sort(todoList, compareStrategy);
        update(this);
    }

    /**
     * Remove an item from the list
     */
    public void remove(TodoItem item)
    {
        todoList.remove(item);
        update(this);
    }

    @Override
    public void update(TodoList list) {
      notifyListeners();
    }

    public void register(TodoListener listener) {
      this.todoListeners.add(listener);
      listener.update(this);
    }

    private void notifyListeners() {
      for (TodoListener i: this.todoListeners) {
        i.update(this);
      }
    }

    @Override
    public Iterator<TodoItem> iterator()
    {
        return todoList.iterator();
    }
}
