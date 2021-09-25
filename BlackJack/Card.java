public class Card
{
   int value;
   char suite;

   public Card(int v, char s)
   {
       this.value = v;
       this.suite = s;
   }

   /**
    * A check to see if the card is an Ace
    * @return true if card is an ace, false otherwise
    */
   public boolean isAce()
   {
       return value == 11;
   }

   /**
    * A check to see if the card has a value of 10 
    * (either a face card or a 10-card)
    * @return true if the card's value is 10, false otherwise
    */
   public boolean isTen()
   {
       return value >= 10;
   }

   /**
    * The numeric value of the card in the game of BlackJack
    * @return the numeric value of the card
    */
   public int getValue()
   {
       int v = value;
       if (value >11)
       {
           v = 10;
       }
       return v;
   }

   @Override
   public String toString()
   {
       String result = new String();
       switch (value)
       {
           case 11:
               result+="Ace";
               break;
           case 12:
               result+="King";
               break;
           case 13:
               result+="Queen";
               break;
           case 14:
               result+="Jack";
               break;
           default:
               result+=String.valueOf(value);

       }
       result+=" - "+suite;
       return result;
   }
}
