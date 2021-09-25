import java.util.ArrayList;

public class Schedule
{
    protected ArrayList<Event> events;

    public Schedule()
    {
        events = new ArrayList<Event>();
    }

    public boolean add(Event e)
    {
        boolean foundConflict = false;
        for (Event myEvent: events)
        {
            if (myEvent.conflictsWith(e))
            {
                foundConflict = true;
                break;
            }
        }
        if (!foundConflict)
        {
            events.add(e);
        }
        return !foundConflict;
    }

    @Override
    public String toString()
    {
        String result="";
        for (Event i: events)
        {
            result+=i.toString()+"\n";
        }
        return result;
    }
}
