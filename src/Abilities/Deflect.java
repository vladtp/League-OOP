package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.*;

public class Deflect extends Ability {
    float percent  = 0.35f;
    float percentPerLevel = 0.02f;
    final float maxPercent = 0.7f;

    public Deflect() {
    }

    @Override
    public float modifier(Knight enemy) {
        return 1.4f;
    }

    @Override
    public float modifier(Pyromancer enemy) {
        return 1.3f;
    }

    @Override
    public float modifier(Rogue enemy) {
        return 1.2f;
    }

    @Override
    public float modifier(Wizard enemy) {
        return 1f;
    }

    @Override
    public float damage(Player attacker, Player opponent, Map map) {
        return 0;
    }

    // return deflect damage
    public float deflect(float damage, Hero hero) {
        if (hero instanceof Wizard) {
            return 0;
        }
        return percent * damage;
    }

    @Override
    public void levelUp() {
        percent = Math.min(percent + percentPerLevel, maxPercent);
    }
}
