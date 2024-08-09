import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class DeckTest {
    @Test
    public void testDeckCreation() {
        
        Deck deck1 = new Deck();
        List<Card> cards = deck1.getCards();
        assertEquals(cards.size(), deck1.getNumberCardsRemainingInDeck()); 
        assertEquals(52, deck1.getNumberCardsRemainingInDeck()); 
    }

    @Test 
    public void testDeckDealTopCards() {
        Deck deck1 = new Deck();
        deck1.dealTopCard();
        assertEquals(51, deck1.getNumberCardsRemainingInDeck());
    }

}

