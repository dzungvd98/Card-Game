

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerHand() {
        
        Player player = new Player();
        Card card = new Card(Suit.CLUBS, Rank.ACE);
        player.receiveCard(card);
        List<Card> hand = player.getCardsOnTheHand();

        assertEquals(card.getCardName(), hand.get(0).getCardName());
    
    }

   
}
