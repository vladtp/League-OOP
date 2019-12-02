package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Backstab extends Ability {
    int count = 0;

    public Backstab() {
        super.baseDamage = 200;
        super.damagePerLevel = 20;
    }

    @Override
    public float modifier(Knight enemy) {
        return 0.9f;
    }

    @Override
    public float modifier(Pyromancer enemy) {
        return 1.25f;
    }

    @Override
    public float modifier(Rogue enemy) {
        return 1.2f;
    }

    @Override
    public float modifier(Wizard enemy) {
        return 1.25f;
    }

    @Override
    public float damage(Player attacker, Player opponentm, Map map) {
        // if it is the third hit, then crit
        if (count == 2) {
            count = 0;
            char tile = map.getTile(attacker.getX(), attacker.getY());
            if (tile == 'W') {
                return (int) 1.5f * baseDamage;
            }
        }
        count++;
        return baseDamage;
    }
}
