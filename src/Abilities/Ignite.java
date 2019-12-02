package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Ignite extends Ability {
    int damageOvertime = 50;
    int damageOvertimePerLevel = 30;
    int duration = 2;

    public Ignite() {
        super.baseDamage = 150;
        super.damagePerLevel = 20;
    }

    public int damage(Player attacker, Player opponent, Map map) {
        opponent.resetOvertime();
        opponent.setHasDamageOvertime(true);
        opponent.setDamageOvertime(damageOvertime);
        opponent.setDuration(duration);
        return baseDamage;
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
}
