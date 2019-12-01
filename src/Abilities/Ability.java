package Abilities;

import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public abstract class Ability {
    int baseDamage;
    int damagePerLevel;
    boolean overtime = false;
    int damageOvertime = 0;
    int damageDuration = 0;
    int damageOvertimePerLevel = 0;

    public boolean isOvertime() {
        return overtime;
    }

    public int getDamageDuration() {
        return damageDuration;
    }

    public int getDamageOvertime() {
        return damageOvertime;
    }

    abstract float modifier(Knight enemy);
    abstract float modifier(Pyromancer enemy);
    abstract float modifier(Rogue enemy);
    abstract float modifier(Wizard enemy);
    public abstract int damage();
}
