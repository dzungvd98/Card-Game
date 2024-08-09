import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ThreeCardPokerGameTest {
    ThreeCardPokerGame game = new ThreeCardPokerGame();
    List<Player> players = new ArrayList<>();
    

    @Test
    public void testDealCards() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);
        game.dealCards();
        for(Player player : players) {
            assertEquals(3, player.getCardsOnTheHand().size());
        }
    }

    @Test
    public void testGetScore() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);
        game.dealCards();

        Player player1 = new Player();
        player1.receiveCard(new Card(Suit.CLUBS, Rank.THREE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.NINE));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.JACK));
        assertEquals(2, game.getScore(player1));
    }

    @Test
    public void testIsThreeOfKind() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);

        Player player1 = new Player();
        player1.receiveCard(new Card(Suit.CLUBS, Rank.THREE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.THREE));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.THREE));
        assertEquals(true , game.isThreeOfKind(player1));
        

        
    }
}
