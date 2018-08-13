package robson.games.tictactoe.model;

public class Field {

    private final int column;

    private final int row;

    public Field(int column, int row) {
        this.column = column;
        this.row = row;
    }

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

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
