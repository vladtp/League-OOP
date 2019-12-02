package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.*;

public class Deflect extends Ability {
    float percent  = 0.35f;
    float percentPerLevel = 0.02f;
    final float maxPercent = 0.7f;

    @Override
    float modifier(Knight enemy) {
        return 0;
    }

    @Override
    float modifier(Pyromancer enemy) {
        return 0;
    }

    @Override
    float modifier(Rogue enemy) {
        return 0;
    }

    @Override
    float modifier(Wizard enemy) {
        return 0;
    }

    @Override
    public int damage(Player attacker, Player opponent, Map map) {
        return 0;
    }

    public int deflect(int damage, Hero hero) {
        if (hero instanceof Wizard) {
            return 0;
        }
        return Math.round(percent * damage);
    }
}
