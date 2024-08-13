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
        player1.receiveCard(new Card(Suit.CLUBS, Rank.NINE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.JACK));
        assertEquals(99, game.getIntScore(player1));
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
        assertEquals(true , game.isPlayerHasThreeOfKindCard(player1));
    }

    @Test
    public void testSortListCardsSmallToBig() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);

        Player player1 = new Player();
        player1.receiveCard(new Card(Suit.CLUBS, Rank.ACE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.FOUR));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.THREE));
        game.sortCardsSmallToBigByRank(player1.getCardsOnTheHand());
        assertEquals("ACE OF CLUBS, THREE OF DIAMONDS, FOUR OF HEARTS ", player1.showHandCards());
    } 

    @Test
    public void testIsThreeFaceCard() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);

        Player player1 = new Player();
        player1.receiveCard(new Card(Suit.CLUBS, Rank.NINE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.JACK));
        assertEquals(false , game.isPlayerHasThreeOfFaceCard(player1));
    }

    @Test
    public void testIsThreeConsecutiveCard() {
        players.add(new Player("Shyni"));
        players.add(new Player());
        game.setPlayers(players);

        Player player1 = new Player();
        player1.receiveCard(new Card(Suit.CLUBS, Rank.NINE));
        player1.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.JACK));
        assertEquals(true , game.isPlayerHasThreeConsecutiveCard(player1));
    }

    @Test
    public void testFindWinner() {
        Player player1 = new Player("Dungvd");
        player1.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player1.receiveCard(new Card(Suit.CLUBS, Rank.NINE));
        player1.receiveCard(new Card(Suit.DIAMONDS, Rank.JACK));

        Player player2 = new Player("Shyni");
        player2.receiveCard(new Card(Suit.CLUBS, Rank.ACE));
        player2.receiveCard(new Card(Suit.HEARTS, Rank.KING));
        player2.receiveCard(new Card(Suit.DIAMONDS, Rank.QUEEN));

        Player player3 = new Player("TN");
        player3.receiveCard(new Card(Suit.CLUBS, Rank.EIGHT));
        player3.receiveCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player3.receiveCard(new Card(Suit.DIAMONDS, Rank.EIGHT));

        Player player4 = new Player("PT");
        player4.receiveCard(new Card(Suit.CLUBS, Rank.FIVE));
        player4.receiveCard(new Card(Suit.HEARTS, Rank.FOUR));
        player4.receiveCard(new Card(Suit.DIAMONDS, Rank.SIX));

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        game.setPlayers(players);
        assertEquals("TN", game.findWinner().get(0).getPlayerName());
    }

}
