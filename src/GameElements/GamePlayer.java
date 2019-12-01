package GameElements;

import Main.GameInput;

import java.util.ArrayList;

public class GamePlayer {
    private GameInput gameInput;

    public GamePlayer(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    public void playGame() {
        int rounds = gameInput.getRounds();
        ArrayList<Player> players = gameInput.getPlayers();

        for (int i = 0; i < rounds; ++i) {
            System.out.println("ROUND: " + (i + 1)); // for debugging
            playRound(players);
        }

        // for debugging
        System.out.println("END");
        for (int i = 0; i < players.size(); ++i) {
            System.out.println((i + 1) + " " + players.get(i).getHero() + " | hp: " + players.get(i).getHp());
        }
    }

    void playRound(ArrayList<Player> players) {
        int numberOfPlayer = gameInput.getP();

        // TODO move each player

        // for debugging
        for (int i = 0; i < numberOfPlayer; ++i) {
            System.out.print((i + 1) + " ");
            players.get(i).printStats();
        }

        for (int i = 0; i < numberOfPlayer - 1; ++i) {
            int x = players.get(i).getX();
            int y = players.get(i).getY();
            for (int j = i + 1; j < numberOfPlayer; ++j) {
                int enemyX = players.get(j).getX();
                int enemyY = players.get(j).getY();

                if (x == enemyX && y == enemyY) {
                    attack(players.get(i), players.get(j));
                }
            }
        }
    }

    void attack(Player p1, Player p2) {
        int totalDamage1 = p1.getHero().getFirstAbility().damage();
        int totalDamage2 = p2.getHero().getFirstAbility().damage();
        p1.subHp(totalDamage2);
        p2.subHp(totalDamage1);
    }
}
