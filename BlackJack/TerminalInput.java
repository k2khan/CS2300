import java.util.Scanner;
/**
 * User Interface via terminal
 */
public class TerminalInput
{
    public static void userPlays(Deck d, Player p)
    {
        Scanner s = new Scanner(System.in);
        boolean hit = false;
        do
        {
            System.out.println("(h)it or (s)tand?");
            String userInput = s.nextLine();
            if (userInput.startsWith("h") || userInput.startsWith("H"))
            {
                hit = true;
                userHit(d, p);
                if (p.getHand().isBust())
                {
                    return;
                }
            }
            else if (userInput.startsWith("s") || userInput.startsWith("S"))
            {
                return;
            }
        }while(hit);
    }

    private static void userHit(Deck d, Player p)
    {
        d.dealOneCard(p);
        System.out.println("Your hand is");
        p.getHand().reveal();
    }
}
