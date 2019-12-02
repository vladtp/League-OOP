package Abilities;

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
        int opponentHp = opponent.getHp();
        int opponentMaxHp = opponent.getMaxHp();
        int damage = Math.round(percent * (Math.min(Math.round(0.3f * opponentMaxHp), opponentHp)));

        return damage;
    }
}
