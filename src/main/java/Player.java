
import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> cardsOnHand;
    
    

    public Player() {
        cardsOnHand = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        this.cardsOnHand.add(card);
    }

    public List<Card> getCardsOnTheHand() {
        return this.cardsOnHand;
    }

}
