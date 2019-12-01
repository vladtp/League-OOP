package Heroes;

import Abilities.Ability;
import Abilities.Fireblast;

public class Pyromancer implements Hero {
    private int initialHp = 500;
    private int hpPerLevel = 50;
    private char terrainBonusType = 'V';
    private float bonus = 1.25f;
    private Fireblast firstAbility = new Fireblast();

    @Override
    public Ability getFirstAbility() { return firstAbility; }

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
    public String toString() {
        return "P";
    }
}
