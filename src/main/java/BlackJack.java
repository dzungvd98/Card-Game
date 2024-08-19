import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BlackJack extends Game{
    private final int START_CARD_OF_EACH_PLAYER = 2;
    @Override
    public int getIntScore(Player player) {
        int finalScore = 0;
        List<Card> cardsOnHand = player.getCardsOnHand();
        List<Card> cardsACEOnHand = new ArrayList<>();
        sortCardsSmallToBigByRank(cardsOnHand);
        int countCard = 0;
        for(Card card : cardsOnHand) {
            if(card.getRank() != Rank.ACE) {
                finalScore += getCardValue(card);
            } else {
                cardsACEOnHand.add(card);
            }
            countCard++;
        }

        for(int i = 0; i < cardsACEOnHand.size(); i++) {
            if(finalScore + 11 <= 21 && cardsOnHand.size() < 4) {
                finalScore += 11;
            } else if(finalScore + 10 <= 21 && cardsOnHand.size() < 4) {
                finalScore += 10;
            } else {
                finalScore += 1;
            }
        }

        return finalScore;
    }

    @Override
    // Function to deal card for each user start with 2 cards
    public void dealCards() {
        Deck deck = getDeck();
        List<Player> players = getPlayers();
        for(int i = 0; i < START_CARD_OF_EACH_PLAYER; i++) {
            for(Player player : players) {
                Card topCard = deck.getTopCard();
                deck.dealTopCard();
                player.receiveCard(topCard);
            }
        }
    }

    @Override
    public List<Player> findWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findWinner'");
    }

    @Override
    public int getCardValue(Card card) {
        switch (card.getRank()) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: 
            case JACK: 
            case QUEEN: 
            case KING: return 10;
            default: return 0;
        }
    }

    // Function to get card rank value to compare card or sort card I want min to max and ACE is last of list because ACE has so much value (1, 10, 11)
    // Input: Card object
    // Output: Number of value rank
    public int getRankValueToSortCard(Card card) {
        switch (card.getRank()) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: 
            case JACK: 
            case QUEEN: 
            case KING: return 10;
            case ACE: return 11;
            default: return 0;
        }
    }

    // Function to sort list from small to big ACE is biggest
    // Input: List cards need so sort
    // Output: List cards sorted by rank value small to big 
    public void sortCardsSmallToBigByRank(List<Card> cards) {
        cards.sort(Comparator.comparingInt(this :: getRankValueToSortCard));
    }




    
}
