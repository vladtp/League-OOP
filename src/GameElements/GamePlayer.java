package GameElements;

import Abilities.Deflect;
import Heroes.Wizard;
import Main.GameInput;

import java.util.ArrayList;

public class GamePlayer {
    private GameInput gameInput;
    private Map map;

    public GamePlayer(GameInput gameInput) {
        this.gameInput = gameInput;
        map = gameInput.getMap();
        map.setN(gameInput.getN());
        map.setM(gameInput.getM());
    }

    public void playGame() {
        int rounds = gameInput.getRounds();
        ArrayList<Player> players = gameInput.getPlayers();
        ArrayList<String> moves = gameInput.getMoves();

        for (int i = 0; i < rounds; ++i) {
            System.out.println("ROUND: " + (i + 1)); // for debugging
            playRound(players, moves.get(i));
        }

        // for debugging
        System.out.println("END");
        for (int i = 0; i < players.size(); ++i) {
            System.out.print(i + 1 + " ");
            players.get(i).printStats();
        }
    }

    void playRound(ArrayList<Player> players, String moves) {
        int numberOfPlayer = gameInput.getP();

        // for debugging
        for (int i = 0; i < numberOfPlayer; ++i) {
            System.out.print((i + 1) + " ");
            players.get(i).printStats();
        }

        for (int i = 0; i < numberOfPlayer; ++i) {
            Player player = players.get(i);

            if (player.isAlive()) {
                // chech if player has damage overtime
                if (player.hasDamageOvertime()) {
                    player.subHp(player.getDamageOvertime());
                    player.setDuration(player.getDuration() - 1);

                    if (player.getHp() <= 0) {
                        player.setAlive(false);
                    }
                }

                // check if player can move and move him
                if (!player.isLocked()) {
                    char move = moves.charAt(i);
                    if (move == 'U') {
                        player.moveUp();
                    } else if (move == 'D') {
                        player.moveDown();
                    } else if (move == 'L') {
                        player.moveLeft();
                    } else if (move == 'R') {
                        player.moveRight();
                    }
                } else {
                    player.setDuration(player.getDuration() - 1);
                }
            }
        }

        // check if any 2 players need to fight
        for (int i = 0; i < numberOfPlayer - 1; ++i) {
            Player p1 = players.get(i);

            // if player i is alive look for other players on the same spot
            if (p1.isAlive()) {
                int x = p1.getX();
                int y = p1.getY();

                for (int j = i + 1; j < numberOfPlayer; ++j) {
                    Player p2 = players.get(j);
                    // if player j is alive and on the same spot as player i, then fight
                    if (p2.isAlive()) {
                        int enemyX = p2.getX();
                        int enemyY = p2.getY();

                        if (x == enemyX && y == enemyY) {
                            attack(p1, p2);

                            // check if any of the players died
                            if (p1.getHp() <= 0) {
                                p1.setAlive(false);
                                p2.addXp(p1);
                            }
                            if (p2.getHp() <= 0) {
                                p2.setAlive(false);
                                p1.addXp(p2);
                            }
                        }
                    }
                }
            }
        }
    }

    void attack(Player p1, Player p2) {
        // initial dmg done by p1 on each ability
        float p1A1InitialDmg = p1.getHero().getFirstAbility().damage(p1, p2, map);
        float p1A2InitialDmg = p1.getHero().getSecondAbility().damage(p1, p2, map);

        // initial dmg done by p2 on each ability
        float p2A1InitialDmg = p2.getHero().getFirstAbility().damage(p2, p1, map);
        float p2A2InitialDmg = p2.getHero().getSecondAbility().damage(p2, p1, map);

        // each player terrain modifier
        float terrainModifier1 = terrainModifier(p1);
        float terrainModifier2 = terrainModifier(p2);

        // p1 damage after terrain modifier on each spell
        float p1A1AfterTerrainModifier = p1A1InitialDmg * terrainModifier1;
        float p1A2AfterTerrainModifier = p1A2InitialDmg * terrainModifier1;

        // p2 damage after terrain modifier on each spell
        float p2A1AfterTerrainModifier = p2A1InitialDmg * terrainModifier2;
        float p2A2AfterTerrainModifier = p2A2InitialDmg * terrainModifier2;

        // calculate deflect dmg if p1 is wizard
        if (p1.getHero() instanceof Wizard) {
            Deflect deflect = new Deflect();

            p1A2InitialDmg = deflect.deflect(p2A1AfterTerrainModifier + p2A2AfterTerrainModifier,
                    p2.getHero());
            p1A2AfterTerrainModifier = p1A2InitialDmg * terrainModifier1;
        }

        // calculate deflect dmg if p2 is wizard
        if (p2.getHero() instanceof Wizard) {
            Deflect deflect = new Deflect();

            p2A2InitialDmg = deflect.deflect(p1A1AfterTerrainModifier + p1A2AfterTerrainModifier,
                    p1.getHero());
            p2A2AfterTerrainModifier = p2A2InitialDmg * terrainModifier2;
        }

        // p1 race modifier for each ability
        float p1A1RaceModifier = p2.getHero().accept(p1.getHero().getFirstAbility());
        float p1A2RaceModifier = p2.getHero().accept(p1.getHero().getSecondAbility());

        // p2 race modifier for each ability
        float p2A1RaceModifier = p1.getHero().accept(p2.getHero().getFirstAbility());
        float p2A2RaceModifier = p1.getHero().accept(p2.getHero().getSecondAbility());

        // p1 final dmg on each spell
        int p1A1FinalDmg = Math.round(p1A1AfterTerrainModifier * p1A1RaceModifier);
        int p1A2FinalDmg = Math.round(p1A2AfterTerrainModifier * p1A2RaceModifier);

        // p2 final dmg on each spell
        int p2A1FinalDmg = Math.round(p2A1AfterTerrainModifier * p2A1RaceModifier);
        int p2A2FinalDmg = Math.round(p2A2AfterTerrainModifier * p2A2RaceModifier);

        // final dmg
        int p1FinalDmg = p1A1FinalDmg + p1A2FinalDmg;
        int p2FinalDmg = p2A1FinalDmg + p2A2FinalDmg;


        p1.subHp(Math.round(p2FinalDmg));
        p2.subHp(Math.round(p1FinalDmg));

    }

    // return terrain modifier for player p
    private float terrainModifier(Player p) {
        char tile = map.getTile(p.getX(), p.getY());
        char bonustile = p.getHero().getTerrainBonusType();

        if (tile == bonustile) {
            return p.getHero().getBonus();
        } else {
            return 1f;
        }
    }
}
