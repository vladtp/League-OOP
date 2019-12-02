package main;

import GameElements.GamePlayer;
import GameElements.Player;

import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GamePlayer gamePlayer = new GamePlayer(gameInput);
        ArrayList<Player> players = gamePlayer.playGame();
        OutputWriter outputWriter = new OutputWriter(args[0], args[1]);
        outputWriter.print(players);
    }
}
