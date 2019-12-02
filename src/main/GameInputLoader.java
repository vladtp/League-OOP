package main;

import GameElements.Player;
import GameElements.Map;
import fileio.FileSystem;

import java.util.ArrayList;

public class GameInputLoader {
    private final String intputPath;
    private final String outputPath;

    public GameInputLoader(String intputPath, String outputPath) {
        this.intputPath = intputPath;
        this.outputPath = outputPath;
    }

    public GameInput load() {
        int n = 0, m = 0, p = 0, rounds = 0;
        ArrayList<Character> maplist = new ArrayList<Character>();
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<String> moves = new ArrayList<String>();
        Map map = Map.getInstance();

        try {
            FileSystem fs = new FileSystem(intputPath, outputPath);

            n = fs.nextInt();
            m = fs.nextInt();
            for (int i = 0; i < n; ++i) {
                String word = fs.nextWord();
                for (int j = 0; j < m; ++j) {
                    maplist.add(word.charAt(j));
                }
            }
            map.setMap(maplist);
            p = fs.nextInt();
            for (int i = 0; i < p; ++i) {
                Player newPlayer = new Player(fs.nextWord(), fs.nextInt(), fs.nextInt());
                players.add(newPlayer);
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                moves.add(fs.nextWord());
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(n, m, p, rounds, map, players, moves);
    }
}
