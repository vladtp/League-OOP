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
    public int damage(Player attacker, Player opponentm, Map map) {
        if (count == 2) {
            count = 0;
            char tyle = map.getTyle(attacker.getX(), attacker.getY());
            if (tyle == 'W') {
                return (int) 1.5f * baseDamage;
            }
        }
        count++;
        return baseDamage;
    }
}
