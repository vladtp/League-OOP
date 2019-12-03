package abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Ignite extends Ability {
    float damageOvertime = 50;
    int damageOvertimePerLevel = 30;
    int duration = 2;

    public Ignite() {
        super.baseDamage = 150;
        super.damagePerLevel = 20;
    }

    public float damage(Player attacker, Player opponent, Map map) {
        // set overtime damage for opponent
        opponent.resetOvertime();
        opponent.setHasDamageOvertime(true);
        opponent.setDamageDuration(duration);
        return baseDamage;
    }

    @Override
    public float getDamageOvertime() {
        return  damageOvertime;
    }

    @Override
    public float modifier(Knight enemy) {
        return 1.2f;
    }

    @Override
    public float modifier(Pyromancer enemy) {
        return 0.9f;
    }

    @Override
    public float modifier(Rogue enemy) {
        return 0.8f;
    }

    @Override
    public float modifier(Wizard enemy) {
        return 1.05f;
    }
}
