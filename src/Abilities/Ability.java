package Abilities;

import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public abstract class Ability {
    int baseDamage;
    int damagePerLever;

    abstract float modifier(Knight enemy);
    abstract float modifier(Pyromancer enemy);
    abstract float modifier(Rogue enemy);
    abstract float modifier(Wizard enemy);
    public abstract int damage();
}
