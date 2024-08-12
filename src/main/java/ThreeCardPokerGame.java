
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ThreeCardPokerGame extends Game{
    private final int MAX_CARDS_EACH_PLAYER = 3;
    private final int THREE_OF_KIND_SCORE = 999;
    private final int THREE_CONSECUTIVE_CARDS_SCORE = 99;
    private final int THREE_OF_FACE_SCORE = 30;
    

    public ThreeCardPokerGame(Deck deck, List<Player> players) {
        super(deck, players);
    }

    public ThreeCardPokerGame() {
        super();
    }

    // Function to get score of each player
    // Input: Object Player
    // Output: if player has 3 same card return 999
    // If player has 3 consecutive card return 99
    // Player has 3 face card return 30
    @Override
    public int getScore(Player player) {
        if(isPlayerHasThreeOfKindCard(player)) {
            return THREE_OF_KIND_SCORE;
        }

        if(isPlayerHasThreeConsecutiveCard(player)) {
            return THREE_CONSECUTIVE_CARDS_SCORE;
        }

        if(isPlayerHasThreeOfFaceCard(player)) {
            return THREE_OF_FACE_SCORE;
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
    // First Sort Player Score From Big by condition score and value of player in special case like all players have three of kind, all players have consecutive card
    // Then if three of kind or three consecutive card just get big score player, else get all players have same bigest score 
    @Override
    public List<Player> findWinner() {
        List<Player> players = getPlayers();
        List<Player> winnerPlayers = new ArrayList<>();
        players.sort(Comparator.comparingInt(this::getScore).thenComparing(this::getPlayerValueByCardsToFindWinner).reversed());
        int maxScore = getScore(players.get(0));
        
        if(maxScore == THREE_OF_KIND_SCORE || maxScore == THREE_CONSECUTIVE_CARDS_SCORE) {
            winnerPlayers.add(players.get(0));
            return winnerPlayers;
        }

        for(Player player : players) {
            if(getScore(player) == maxScore) {
                winnerPlayers.add(player);
            }
        }
        return winnerPlayers;
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
    public Boolean isPlayerHasThreeOfKindCard(Player player) {
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
    public Boolean isPlayerHasThreeOfFaceCard(Player player) {
        int countFaceCard = 0;
        List<Card> cardsOnHandOfPlayer = player.getCardsOnTheHand();
        for(Card card : cardsOnHandOfPlayer) {
            if(card.getRank() == Rank.JACK || card.getRank() == Rank.QUEEN || card.getRank() == Rank.KING) {
                countFaceCard++;
            }
        }
        return countFaceCard == MAX_CARDS_EACH_PLAYER;
    }

    // Function to check is three card on hand of player is consecutive
    // Input: Object Player need to check
    // Output: return true if three cards are consecutive else false
    public Boolean isPlayerHasThreeConsecutiveCard(Player player) {
        List<Card> cardsOnHandPlayer = player.getCardsOnTheHand();
        this.sortCardsSmallToBigByRank(cardsOnHandPlayer);
        
        // Check is Consecutive is QKA
        if(cardsOnHandPlayer.get(0).getRank() == Rank.ACE 
          && cardsOnHandPlayer.get(1).getRank() == Rank.QUEEN 
          && cardsOnHandPlayer.get(2).getRank() == Rank.KING) {
            return true;
        }
        // Check is value consecutive 
        if(getValueRankToCheckConsecutiveCard(cardsOnHandPlayer.get(0)) + 1 == getValueRankToCheckConsecutiveCard(cardsOnHandPlayer.get(1)) 
           && getValueRankToCheckConsecutiveCard(cardsOnHandPlayer.get(1)) + 1 == getValueRankToCheckConsecutiveCard(cardsOnHandPlayer.get(2))) {
            return true;
        }
        return false;
    }

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

    // Function to sort the card in hand player from small to big
    // Input: List cards need to sort
    // Output: List cards from small to big rank value
    public void sortCardsSmallToBigByRank(List<Card> cards) {
        cards.sort(Comparator.comparingInt(this::getValueRankToCheckConsecutiveCard));
    }


    // Function to find value of player base on three card it is condition to sort List players then find winner
    // Input: Object player
    // Input: if(AAA) or QKA value is 19 else value is RankValue of first Card 
    public int getPlayerValueByCardsToFindWinner(Player player) {
        List<Card> cardsOnHand = player.getCardsOnTheHand();
        Card firstCardOnHand = cardsOnHand.get(0);
        Card secondCardOnHand = cardsOnHand.get(1);
        if(isPlayerHasThreeOfFaceCard(player) && firstCardOnHand.getRank() == Rank.ACE) {
            return 19;
        }

        if(isPlayerHasThreeConsecutiveCard(player)
            && firstCardOnHand.getRank() == Rank.ACE && secondCardOnHand.getRank() == Rank.QUEEN) {
                return 19;
            }

        return getValueRankToCheckConsecutiveCard(firstCardOnHand);
    }

}
