package GameElements;

import Heroes.Hero;
import Heroes.HeroFactory;

public class Player {
    private int x, y;
    private Hero hero;
    private int level = 0;
    private int xp = 0;
    private int hp;
    private boolean alive = true;
    private boolean hasDamageOvertime = false;
    private int damageOvertime;
    private int damageDuration;

    public Player(String heroType, int x, int y) {
        this.x = x;
        this.y = y;
        this.hero = HeroFactory.getHero(heroType);
        this.hp = hero.getInitialHp();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Hero getHero() {
        return hero;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return alive;
    }

    public void subHp(int damage) {
        hp -= damage;
    }

    public void setHasDamageOvertime(boolean hasDamageOvertime) {
        this.hasDamageOvertime = hasDamageOvertime;
    }

    public void setDamageOvertime(int damageOvertime) {
        this.damageOvertime = damageOvertime;
    }

    public void setDamageDuration(int damageDuration) {
        this.damageDuration = damageDuration;
    }

    public boolean hasDamageOvertime() {
        return hasDamageOvertime;
    }

    public int getDamageOvertime() {
        return damageOvertime;
    }

    public int getDamageDuration() {
        return damageDuration;
    }

    @Override
    public String toString() {
        return hero + " " + x + " " + y;
    }

    public void printStats() {
        System.out.println(hero + " | hp: " + hp + " | x:" + x + " y:" + y);
    }

    public void moveUp() {
        --x;
    }
    public void moveDown() {
        ++x;
    }
    public void moveLeft() {
        --y;
    }
    public void moveRight() {
        ++y;
    }
}
