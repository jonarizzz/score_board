package service.impl;

import entities.Game;
import entities.Score;
import entities.Scoreboard;
import entities.Team;
import service.ScoreboardService;
import utils.GamesComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreboardServiceImpl implements ScoreboardService {

    private Scoreboard scoreboard;

    public ScoreboardServiceImpl() {
        this.scoreboard = new Scoreboard();
    }

    public void startNewGame(String homeTeamName, String awayTeamName) {
        Team homeTeam = new Team(homeTeamName);
        Team awayTeam = new Team(awayTeamName);
        Game game = new Game(homeTeam, awayTeam);
        game.start();
        scoreboard.getGamesInProgress().add(game);
    }

    public void updateGameScore(int gameIndex, int homeTeamScore, int awayTeamScore){
        Score score = new Score(homeTeamScore, awayTeamScore);
        scoreboard.getGamesInProgress().get(gameIndex).setScore(score);
    }

    public void finishGame(int gameIndex){
        Game game = scoreboard.getGamesInProgress().get(gameIndex);
        game.finish();
        scoreboard.getGamesInProgress().remove(gameIndex);
    }

    @Override
    public List<Game> getSummaryOfGamesInProgress() {

        return scoreboard.getGamesInProgress()
                .stream()
                .sorted(new GamesComparator().reversed())
                .collect(Collectors.toList());

    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
