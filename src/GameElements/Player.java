package GameElements;

public class Player {
    int x, y;
    String heroType;

    public Player(String heroType, int x, int y) {
        this.x = x;
        this.y = y;
        this.heroType = heroType;
    }

    @Override
    public String toString() {
        return heroType + " " + x + " " + y;
    }
}
