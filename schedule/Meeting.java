public class Meeting extends Event
{
    public Meeting(String title, int start, int duration)
    {
        super(title, start, duration);
    }

    @Override
    public boolean conflictsWith(Event e)
    {
        boolean foundConflict = false;
        Event first = e;
        Event second = this;
        if (this.start < e.start)
        {
            first = this;
            second = e;
        }

        if (first.end < second.start)
        {
            foundConflict = true;
        }
        return foundConflict;
    }

    public String toString()
    {
        return "(M)"+super.toString();
    }
}
