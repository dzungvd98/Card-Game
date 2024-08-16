import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BlackJackTest {
    private BlackJack game = new BlackJack();
    private List<Player> players = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    
    @Test
    public void testGetCardValue() {
        assertEquals(10, game.getCardValue(new Card(Suit.CLUBS, Rank.KING)));
        assertEquals(3, game.getCardValue(new Card(Suit.CLUBS, Rank.THREE)));
    }

    @Test
    public void testGetIntScore() {
        player1.receiveCard(new Card(Suit.CLUBS, Rank.NINE));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        assertEquals(17, game.getIntScore(player1));

        player2.receiveCard(new Card(Suit.CLUBS, Rank.ACE));
        player2.receiveCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(21, game.getIntScore(player2));
    }
}
