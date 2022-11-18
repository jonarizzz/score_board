package service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ScoreboardService;

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
        Assert.assertEquals(0, scoreboardService.getScoreboard().getGamesInProgress().get(0).getScore()
                .getHomeTeamScore());
        Assert.assertEquals(0, scoreboardService.getScoreboard().getGamesInProgress().get(0).getScore()
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

    @After
    public void after(){
        scoreboardService = null;
    }

}
