package Main;

import GameElements.Map;
import GameElements.Player;

import java.util.ArrayList;

public class GameInput {
    private int n, m, p, rounds;
    private Map map;
    private ArrayList<Player> players;
    private ArrayList<String> moves;

    public GameInput(int n, int m, int p, int rounds, Map map, ArrayList<Player> players, ArrayList<String> moves) {
        this.n = n;
        this.m = m;
        this.p = p;
        this.rounds = rounds;
        this.map = map;
        this.players = players;
        this.moves = moves;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getP() {
        return p;
    }

    public int getRounds() {
        return rounds;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    // print input for debugging
    public void print() {
        System.out.println(n + " " + m);
        System.out.println(map);
        System.out.println(p);
        System.out.println(players);
        System.out.println(moves);
    }
}
