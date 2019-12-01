package Main;

import GameElements.Map;
import GameElements.Player;

import java.util.ArrayList;

public class GameInput {
    int n, m, p, rounds;
    Map map;
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<String> moves = new ArrayList<String>();

    public GameInput(int n, int m, int p, int rounds, Map map, ArrayList<Player> players, ArrayList<String> moves) {
        this.n = n;
        this.m = m;
        this.p = p;
        this.rounds = rounds;
        this.map = map;
        this.players = players;
        this.moves = moves;
    }

    public void print() {
        System.out.println(n + " " + m);
        System.out.println(map);
        System.out.println(p);
        System.out.println(players);
        System.out.println(moves);
    }
}
