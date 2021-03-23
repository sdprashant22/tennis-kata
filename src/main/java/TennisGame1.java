public class TennisGame1 implements TennisGame {
    private GameState gameState;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.gameState = new EqualScoresState();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
        gameState.updateScore(this, m_score1, m_score2);
    }

    public String getScore() {
        return gameState.displayScore();
    }

    public void changeGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getPlayer1Name() {
        return this.player1Name;
    }

    public String getPlayer2Name() {
        return this.player2Name;
    }
}
