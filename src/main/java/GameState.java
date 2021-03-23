public interface GameState {
    final String PLAYER1 = "player1";
    final String PLAYER2 = "player2";

    void updateScore(TennisGame1 game, int p1, int p2);
    String displayScore();
}
