package entities;

import java.util.LinkedList;
import java.util.List;

public class Scoreboard {

    private final List<Game> gamesInProgress;

    public Scoreboard() {
        this.gamesInProgress = new LinkedList<>();
    }

    public List<Game> getGamesInProgress() {
        return gamesInProgress;
    }
}
