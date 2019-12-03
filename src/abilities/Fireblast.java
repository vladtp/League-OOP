package abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Fireblast extends Ability {
    public Fireblast() {
        super.baseDamage = 350;
        super.damagePerLevel = 50;
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
        return baseDamage;
    }
}
