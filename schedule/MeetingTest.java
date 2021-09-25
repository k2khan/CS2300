import org.junit.Test;
import static org.junit.Assert.*;

public class MeetingTest
{
    @Test
    public void testMeetingOverlapExpectTrue()
    {
        Meeting m = new Meeting("class", 0, 100);
        boolean overlap = m.conflictsWith(m);
        assertTrue("Meetings with overlap, conflictsWith()", overlap);
    }

    @Test
    public void testMeetingNoOverlapExpectFalse()
    {
        Meeting m = new Meeting("class", 0, 50);
        Meeting m2 = new Meeting("class", 100, 10);
        boolean overlap = m.conflictsWith(m2);
        assertFalse("Meeting with no overlap, conflictsWith()", overlap);
    }
    @Test
    public void testMeetingNoOverlapReversedExpectFalse()
    {
        Meeting m = new Meeting("class", 0, 50);
        Meeting m2 = new Meeting("class", 100, 10);
        boolean overlap = m2.conflictsWith(m);
        assertFalse("Meeting with no overlap, conflictsWith()", overlap);
    }

}
