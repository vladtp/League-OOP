package GameElements;

import Heroes.Hero;
import Heroes.HeroFactory;

public class Player {
    private int x, y;
    private Hero hero;
    private int level = 0;
    private int xp = 0;
    private int hp;
    private int maxHp;
    private boolean alive = true;

    private boolean hasDamageOvertime = false;
    private boolean isLocked = false;
    private int damageOvertime;
    private int duration;

    public Player(String heroType, int x, int y) {
        this.x = x;
        this.y = y;
        this.hero = HeroFactory.getHero(heroType);
        this.hp = hero.getInitialHp();
        this.maxHp = hp;
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

    public boolean hasDamageOvertime() {
        return hasDamageOvertime;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isLocked() {
        return isLocked;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getDamageOvertime() {
        return damageOvertime;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return hero + " " + x + " " + y;
    }

    public void printDebug() {
        if (isAlive()) {
            System.out.println(hero + " | hp: " + hp + " | Level: " + level
                    + " (xp: " + xp + ")" + " | x:" + x + " y:" + y);

        } else {
            System.out.println(hero + " | DEAD");
        }
    }

    public String getStats() {
        if (isAlive()) {
            return hero + " " + level + " " + xp + " " + hp + " " + x + " " + y;

        } else {
            return hero + " dead";
        }
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

    // disable overtime spells
    public void resetOvertime() {
        hasDamageOvertime = false;
        isLocked = false;
        duration = 0;
        damageOvertime = 0;
    }

    private void levelUp() {
        level++;
        maxHp += hero.getHpPerLevel();
        hp = maxHp;
        hero.getFirstAbility().levelUp();
        hero.getSecondAbility().levelUp();
    }

    public void addXp(Player looser) {
        int levelLooser = looser.getLevel();
        int extraXp = Math.max(0, (200 - (level - levelLooser) * 40));
        xp += extraXp;

        int xpLevelUp = 250 + level * 50;
        while (xp >= xpLevelUp) {
            levelUp();
            xpLevelUp += 50;
        }
    }
}
