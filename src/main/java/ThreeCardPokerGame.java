
import java.util.List;

public class ThreeCardPokerGame extends Game{
    private final int MAX_CARDS_EACH_PLAYER = 3;
    private final int THREE_OF_KIND_SCORE = 999;

    public ThreeCardPokerGame(Deck deck, List<Player> players) {
        super(deck, players);
    }

    public ThreeCardPokerGame() {
        super();
    }

    @Override
    public int getScore(Player player) {
        if(isThreeOfKind(player)) {
            return THREE_OF_KIND_SCORE;
        }
        int finalScore = 0;
        for(Card card : player.getCardsOnTheHand()) {
            finalScore += getCardValue(card);
        }

        if(finalScore != 30) {
            finalScore %= 10;
        }
        return finalScore;
    }

    @Override
    public void dealCards() {
        Deck deck = getDeck();
        List<Player> players = getPlayers();
        for(int  i = 0; i < MAX_CARDS_EACH_PLAYER; i++) {
            for(Player player : players) {
                Card topCard = deck.getTopCard();
                deck.dealTopCard();
                player.receiveCard(topCard);
            }
        }
    }

    @Override
    public Player findWinner() {
        Player winPlayer = getPlayers().get(0);
        for(Player player : getPlayers()) {
            if(getScore(player) > getScore(winPlayer)) {
                winPlayer = player;
            }
        }
        return winPlayer;
    }

    @Override
    public int getCardValue(Card card) {
        switch (card.getRank()) {
            case ACE: return 1;
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

    public Boolean isThreeOfKind(Player player) {
        int countSameRank = 0;
        Rank firstCardRank = player.getCardsOnTheHand().get(0).getRank();
        for(Card card : player.getCardsOnTheHand()) {
            if(firstCardRank.equals(card.getRank())) {
                countSameRank ++;
            }
        }
        if(countSameRank == 3) {
            return true;
        }
        return false;
    }
}
