import java.awt.event.*;
public class BlackJackController
{
    protected Dealer dealer;
    protected Player user;
    protected Deck   deck;
    protected BlackJackTable cardTable;

    protected ActionListener hitListener;
    protected ActionListener standListener;
    protected ActionListener betListener;

    public BlackJackController(Dealer d, Player p, Deck deck, BlackJackTable cardTable) {
        this.dealer = d;
        this.user = p;
        this.deck = deck;
        this.cardTable = cardTable;

        hitListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               userHit();
            }
        };

        standListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                userStand();
            }
        };

        this.cardTable.setOnHit(hitListener);
        this.cardTable.setOnStand(standListener);
    }

    private void userHit()
    {
        if (user.getHand().getValue() != 21) {
            deck.dealOneCard(user);
        }
        cardTable.showHand(user.getHand(), false);
        if (user.getHand().isBust() | user.getHand().getValue() == 21) {
            userStand();
        }
    }

    private void userStand() {
        cardTable.disableHit();
        cardTable.disableStand();
        dealer.play(deck);
        cardTable.showHand(dealer.getHand(),true);

        Result r = Rules.compareHands(user.getHand(),dealer.getHand());
        if (cardTable.playAgain(r)) {
            startGame();
        }
    }
    
    public void startGame() {
        cardTable.clearTable();
        cardTable.enableHit();
        cardTable.enableStand();

        this.deck = new Deck();
        deck.shuffle();
        user.emptyHand();
        dealer.emptyHand();

        deck.dealOneCard(user);
        deck.dealOneCard(user);
        cardTable.showHand(user.getHand(), false);

        deck.dealOneCard(dealer);
        deck.dealOneCard(dealer);
        cardTable.peekHand(dealer.getHand());
    }


}
