package GameElements;

public class HeroFactory {
    // use getHero to get object of type hero
    public static Hero getHero(String heroType) {
        if (heroType == null) {
            return null;
        }
        if (heroType.equalsIgnoreCase( "K")) {
            return new Knight();
        } else if (heroType.equalsIgnoreCase("P")) {
            return new Pyromancer();
        } else if (heroType.equalsIgnoreCase("R")) {
            return new Rogue();
        } else if (heroType.equalsIgnoreCase("W")) {
            return new Wizard();
        }
        return null;
    }
}
