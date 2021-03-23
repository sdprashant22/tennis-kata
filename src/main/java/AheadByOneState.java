import java.util.Map;

public class AheadByOneState implements GameState {

    private final int p1Score, p2Score;
    final Map<Integer, String> scores = Map.of(
            0,"Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty");

    public AheadByOneState(int p1, int p2) {
        this.p1Score = p1;
        this.p2Score = p2;
    }

    @Override
    public void updateScore(TennisGame1 game, int p1, int p2) {
        if(p1 == p2) {
            game.changeGameState(new EqualScoresState(p1));
        } else {
            game.changeGameState(new AheadByTwoOrMoreState(p1, p2));
        }
    }

    @Override
    public String displayScore() {
        if(!scores.containsKey(p1Score) || !scores.containsKey(p2Score))
            return "Advantage " +  ((p1Score > p2Score) ? PLAYER1 : PLAYER2);
        return scores.get(p1Score)+"-"+scores.get(p2Score);
    }
}
