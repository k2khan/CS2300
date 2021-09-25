import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel
{
    private JTextField      title;
    private NumberTextField startTime;
    private NumberTextField duration;

    public EventPanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel labels = new JPanel(new GridLayout(0,1));
        JLabel titleLabel = new JLabel("Enter event title");
        JLabel startTimeLabel = new JLabel("Enter start time");
        JLabel durationLabel = new JLabel("Enter duration");
        labels.add(titleLabel);
        labels.add(startTimeLabel);
        labels.add(durationLabel);

        JPanel inputs = new JPanel(new GridLayout(0,1));
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, 30));
        startTime = new NumberTextField(30);
        duration = new NumberTextField(30);
        inputs.add(title);
        inputs.add(startTime);
        inputs.add(duration);

        add(labels);
        add(inputs);
    }

    public String getTitle()
    {
        return title.getText();
    }

    public int getStartTime()
    {
        if (startTime.getValue() != null)
        {
           return ((Number)startTime.getValue()).intValue();
        }
        else 
        {
            return 0;
        }
    }

    public int getDuration()
    {
        if (duration.getValue() != null)
        {
           return ((Number)duration.getValue()).intValue();
        }
        else
        {
            return 0;
        }
    }

   
}
