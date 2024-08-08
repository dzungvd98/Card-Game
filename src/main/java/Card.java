
public class Card {
    private final Rank rank;
    private final Suit suit;
    
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public String getCardName() {
        return rank + " OF " + suit;
    }

}
