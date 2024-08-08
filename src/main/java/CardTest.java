import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {
    
    @Test
    public void testCardCreation() {
        
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        assertEquals(Rank.ACE, card1.getRank());
        assertEquals(Suit.HEARTS, card1.getSuit());

        Card card2 = new Card(Suit.CLUBS, Rank.TEN);
        assertEquals(Rank.TEN, card2.getRank());
        assertEquals(Suit.CLUBS, card2.getSuit());

        Card card3 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        assertEquals(Rank.QUEEN, card3.getRank());
        assertEquals(Suit.DIAMONDS, card3.getSuit());

    }


    @Test
    public void testCardName() {
        
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        assertEquals("FIVE OF SPADES", card1.getCardName());

        Card card2 = new Card(Suit.CLUBS, Rank.TEN);
        assertEquals("TEN OF CLUBS", card2.getCardName());

        Card card3 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        assertEquals("QUEEN OF DIAMONDS", card3.getCardName());
    
    }

    



}
