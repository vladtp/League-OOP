package Heroes;

import Abilities.*;

public class Wizard implements Hero {
    private int initialHp = 400;
    private int hpPerLevel = 30;
    private char terrainBonusType = 'D';
    private float bonus = 1.10f;
    private Drain firstAbility = new Drain();
    private Deflect secondAbility = new Deflect();

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
        return "W";
    }

    @Override
    public float accept(Ability a) {
        return a.modifier(this);
    }
}
