package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;


public class TodoListTest {
   TodoItem item1 = new TodoItem("test1", 1);
   TodoItem item2 = new TodoItem("test1", 2);
   TodoItem item3 = new TodoItem("test3", 3);

   @Test
   public void addTestLowFirst() {
      TodoList myList = new TodoList(new TodoItemPriorityComparator());
      myList.add(this.item1);
      myList.add(this.item2);
      Iterator<TodoItem> itr = myList.iterator();
      boolean result = false;
      if (itr.next() == item1) {
         result = true;
      }
      assertEquals("add() adds in the correct order:", true, result);
   }

   @Test
   public void addTestHighFirst() {
      TodoList myList = new TodoList(new TodoItemPriorityComparator());
      myList.add(this.item2);
      myList.add(this.item1);
      Iterator<TodoItem> itr = myList.iterator();
      boolean result = false;
      if (itr.next() == item1) {
         result = false;
      }
      assertEquals("add() adds in the correct order:", false, result);
   }

    @Test
    public void removeTestLow() {
      TodoList myList = new TodoList(new TodoItemPriorityComparator());
      myList.add(this.item1);
      myList.add(this.item2);
      myList.add(this.item3);
      myList.remove(this.item1);
      Iterator<TodoItem> itr = myList.iterator();
      boolean result = false;
      if (itr.next() == item2) {
        result = true;
      }
      assertEquals("remove() removes in the correct order:",true, result);
    }

    @Test
    public void removeHighTest() {
      TodoList myList = new TodoList(new TodoItemPriorityComparator());
      myList.add(this.item1);
      myList.add(this.item2);
      myList.add(this.item3);
      myList.remove(this.item3);
      Iterator<TodoItem> itr = myList.iterator();
      boolean result = false;
      if (itr.next() == item1) {
        result = true;
      }
      assertEquals("remove() removes in the correct order:",true, result);
    }
}