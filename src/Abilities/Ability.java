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

    abstract float modifier(Knight enemy);
    abstract float modifier(Pyromancer enemy);
    abstract float modifier(Rogue enemy);
    abstract float modifier(Wizard enemy);
    public abstract int damage(Player attacker, Player opponent, Map map);
}
