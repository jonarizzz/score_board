package entities;

import java.sql.Timestamp;

public class Game {

    private final Team homeTeam;
    private final Team awayTeam;

    private Score score;
    private Timestamp gameStarted;
    private Timestamp gameFinished;

    private boolean isFinished;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void start(){
        this.isFinished = false;
        this.score = new Score();
        this.gameStarted = new Timestamp(System.currentTimeMillis());
    }

    public void finish(){
        this.isFinished = true;
        this.gameFinished = new Timestamp(System.currentTimeMillis());
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return score;
    }
}
