

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


    @Test
    public void testHit() {
        Player player = new Player();
        Deck deck = new Deck();
        List<Card> listCardsInDeck = deck.getCards();
        Card topCard = listCardsInDeck.get(listCardsInDeck.size() - 1);
        player.hit(deck);

        assertEquals(topCard.getCardName(), player.getCardsOnTheHand().get(player.getCardsOnTheHand().size() - 1).getCardName());
        assertEquals(51, deck.getNumberCardsRemainingInDeck());

        player.hit(deck);
        assertEquals(50, deck.getNumberCardsRemainingInDeck());
        
    }


    @Test
    public void testShowHandCards() {
        Player player = new Player();
        Deck deck = new Deck();
        List<Card> listCardsInDeck = deck.getCards();
        Card topCard = listCardsInDeck.get(listCardsInDeck.size() - 1);
        player.hit(deck);
        assertEquals(topCard.getCardName() + " ", player.showHandCards());

        Card topCard2 = listCardsInDeck.get(listCardsInDeck.size() - 1);
        player.hit(deck);
        assertEquals(topCard.getCardName() + ", " + topCard2.getCardName() + " ", player.showHandCards());
    }
   
}
