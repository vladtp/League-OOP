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
            if (players.get(i).isAlive()) {
                System.out.println((i + 1) + " " + players.get(i).getHero() + " | hp: "
                        + players.get(i).getHp() + " | x:" + players.get(i).getX() + " y:"
                        + players.get(i).getY());
            } else {
                System.out.println((i + 1) + " " + players.get(i).getHero() + " | DEAD");
            }

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
            // if player i is alive look for other players on the same spot
            if (players.get(i).isAlive()) {
                int x = players.get(i).getX();
                int y = players.get(i).getY();

                for (int j = i + 1; j < numberOfPlayer; ++j) {
                    // if player j is alive and on the same spot as player i, then fight
                    if (players.get(j).isAlive()) {
                        int enemyX = players.get(j).getX();
                        int enemyY = players.get(j).getY();

                        if (x == enemyX && y == enemyY) {
                            attack(players.get(i), players.get(j));

                            // check if any of the players died
                            if (players.get(i).getHp() <= 0) {
                                players.get(i).setAlive(false);
                            }
                            if (players.get(j).getHp() <= 0) {
                                players.get(j).setAlive(false);
                            }
                        }
                    }
                }
            }
        }
    }

    void attack(Player p1, Player p2) {
        // damage done in this round
        int totalDamage1 = p1.getHero().getFirstAbility().damage(p1, p2, map)
                + p1.getHero().getSecondAbility().damage(p1, p2, map);
        int totalDamage2 = p2.getHero().getFirstAbility().damage(p2, p1, map)
                + p2.getHero().getSecondAbility().damage(p2, p1, map);

        // calculate Wizard deflect dmg
        if (p1.getHero() instanceof Wizard) {
            Deflect deflect = new Deflect();
            totalDamage1 += deflect.deflect(totalDamage2, p2.getHero());
        }
        if (p2.getHero() instanceof Wizard) {
            Deflect deflect = new Deflect();
            totalDamage2 += deflect.deflect(totalDamage1, p1.getHero());
        }

        p1.subHp(totalDamage2);
        p2.subHp(totalDamage1);

    }
}
