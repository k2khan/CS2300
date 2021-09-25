public class Dealer extends Player
{
   public void play(Deck d)
   {
      Hand h = this.getHand();
      while (h.getValue() <= 16)
      {
          d.dealOneCard(this);
      }
   }
}
