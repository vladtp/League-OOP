package GameElements;

import java.util.ArrayList;

public class Map {
    ArrayList<Character> map = new ArrayList<Character>();
    private int n, m;
    private static Map instance = null;

    private Map() {}

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public ArrayList<Character> getMap() {
        return map;
    }

    public void setMap(ArrayList<Character> map) {
        this.map = map;
    }

    // return type of tile on pos x, y
    public char getTile(int x, int y) {
        return map.get(x * m + y);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
