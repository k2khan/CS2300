package model;

public class TodoItem
{
    private String description;
    private int priority;
    public TodoItem(String description, int priority)
    {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription()
    {
        return this.description;
    }
    public int getPriority()
    {
        return this.priority;
    }

    public String toString()
    {

        String result = new String(description);
        result+=": "+priority;
        return result;
    }
}
