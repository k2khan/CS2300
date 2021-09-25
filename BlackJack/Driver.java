public class Driver
{
    public static void main(String []args)
    {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer();

        for (int i = 0; i < 2; i++)
        {
           deck.dealOneCard(player);
           deck.dealOneCard(dealer);
        }

        System.out.println("Your hand");
        player.getHand().reveal();

        System.out.println("Dealer shows");
        dealer.getHand().showOne();

        TerminalInput.userPlays(deck, player);

        if (!player.getHand().isBust())
        {
           dealer.play();
        }

        System.out.println("GAME OVER");
        System.out.println("Your hand");
        player.getHand().reveal();
        System.out.println("Dealer's hand");
        dealer.getHand().reveal();

        Result r = Rules.compareHands(player.getHand(), dealer.getHand());
        System.out.println("You "+r);
    }
}
