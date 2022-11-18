package service.impl;

import entities.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ScoreboardService;

import java.util.List;

public class ScoreBoardServiceTest {

    private ScoreboardService scoreboardService;

    @Before
    public void init(){
        scoreboardService = new ScoreboardServiceImpl();
        scoreboardService.startNewGame("homeTeam1", "awayTeam1");
        scoreboardService.startNewGame("homeTeam2", "awayTeam2");
        scoreboardService.startNewGame("homeTeam3", "awayTeam3");
        scoreboardService.startNewGame("homeTeam4", "awayTeam4");
        scoreboardService.startNewGame("homeTeam5", "awayTeam5");
    }

    @Test
    public void testStartingTheGameFirst(){
        Assert.assertEquals(5, scoreboardService.getScoreboard().getGamesInProgress().size());
    }

    @Test
    public void testStartingTheGameSecond(){
        int gameIndex = 2;
        Assert.assertEquals(0, scoreboardService.getScoreboard().getGamesInProgress().get(gameIndex).getScore()
                .getHomeTeamScore());
        Assert.assertEquals(0, scoreboardService.getScoreboard().getGamesInProgress().get(gameIndex).getScore()
                .getAwayTeamScore());
    }

    @Test
    public void testUpdateScore(){
        int gameIndex = 2;
        scoreboardService.updateGameScore(2, 7, 2);
        Assert.assertEquals(7,
                scoreboardService.getScoreboard().getGamesInProgress().get(gameIndex).getScore().getHomeTeamScore());
        Assert.assertEquals(2,
                scoreboardService.getScoreboard().getGamesInProgress().get(gameIndex).getScore().getAwayTeamScore());
    }

    @Test
    public void testFinishingTheGame(){
        int gameIndex = 2;
        scoreboardService.finishGame(gameIndex);
        Assert.assertEquals(4, scoreboardService.getScoreboard().getGamesInProgress().size());

    }

    @Test
    public void testSummaryOfGamesInProgress(){
        scoreboardService.updateGameScore(0, 5, 0);
        scoreboardService.updateGameScore(1, 5, 5);
        scoreboardService.updateGameScore(2, 5, 2);
        scoreboardService.updateGameScore(3, 3, 2);
        scoreboardService.updateGameScore(4, 1, 1);

        List<Game> sortedGames = scoreboardService.getSummaryOfGamesInProgress();

        Assert.assertEquals(10, sortedGames.get(0).getScore().getAwayTeamScore() +
                sortedGames.get(0).getScore().getHomeTeamScore());

        Assert.assertEquals(2, sortedGames.get(4).getScore().getAwayTeamScore() +
                sortedGames.get(4).getScore().getHomeTeamScore());

        Assert.assertEquals(0, sortedGames.get(2).getScore().getAwayTeamScore());
    }

    @After
    public void after(){
        scoreboardService = null;
    }

}
