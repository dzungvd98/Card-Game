
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private List<Card> cardsOnHand;
    private String playerName;
    
    

    public Player() {
        String uniqueID = UUID.randomUUID().toString();
        playerName = "Player Anonymous " + uniqueID;
        cardsOnHand = new ArrayList<>();
    }

    public Player(String playerName) {
        this.playerName = playerName;
        cardsOnHand = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        this.cardsOnHand.add(card);
    }

    public List<Card> getCardsOnTheHand() {
        return this.cardsOnHand;
    }

    public void hit(Deck deck) {
        if(deck.getCards().size() > 0) {
            Card topCard  = deck.getTopCard();
            cardsOnHand.add(topCard);
            deck.dealTopCard();
        }
    }

    public String showHandCards() {
        String allHandCards = "";
        for(Card card : cardsOnHand) {
            allHandCards += card.getCardName();
            if(!card.equals(cardsOnHand.get(cardsOnHand.size() - 1))) {
                allHandCards += ",";
            }
            allHandCards += " ";
        }
        return allHandCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardsOnHand == null) ? 0 : cardsOnHand.hashCode());
        result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (playerName == null) {
            if (other.playerName != null)
                return false;
        } else if (!playerName.equals(other.playerName))
            return false;
        return true;
    }


    
}
