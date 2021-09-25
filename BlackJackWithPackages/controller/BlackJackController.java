package controller;

import model.*;
import java.awt.event.*;
public class BlackJackController
{
    protected Dealer dealer;
    protected Player user;
    protected Deck   deck;
    protected BlackJackUI cardTable;

    protected ActionListener hitListener;
    protected ActionListener standListener;

    public BlackJackController(Dealer d, Player p, Deck deck, BlackJackUI cardTable)
    {
        this.dealer = d;
        this.user = p;
        this.deck = deck;
        this.cardTable = cardTable;

        hitListener = new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               userHit();
            }
        };

        standListener = new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                userStand();
            }
        };

        this.cardTable.setOnHit(hitListener);
        this.cardTable.setOnStand(standListener);
    }

    private void userHit()
    {
        deck.dealOneCard(this.user);
        cardTable.showHand(this.user.getHand(), false);
        if (user.getHand().isBust() || user.getHand().getValue() == 21)
        {
           userStand();
        }
    }

    private void userStand()
    {
        cardTable.disableHit();
        cardTable.disableStand();
        if (!user.getHand().isBust())
        {
            dealer.play(deck);
        }
        cardTable.showHand(this.dealer.getHand(), true);
        Result result = Rules.compareHands(user.getHand(), dealer.getHand());
        boolean playAgain = cardTable.playAgain(result);
        if (playAgain)
        {
            startGame();
        }
    }
    
    public void startGame()
    {
        user.emptyHand();
        dealer.emptyHand();
        cardTable.clearTable();
        cardTable.enableHit();
        cardTable.enableStand();
        for (int i = 0; i < 2; i++)
        {
           deck.dealOneCard(user);
           deck.dealOneCard(dealer);
        }
        cardTable.peekHand(dealer.getHand());
        cardTable.showHand(user.getHand(), false);
    }


}
