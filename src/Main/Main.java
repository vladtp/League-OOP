package Main;

import GameElements.GamePlayer;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GamePlayer gamePlayer = new GamePlayer(gameInput);
        gamePlayer.playGame();
        // gameInput.print();
    }
}
