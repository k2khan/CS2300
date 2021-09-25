import org.junit.*;
import static org.junit.Assert.*;

public class DealerTest {
    @Test
    public void dealerTestTrue() {
        Dealer dealer = new Dealer();
        Card card1 = new Card(9, 'D');
        Card card2 = new Card(7, 'D');
        dealer.addToHand(card1);
        dealer.addToHand(card2);
        boolean result = dealer.shouldHit();
        assertEquals("dealerTestTrue() ", true, result);

    }

    @Test
    public void dealerTestFalse() {
        Dealer dealer = new Dealer();
        Card card1 = new Card(9, 'D');
        Card card2 = new Card(8, 'D');
        dealer.addToHand(card1);
        dealer.addToHand(card2);
        boolean result = dealer.shouldHit();
        assertEquals("dealerTestFalse() ", false, result);
    }
}


