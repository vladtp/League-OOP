package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Execute extends Ability {
    float percent = 0.2f;
    float percentPerLevel = 0.01f;
    final float maxPercent = 0.4f;

    public Execute() {
        super.baseDamage = 200;
        super.damagePerLevel = 30;
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
        int opponentHp = opponent.getHp();
        int opponentMaxHp = opponent.getMaxHp();
        if (opponentHp < Math.round(percent * opponentMaxHp)) {
            return opponentHp;
        }
        return baseDamage;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        percent = Math.min(percent + percentPerLevel, maxPercent);
    }
}