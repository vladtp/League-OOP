package Heroes;

import Abilities.Ability;

public class Knight implements Hero {
    private int initialHp = 900;
    private int hpPerLevel = 80;
    private char terrainBonusType = 'L';
    private float bonus = 1.15f;

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
        return null;
    }

    @Override
    public Ability getSecondAbility() {
        return null;
    }

    @Override
    public String toString() {
        return "K";
    }
}
