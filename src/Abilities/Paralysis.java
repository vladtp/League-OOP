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
    public float modifier(Knight enemy) {
        return 0.8f;
    }

    @Override
    public float modifier(Pyromancer enemy) {
        return 1.2f;
    }

    @Override
    public float modifier(Rogue enemy) {
        return 0.9f;
    }

    @Override
    public float modifier(Wizard enemy) {
        return 1.25f;
    }

    @Override
    public float damage(Player attacker, Player opponent, Map map) {
        // set overtime damage on opponent
        opponent.resetOvertime();
        opponent.setLocked(true);
        opponent.setHasDamageOvertime(true);
        opponent.setDamageOvertime(baseDamage);
        char tile = map.getTile(attacker.getX(), attacker.getY());
        // if attacker is on Wooods tile, then damage lasts more
        if (tile == 'W') {
            opponent.setDuration(extendedDuration);
        } else {
            opponent.setDuration(duration);
        }

        return baseDamage;
    }
}
