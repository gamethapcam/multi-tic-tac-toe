package robson.games.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

public class BoardValidSlice {

    private List<BoardPiece> pieces;

    public BoardValidSlice() {
        this.pieces = new ArrayList<>();
    }

    public void add(BoardPiece piece) {
        this.pieces.add(piece);
    }

    public boolean hasWinner() {

        //empty path?
        if (this.pieces == null || this.pieces.isEmpty()) {
            return false;
        }

        //uncompleted path?
        for (BoardPiece piece : this.pieces) {
            if (!piece.isAssigned()) {
                return false;
            }
        }

        //unmatched slice?
        BoardPiece first = pieces.get(0);
        for (BoardPiece piece : this.pieces) {
            if (!piece.getAssigned().getSymbol().equals(first.getAssigned().getSymbol())) {
                return false;
            }
        }

        return true;

    }
}

