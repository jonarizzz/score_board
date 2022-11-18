package utils;

import entities.Game;
import entities.Score;

import java.util.Comparator;

public class GamesComparator implements Comparator<Game> {

    @Override
    public int compare(Game firstGame, Game secondGame) {

        Score firstScore = firstGame.getScore();
        Score secondScore = secondGame.getScore();

        int firstGameTotal = firstScore.getHomeTeamScore() + firstScore.getAwayTeamScore();
        int secondGameTotal = secondScore.getHomeTeamScore() + secondScore.getAwayTeamScore();

        return Integer.compare(firstGameTotal, secondGameTotal);
    }

}
