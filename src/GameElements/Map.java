package GameElements;

import java.util.ArrayList;

public class Map {
    ArrayList<Character> map = new ArrayList<Character>();
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

    @Override
    public String toString() {
        return map.toString();
    }
    // TODO method that gets x, y and returns the terrain type
}
