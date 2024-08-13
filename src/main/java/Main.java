public class Main {
    
    public static void main(String[] args) {
        ThreeCardPokerGameHandler game = new ThreeCardPokerGameHandler(3);
        game.startGame();
        game.showCardsDown();
        game.showWinners();
    }
}
