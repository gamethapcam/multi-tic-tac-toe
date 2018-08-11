package robson.games.tictactoe.game;

public class BoardPiece {
    private Player assigned;

    public void assign(Player player) {
        this.assigned = player;
    }

    public Player getAssigned() {
        return this.assigned;
    }

    public boolean isAssigned() {
        return assigned != null;
    }
}
