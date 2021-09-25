public abstract class Event
{
    protected String title;
    protected int start;
    protected int end;

    public Event(String title, int start, int duration)
    {
        this.title = title;
        this.start = start;
        this.end = start+duration;
    }

    public abstract boolean conflictsWith(Event e);

    @Override
    public String toString()
    {
        return title+": start ("+start+"), end ("+end+")";
    }
}
