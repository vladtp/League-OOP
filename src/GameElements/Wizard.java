package GameElements;

public class Wizard implements Hero {
    private int initialHp = 400;
    private int hpPerLevel = 30;
    private char terrainBonusType = 'D';
    private float bonus = 1.10f;

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
        return "W";
    }
}
