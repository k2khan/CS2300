package view;

import model.*;
import controller.BlackJackUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionListener;

public class BlackJackTable implements BlackJackUI
{
    public static int frameSize = 400;

    private Dealer dealer;
    private Player user;
    private HandPanel dealerHand;
    private HandPanel userHand;
    private JButton   hit;
    private JButton   stand;
    private JFrame    mainFrame;

    public BlackJackTable(Dealer d, Player p)
    {
        this.dealer = d;
        this.user = p;
    }

    public void peekHand(Hand hand)
    {
       Card c = hand.iterator().next();
       dealerHand.add(c, true);
       dealerHand.add(c, false);
    }
    public void showHand(Hand hand, boolean isDealer)
    {
        HandPanel panel = isDealer ? dealerHand: userHand;
        panel.clearCards();
        for (Card c: hand)
        {
            panel.add(c, true);
        }
    }

    public void createTable()
    {
        // top level container for the game
        mainFrame = new JFrame("Black Jack");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top level panel representing our card table
        JPanel cardTable = new JPanel();
        cardTable.setLayout(new BoxLayout(cardTable, BoxLayout.Y_AXIS));

        // panel to show dealer's hand
        this.dealerHand = new HandPanel("DEALER", frameSize);

        // panel to show user's hand
        this.userHand = new HandPanel("YOU", frameSize);
        //userHand.add(new Card(12, Card.Suite.SPADES), true);


        // place dealer's and user's hands on the card table
        cardTable.add(this.dealerHand);
        cardTable.add(this.userHand);

        
        // panel for buttons
        JPanel controlPanel = new JPanel();
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        controlPanel.add(hit);
        controlPanel.add(stand);
        cardTable.add(controlPanel);


        mainFrame.add(cardTable);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void setOnHit(ActionListener l)
    {
        hit.addActionListener(l);
    }
    public void setOnStand(ActionListener l)
    {
        stand.addActionListener(l);
    }

    public void disableHit()
    {
        hit.setEnabled(false);
    }
    public void disableStand()
    {
        stand.setEnabled(false);
    }

    public void clearTable()
    {
        dealerHand.clearCards();
        userHand.clearCards();
    }

    public void enableHit()
    {
        hit.setEnabled(true);
    }
    public void enableStand()
    {
        stand.setEnabled(true);
    }

    public boolean playAgain(Result r)
    {
        int choice = JOptionPane.showConfirmDialog(mainFrame, "You "+r+". Play again?", "Results", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
}
