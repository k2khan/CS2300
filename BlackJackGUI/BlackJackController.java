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

    public BlackJackController(Dealer d, Player p, Deck deck, BlackJackTable cardTable)
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

    }

    private void userStand()
    {

    }
    
    public void startGame()
    {

    }


}
