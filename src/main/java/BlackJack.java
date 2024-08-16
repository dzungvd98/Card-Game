import java.util.List;

public class BlackJack extends Game{

    @Override
    public int getIntScore(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIntScore'");
    }

    @Override
    public void dealCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dealCards'");
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


    
}
