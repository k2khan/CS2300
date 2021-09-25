public class Player
{
   private Hand hand;
   public Player()
   {
       emptyHand();
   }
   public void addToHand(Card c)
   {
       hand.add(c);
   }
   public Hand getHand()
   {
       return hand;
   }
   public void emptyHand()
   {
      hand = new Hand();
   }
}
