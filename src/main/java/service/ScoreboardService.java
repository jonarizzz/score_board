package service;

import entities.Scoreboard;

public interface ScoreboardService {

    void startNewGame(String homeTeamName, String awayTeamName);
    void updateGameScore(int gameIndex, int homeTeamScore, int awayTeamScore);
    void finishGame(int gameIndex);

    Scoreboard getScoreboard();


}
