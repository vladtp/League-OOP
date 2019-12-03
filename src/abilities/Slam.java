package abilities;

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

    @Override
    public float damage(Player attacker, Player opponent, Map map) {
        // make opponent unable to move
        opponent.resetOvertime();
        opponent.setLocked(true);
        opponent.setLockedDuration(duration);
        return baseDamage;
    }
}
