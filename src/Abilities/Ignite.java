package Abilities;

import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Ignite extends Ability {
    public Ignite() {
        super.baseDamage = 150;
        super.damagePerLevel = 20;
        super.damageOvertime = 50;
        super.damageDuration = 2;
        super.overtime = true;
        super.damageOvertimePerLevel = 30;
    }
    public int damage() {
        return baseDamage;
    }
    public int damageOvertime() {
        return damageOvertime;
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
}
