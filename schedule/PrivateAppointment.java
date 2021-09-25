public class PrivateAppointment extends Event
{
    public PrivateAppointment(String title, int start, int duration)
    {
        super(title, start, duration);
    }

    @Override
    public boolean conflictsWith(Event e)
    {
       return false;
    }

    @Override
    public String toString()
    {
        return "(P)"+super.toString();
    }
}
