package abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Drain extends Ability {
    float percent = 0.2f;
    float percentPerLevel = 0.05f;

    public Drain() {
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
        int opponentHp = opponent.getHp();
        int opponentMaxHp = opponent.getMaxHp();
        float damage = percent * (Math.min(0.3f * opponentMaxHp, opponentHp));

        return damage;
    }

    @Override
    public void levelUp() {
        percent += percentPerLevel;
    }
}
