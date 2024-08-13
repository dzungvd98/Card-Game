import java.util.ArrayList;
import java.util.List;

public class ThreeCardPokerGameHandler {
    private ThreeCardPokerGame game;

    public ThreeCardPokerGameHandler(int numberOfPlayers) {
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            players.add(player);
        }
        this.game = new ThreeCardPokerGame(players);
    }
    
    // Start game will deal cards for all players 
    public void startGame() {
        System.out.println("Starting Three Card Poker Game...");

        // Deal cards to players
        game.dealCards();
        System.out.println("Cards dealt to all players");
    }

    //Function show cards down is show player name with all cards on hand
    public void showCardsDown() {
        List<Player> players = game.getPlayers();
        int numberPlayer = 1;
        for(Player player : players) {
            System.out.println("------------------------------");
            System.out.println("Player " + numberPlayer + ":" );
            System.out.println("Name: " + player.getPlayerName());
            System.out.println("Cards on hand: " + player.showHandCards());
            System.out.println("Score: " + game.getStringScoreOfPlayer(player));
            numberPlayer++;
        }
    }

    // Function show all name of winners
    public void showWinners() {
        List<Player> listWinners = game.findWinner();
        System.out.println("----------------------------------------");
        System.out.println("Winner: ");
        for(Player player : listWinners) {
            System.out.print(player.getPlayerName() +  " ");
        }
    }

    // Function restart game 
    public void restartGame() {
        game.setDeck(new Deck());
        game.restoreAllHandsCardsOfPlayerForNewGame();
    }
}
