import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {

  @Test
  public void cardOneTestTrue() {
    Card card = new Card(1, 'D');
    boolean result = card.isAce();
    assertEquals("cardOneTestTrue() " + card, true, result);
  }

  @Test
  public void cardElevenTestTrue() {
    Card card = new Card(11, 'D');
    boolean result = card.isAce();
    assertEquals("cardElevenTestFalse " + card, true, result);
  }

  @Test
  public void cardTestFalse() {
    Card card = new Card(10, 'D');
    boolean result = card.isAce();
    assertEquals("cardTestFalse " + card, false, result);
  }
}
