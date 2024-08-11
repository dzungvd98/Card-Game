
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

    // Function to get score of each player
    // Input: Object Player
    // Output: if player has 3 same card return 999
    // If player has 3 face 
    @Override
    public int getScore(Player player) {
        if(isThreeOfKind(player)) {
            return THREE_OF_KIND_SCORE;
        }
        int finalScore = 0;
        for(Card card : player.getCardsOnTheHand()) {
            finalScore += getCardValue(card);
        }
        finalScore %= 10;
        return finalScore;
    }

    // Function to deal card for players take part in game
    // Description: Each player will receive alternate card and finish when all player has 3 card 
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

    // Function to find winner of game in list player take part in three poker card game
    // Output: Find the bigest score in many player
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

    // Function to get value of card by Rank at three card game
    // Input: Object card need to find value
    // Output: value of card
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

    // Function to check is player has 3 same rank cards
    // Input: Object Player need to check
    // Output: True if count rank same = 3 else false
    public Boolean isThreeOfKind(Player player) {
        int countSameRank = 0;
        Rank firstCardRank = player.getCardsOnTheHand().get(0).getRank();
        for(Card card : player.getCardsOnTheHand()) {
            if(firstCardRank.equals(card.getRank())) {
                countSameRank ++;
            }
        }
        return countSameRank == MAX_CARDS_EACH_PLAYER;
    }

    // Function to check is player has whole cards is face card
    // Input: Object Player need to check
    // Output: True if whole card is face card else false
    public Boolean isThreeOfFace(Player player) {
        int countFaceCard = 0;
        List<Card> cardsOnHandOfPlayer = player.getCardsOnTheHand();
        for(Card card : cardsOnHandOfPlayer) {
            if(card.getRank() == Rank.JACK || card.getRank() == Rank.QUEEN || card.getRank() == Rank.KING) {
                countFaceCard++;
            }
        }
        return countFaceCard == MAX_CARDS_EACH_PLAYER;
    }

    // public Boolean isPlayerHasThreeConsecutiveCard(Player player) {
        
    // }

    // Function to get value of rank just use to check Consecutive Card
    // Input: Card need to check
    // Output: Jack, Queen, King is 11, 12, 13 and other is like common value by function getCardValue
    public int getValueRankToCheckConsecutiveCard(Card card) {
        switch (card.getRank()) {
            case JACK: return 11;
            case QUEEN: return 12;
            case KING:return 13;
            default: return getCardValue(card);
        }
    }
}
