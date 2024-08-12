
import java.util.List;

public abstract class Game {
    private Deck deck;
    private List<Player> players;

    public Game() {
        deck = new Deck();
    }

    public Game(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }
    
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public abstract int getScore(Player player);
    
    public abstract void dealCards();
    
    public abstract List<Player> findWinner();

    public abstract int getCardValue(Card card);

    

}
