package Heroes;

import abilities.Ability;
import abilities.Backstab;
import abilities.Paralysis;

public class Rogue implements Hero {
    private int initialHp = 600;
    private int hpPerLevel = 40;
    private char terrainBonusType = 'W';
    private float bonus = 1.15f;
    private Backstab firstAbility = new Backstab();
    private Paralysis secondAbility = new Paralysis();

    @Override
    public int getInitialHp() {
        return initialHp;
    }

    @Override
    public int getHpPerLevel() {
        return hpPerLevel;
    }

    @Override
    public char getTerrainBonusType() {
        return terrainBonusType;
    }

    @Override
    public float getBonus() {
        return bonus;
    }

    @Override
    public Ability getFirstAbility() {
        return firstAbility;
    }

    @Override
    public Ability getSecondAbility() {
        return secondAbility;
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public float accept(Ability a) {
        return a.modifier(this);
    }
}
