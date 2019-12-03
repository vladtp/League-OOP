package Heroes;

import abilities.Ability;

public interface Hero {
    public int getInitialHp();
    public int getHpPerLevel();
    public char getTerrainBonusType();
    public float getBonus();
    public Ability getFirstAbility();
    public Ability getSecondAbility();
    public float accept(Ability a);
}
