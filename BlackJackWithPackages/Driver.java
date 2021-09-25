import model.*;
import view.*;
import controller.*;

public class Driver
{
    public static void main(String []args)
    {
        Deck deck = new Deck();
        deck.shuffle();

        HumanPlayer player = new HumanPlayer(100);
        Dealer dealer = new Dealer();

        BlackJackTable game = new BlackJackTable(dealer, player);
        game.createTable();
        BlackJackController gameController = new BlackJackController(dealer, player, deck, game);
        gameController.startGame();        
    }
}
