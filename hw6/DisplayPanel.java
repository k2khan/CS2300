import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel
{
    private JPanel labelPanel;
    private int width;

    public DisplayPanel(String title, int width)
    {
        this.setBackground(new Color(255, 255, 255));
        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(25, 25));
        labelPanel.setOpaque(true);
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setPreferredSize(new Dimension(500, 25));
        titleLabel.setForeground(Color.WHITE);
        labelPanel.add(titleLabel);

        this.add(labelPanel, BorderLayout.NORTH);



    }
}
