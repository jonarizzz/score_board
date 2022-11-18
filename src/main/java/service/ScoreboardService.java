package service;

import entities.Game;
import entities.Scoreboard;

import java.util.List;

public interface ScoreboardService {

    void startNewGame(String homeTeamName, String awayTeamName);

    void updateGameScore(int gameIndex, int homeTeamScore, int awayTeamScore);

    void finishGame(int gameIndex);

    List<Game> getSummaryOfGamesInProgress();

    Scoreboard getScoreboard();

}
