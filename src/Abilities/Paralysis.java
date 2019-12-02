package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Paralysis extends Ability {
    int duration = 3;
    int extendedDuration = 6;

    public Paralysis() {
        super.baseDamage = 40;
        super.damagePerLevel = 10;
    }

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
        opponent.resetOvertime();
        opponent.setLocked(true);
        opponent.setHasDamageOvertime(true);
        opponent.setDamageOvertime(baseDamage);
        char tyle = map.getTyle(attacker.getX(), attacker.getY());
        if (tyle == 'W') {
            opponent.setDuration(extendedDuration);
        } else {
            opponent.setDuration(duration);
        }

        return baseDamage;
    }
}
