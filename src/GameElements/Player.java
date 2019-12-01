package GameElements;

public class Player {
    int x, y;
    Hero hero;
    int level = 0;
    int xp = 0;
    int hp;
    boolean alive = true;

    public Player(String heroType, int x, int y) {
        this.x = x;
        this.y = y;
        this.hero = HeroFactory.getHero(heroType);
        this.hp = hero.getInitialHp();
    }

    @Override
    public String toString() {
        return hero + " " + x + " " + y;
    }
}
