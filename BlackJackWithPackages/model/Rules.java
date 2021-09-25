package model;

public class Rules
{
   /**
    * Determines the outcome of the game by comparing h1 to h2
    * The result is reported in terms of h1
    * @param h1 the hand being compared against
    * @param h2 the hand being compared with
    * @return WIN if h1 beats h2, LOOSE if h2 beats h1, TIE if h1 and h2 tie
    */
   public static Result compareHands(Hand h1, Hand h2)
   {
      Result result = Result.WIN;
      // if the value is the same, check if any of the hands is a BlackJack
      if (h1.getValue() == h2.getValue())
      {
          if (h1.isBlackJack() && h2.isBlackJack())
          {
              result = Result.TIE;
          }
          else if (h1.isBlackJack())
          {
              result = Result.WIN;
          }
          else if (h2.isBlackJack())
          {
              result = Result.LOOSE;
          }
          else
          {
              result = Result.TIE;
          }
      }
      else
      {
          if (h1.isBust())
          {
              result = Result.LOOSE;
          }
          else if (h2.isBust())
          {
              result = Result.WIN;
          }
          else if (h1.getValue() > h2.getValue())
          {
              result = Result.WIN;
          }
          else
          {
              result = Result.LOOSE;
          }
      }
      return result;
   }
}
