public class Driver
{
    public static void main(String []args)
    {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer();

        BlackJackTable game = new BlackJackTable(dealer, player);
        game.createTable();
        BlackJackController gameController = new BlackJackController(dealer, player, deck, game);
        gameController.startGame();

    }
}
