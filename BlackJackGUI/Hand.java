import java.util.ArrayList;
import java.util.Iterator;

public class Hand implements Iterable<Card>
{
   private ArrayList<Card> cards;
   public Hand()
   {
       cards = new ArrayList<Card>();
   }

   @Override
   public Iterator<Card> iterator()
   {
       return cards.iterator();
   }
   /**
    * Adds the given card to the hand
    * @param c the card to be added to the hand
    **/
   public void add(Card c)
   {
       cards.add(c);
   }

   /**
    * Prints the hand value to the terminal
    */
   public void show()
   {
       for (Card c: cards)
       {
           System.out.println(c);
       }
   }
  
   /**
    * Determines the value of the hand
    * @return the total numeric value of the hand
    */
   public int getValue()
   {
       int value = 0;
       int numAces = 0;
       for (Card c: cards)
       {
           value+=getValue(c);
           if (c.getFace() == Card.Face.ACE)
           {
               numAces++;
           }
       }
       while (value > 21 && numAces > 0)
       {
           numAces--;
           value-=10;
       }

       return value;
   }

   /**
    * The numeric value of the card in the game of BlackJack
    * @return the numeric value of the card
    */
   private int getValue(Card c)
   {
       Card.Face face = c.getFace();
       int v = 0;
       switch (face)
       {
           case ACE:
               v = 11;
               break;
           case KING:
           case QUEEN:
           case JACK:
           case TEN:
               v = 10;
               break;
           default:
               v = face.getValue();
       }
       return v;
   }


   /**
    * Determines if the hand is bust (over 21)
    * @return true if the hand is bust, false otherwise
    */
   public boolean isBust()
   {
       boolean bust = false;
       int value = getValue();
       if (value > 21)
       {
           bust = true;
       }
       return bust;
   }

   /**
    * Determines if the hand is a black jack
    * @return true if the hand is a blackjack, false otherwise
    */
   public boolean isBlackJack()
   {
       boolean result = false;
       if (cards.size() == 2)
       {
           boolean foundAce = false;
           boolean foundTen = false;
           for (Card c: cards)
           {
               if (getValue(c) == 10)
               {
                   foundTen = true;
               }
               else if (c.getFace() == Card.Face.ACE)
               {
                   foundAce = true;
               }
           }
           if (foundAce && foundTen)
           {
               result = true;
           }

       }
       return result;
   }

   /**
    * Prints all cards to the terminal
    */
   public void reveal()
   {
       for (Card c: cards)
       {
          System.out.println(c);
       }
   }

   /**
    * Prints one card to the terminal
    */
   public void showOne()
   {
       System.out.println(cards.get(0));
   }
}
