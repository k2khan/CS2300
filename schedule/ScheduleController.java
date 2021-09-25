public class ScheduleController
{
    private UserInterface ui;
    private Schedule schedule;
    public ScheduleController(Schedule schedule, UserInterface ui)
    {
        this.schedule = schedule;
        this.ui = ui;
    }

    public void addMeeting(String title, int startTime, int duration)
    {
       Meeting m = new Meeting(title, startTime, duration);
       ui.eventAdded(schedule.add(m));
    }
    
    public void addAppointment(String title, int startTime, int duration)
    {
       PrivateAppointment m = new PrivateAppointment(title, startTime, duration);
       ui.eventAdded(schedule.add(m));
    }

}
