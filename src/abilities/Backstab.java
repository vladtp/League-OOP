package abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Backstab extends Ability {
    private final static int COUNT_START = 2;
    private final static float KNIGHT_MODIFIER = 0.9f;
    private final static float PYROMANCER_MODIFIER = 1.25f;
    private final static float ROGUE_MODIFIER = 1.2f;
    private final static float WIZARD_MODIFIER = 1.25f;
    private int count = COUNT_START;

    public Backstab() {
        super.baseDamage = 200;
        super.damagePerLevel = 20;
    }

    @Override
    public float modifier(final Knight enemy) {
        return KNIGHT_MODIFIER;
    }

    @Override
    public float modifier(final Pyromancer enemy) {
        return PYROMANCER_MODIFIER;
    }

    @Override
    public float modifier(final Rogue enemy) {
        return ROGUE_MODIFIER;
    }

    @Override
    public float modifier(final Wizard enemy) {
        return WIZARD_MODIFIER;
    }

    @Override
    public float damage(Player attacker, Player opponentm, Map map) {
        // if it is the third hit, then crit
        if (count == 2) {
            count = 0;
            char tile = map.getTile(attacker.getX(), attacker.getY());
            if (tile == 'W') {
                return 1.5f * baseDamage;
            }
        }
        count++;
        return baseDamage;
    }
}
