import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver implements UserInterface
{
    public static int frameSize = 300;

    private Schedule schedule;
    private JFrame mainFrame;

    public Driver()
    {
        schedule = new Schedule();
        ScheduleController controller = new ScheduleController(schedule, this);


        mainFrame = new JFrame("Add Events");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top level panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        EventPanel eventPanel = new EventPanel();
        mainPanel.add(eventPanel);

        JButton meetingButton = new JButton("Meeting");
        meetingButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.addMeeting(eventPanel.getTitle(), eventPanel.getStartTime(), eventPanel.getDuration());
            }
        });

        JButton appointmentButton = new JButton("Private Appointment");
        appointmentButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.addAppointment(eventPanel.getTitle(), eventPanel.getStartTime(), eventPanel.getDuration());
            }
        });

        mainPanel.add(meetingButton);
        mainPanel.add(appointmentButton);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }   
    public static void main(String []args)
    {
        Driver d = new Driver();
    }

    public void eventAdded(boolean success)
    {
       System.out.println("Event added: "+success);
       System.out.println(schedule);
    }
}
