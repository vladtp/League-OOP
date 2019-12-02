package main;

import GameElements.Player;

import fileio.FileSystem;
import java.util.ArrayList;

public class OutputWriter {
    private final String intputPath;
    private final String outputPath;

    public OutputWriter(String intputPath, String outputPath) {
        this.intputPath = intputPath;
        this.outputPath = outputPath;
    }

    public void print(ArrayList<Player> players) {
        try {
            FileSystem fileSystem = new FileSystem(intputPath, outputPath);

            for (int i = 0; i < players.size(); ++i) {
                fileSystem.writeWord(players.get(i).getStats());
                fileSystem.writeNewLine();
            }
            fileSystem.writeNewLine();

            fileSystem.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
