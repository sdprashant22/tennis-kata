import java.util.Map;

public class AheadByTwoOrMoreState implements GameState {

    private final int p1Score, p2Score;
    final Map<Integer, String> scores = Map.of(
            0,"Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty");

    public AheadByTwoOrMoreState(int p1, int p2) {
        this.p1Score = p1;
        this.p2Score = p2;
    }

    @Override
    public void updateScore(TennisGame1 game, int p1, int p2) {
        if(Math.abs(p1-p2) == 1) {
            game.changeGameState(new AheadByOneState(p1, p2));
        } else {
            game.changeGameState(new AheadByTwoOrMoreState(p1, p2));
        }
    }

    @Override
    public String displayScore() {
        if(!scores.containsKey(p1Score) || !scores.containsKey(p2Score))
            return "Win for " +  ((p1Score > p2Score) ? PLAYER1 : PLAYER2);
        return scores.get(p1Score)+"-"+scores.get(p2Score);
    }
}
