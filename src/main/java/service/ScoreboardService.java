package service;

import entities.Scoreboard;

public interface ScoreboardService {

    void startNewGame(String homeTeamName, String awayTeamName);

    Scoreboard getScoreboard();


}
