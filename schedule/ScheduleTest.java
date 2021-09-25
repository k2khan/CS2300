import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleTest
{
    @Test
    public void addTwoMeetingsExpectTrue()
    {
        Event m1 = new Meeting("m1", 0, 10);
        Event m2 = new Meeting("m2", 20, 10);
        Schedule s = new Schedule();
        boolean added = s.add(m1);
        assertTrue(added);
        added = s.add(m2);
        assertTrue("schedule.add() failed on non-overlapping meeting", added);
    }

    @Test
    public void addOverlappingMeetingExpectFalse()
    {
        Event m1 = new Meeting("m1", 0, 100);
        Event m2 = new Meeting("m2", 50, 10);
        Schedule s = new Schedule();
        boolean added = s.add(m1);
        assertTrue(added);
        added = s.add(m2);
        assertFalse("schedule.add() succeeded on overlapping meeting", added);
    }

    @Test
    public void addOverlappingMeetingReverseExpectFalse()
    {
        Event m1 = new Meeting("m1", 0, 100);
        Event m2 = new Meeting("m2", 50, 10);
        Schedule s = new Schedule();
        boolean added = s.add(m2);
        assertTrue(added);
        added = s.add(m1);
        assertFalse("schedule.add() succeeded on overlapping meeting", added);
    }

    @Test
    public void addMeetingAndAppointmentExpectTrue()
    {
        Event m1 = new Meeting("m1", 0, 10);
        Event a1 = new PrivateAppointment("a1", 100, 10);
        Schedule s = new Schedule();
        boolean added = s.add(m1);
        assertTrue(added);
        added = s.add(a1);
        assertTrue("schedule.add() failed on non-overlapping events", added);
    }

    @Test
    public void addAppointmentAndMeetingExpectTrue()
    {
        Event m1 = new Meeting("m1", 0, 10);
        Event a1 = new PrivateAppointment("a1", 100, 10);
        Schedule s = new Schedule();
        boolean added = s.add(a1);
        assertTrue(added);
        added = s.add(m1);
        assertTrue("schedule.add() failed on non-overlapping events", added);
    }

    @Test
    public void addMeetingAndAppointmentExpectFalse()
    {
        Event m1 = new Meeting("m1", 0, 100);
        Event a1 = new PrivateAppointment("a1", 10, 10);
        Schedule s = new Schedule();
        boolean added = s.add(m1);
        assertTrue(added);
        added = s.add(a1);
        assertFalse("schedule.add() succeeded on overlapping events", added);
    }
    
    @Test
    public void addAppointmentAndMeetingExpectFalse()
    {
        Event m1 = new Meeting("m1", 0, 100);
        Event a1 = new PrivateAppointment("a1", 10, 10);
        Schedule s = new Schedule();
        boolean added = s.add(a1);
        assertTrue(added);
        added = s.add(m1);
        assertFalse("schedule.add() succeeded on overlapping events", added);
    }
}
