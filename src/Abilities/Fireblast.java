package Abilities;

import Heroes.Knight;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Wizard;

public class Fireblast extends Ability {
    public Fireblast() {
        super.baseDamage = 350;
        super.damagePerLever = 50;
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
    public int damage() {
        return baseDamage;
    }
}
