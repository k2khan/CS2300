public class Dealer extends Player
{

   public void play(Deck d)
   {
      while (this.shouldHit()) {
         dealerHit(d, this);
      }
   }

   public static void dealerHit(Deck d, Dealer p) {
      d.dealOneCard(p);
   }

   public boolean shouldHit() {
      int shouldHit = 16;
      if (this.getHand().getValue() <= shouldHit) {
         return true;
      }
      return false;
   }

}
