package Abilities;

import GameElements.Map;
import GameElements.Player;
import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public abstract class Ability {
    int baseDamage;
    int damagePerLevel;

    // return race modifier
    public abstract float modifier(Knight enemy);
    public abstract float modifier(Pyromancer enemy);
    public abstract float modifier(Rogue enemy);
    public abstract float modifier(Wizard enemy);

    // return damage done by attacker on opponent
    public abstract float damage(Player attacker, Player opponent, Map map);
    // improve ability when player levels up
    public float getDamageOvertime() {
        return 0;
    }
    public void levelUp() {
        baseDamage += damagePerLevel;
    }
}
