package GameElements;

public class Rogue implements Hero {
    private int initialHp = 500;
    private int hpPerLevel = 50;
    private char terrainBonusType = 'V';
    private float bonus = 1.25f;

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
        return "R";
    }
}
