package robson.games.tictactoe.model;

public class Field {
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
