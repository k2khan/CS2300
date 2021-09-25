package model;
import java.util.Comparator;

public class TodoListStringComparator implements Comparator<TodoItem>{
   int returnValue;

	@Override
	public int compare(TodoItem item1, TodoItem item2) {
      returnValue = item1.getDescription().toUpperCase().compareTo(item2.getDescription().toUpperCase());
      return returnValue;

	}
}

   