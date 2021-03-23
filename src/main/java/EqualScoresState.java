import java.util.Map;

public class EqualScoresState implements GameState {

    private final int score;
    final Map<Integer, String> scores = Map.of(
            0,"Love-All",
            1, "Fifteen-All",
            2, "Thirty-All");

    public EqualScoresState() {
        this.score = 0;
    }

    public EqualScoresState(int score) {
        this.score = score;
    }

    @Override
    public void updateScore(TennisGame1 game, int p1, int p2) {
        game.changeGameState(new AheadByOneState(p1, p2));
    }

    @Override
    public String displayScore() {
        return scores.getOrDefault(score, "Deuce");
    }
}
