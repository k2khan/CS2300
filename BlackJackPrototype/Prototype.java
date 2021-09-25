import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

public class Prototype
{
    private int frameSize = 400;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this.frameSize = size;

        // top level frame for the game
        mainFrame = new JFrame("Black Jack");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top level panel representing our card table
        JPanel cardTable = new JPanel();
        cardTable.setLayout(new BoxLayout(cardTable, BoxLayout.Y_AXIS));

        // panel to show dealer's hand
        HandPanel dealerHand = new HandPanel("DEALER", frameSize);
        dealerHand.add(new Card(2, Card.Suite.CLUBS), true);
        dealerHand.add(new Card(11, Card.Suite.HEARTS), true);

        // panel to show user's hand
        HandPanel userHand = new HandPanel("YOU", frameSize);
        userHand.add(new Card(14, Card.Suite.DIAMONDS), true);
        userHand.add(new Card(12, Card.Suite.SPADES), true);

        // place dealer's and user's hands on the card table
        cardTable.add(dealerHand);
        cardTable.add(userHand);

        // panel for buttons
        JPanel controlPanel = new JPanel();
        JButton hit = new JButton("Hit");
        JButton stand = new JButton("Stand");
        controlPanel.add(hit);
        controlPanel.add(stand);
        cardTable.add(controlPanel);

        // place card table into the top level frame
        mainFrame.add(cardTable);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    /**
     * Do not remove this meethod
     */
    public JFrame getFrame()
    {
        return mainFrame;
    }
}
