package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Slam extends Ability {
    int duration = 1;
    public Slam() {
        super.baseDamage = 100;
        super.damagePerLevel = 40;
    }
    @Override
    float modifier(Knight enemy) {
        return 1.2f;
    }

    @Override
    float modifier(Pyromancer enemy) {
        return 0.9f;
    }

    @Override
    float modifier(Rogue enemy) {
        return 0.8f;
    }

    @Override
    float modifier(Wizard enemy) {
        return 1.05f;
    }

    @Override
    public int damage(Player attacker, Player opponent, Map map) {
        opponent.resetOvertime();
        opponent.setLocked(true);
        opponent.setDuration(duration);
        return baseDamage;
    }
}
