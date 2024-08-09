import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));

            }
        }
        shuffleCards();
    }

    public int getNumberCardsRemainingInDeck() {
        if(cards.isEmpty()) {
            return 0;
        }
        return cards.size();
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Card getTopCard() {
        if(cards.size() < 0) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    public void dealTopCard() {
        if(cards.size() > 0) {
            cards.remove(cards.size() - 1);
        }
    }

}
