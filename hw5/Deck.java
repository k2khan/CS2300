import java.util.ArrayList;
import java.util.Random;

public class Deck
{
   private ArrayList<Card> cards;
   Random randomizer;

   public Deck()
   {
     cards = new ArrayList<Card>();
     for (int i = 1; i <= 14; i++)
     {
         cards.add(new Card(i, 'S'));
         cards.add(new Card(i, 'H'));
         cards.add(new Card(i, 'C'));
         cards.add(new Card(i, 'D'));
     }
     randomizer = new Random();
   }

   /**
    * Shuffles the deck in random order 
    */
   public void shuffle()
   {
       for (int i = 0; i < cards.size(); i++)
       {
           int swap_with = randomizer.nextInt(cards.size());
           Card a = cards.get(i);
           cards.set(i, cards.get(swap_with));
           cards.set(swap_with, a);
       }
   }

   /**
    * Deals one card to the given player
    * @param p the player who gets one card from the top of the deck
    */
   public void dealOneCard(Player p)
   {
       Card c = cards.remove(cards.size()-1);
       p.addToHand(c);
   }

}
