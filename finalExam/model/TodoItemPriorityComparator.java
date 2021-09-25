package model;
import java.util.Comparator;

public class TodoItemPriorityComparator implements Comparator<TodoItem>
{
    /**
     * @return -1 is item1's priority is less than item2's priority
     *         0 if priorities are the same
     *         1 if item1's priority is greater than item2's priority
     */
    @Override
    public int compare(TodoItem item1, TodoItem item2)
    {
        if (item1.getPriority() < item2.getPriority()) {
            return -1;
        }
        else if (item1.getPriority() == item2.getPriority()) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
