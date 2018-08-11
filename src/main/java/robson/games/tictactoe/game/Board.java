package robson.games.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final BoardPiece[][] boardPieces;

    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.boardPieces = new BoardPiece[this.rows][this.columns];
        this.reset();
    }

    private void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardPieces[i][j] = new BoardPiece();
            }
        }
    }

    public void select(Player player, int row, int column) {
        if (!boardPieces[row][column].isAssigned()) {
            boardPieces[row][column].assign(player);
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(String.format("[%s]", boardPieces[i][j].isAssigned() ? boardPieces[i][j].getAssigned().getSymbol() : "-"));
            }
            System.out.println();
        }
    }


    private List<BoardValidSlice> initializeListOfValidSlice(int size) {
        List<BoardValidSlice> result = new ArrayList<>(size);
        for (int i = 0; i< size; i++) {
            result.add(new BoardValidSlice());
        }
        return result;
    }

    public List<BoardValidSlice> slice() {
        List<BoardValidSlice> slices = new ArrayList<>();
        List<BoardValidSlice> rowSlices = initializeListOfValidSlice(this.rows);
        List<BoardValidSlice> columnSlices = initializeListOfValidSlice(this.columns);
        slices.addAll(rowSlices);
        slices.addAll(columnSlices);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowSlices.get(i).add(boardPieces[i][j]);
                columnSlices.get(j).add(boardPieces[i][j]);
            }
        }

        //tie the diagonal possibilities
        if (rows == columns) { //check if it´s a perfect square
            BoardValidSlice leftSlice = new BoardValidSlice();
            int lcolumn = 0;
            for (int i = 0; i < rows; i++) {
                leftSlice.add(boardPieces[i][lcolumn++]);
            }
            slices.add(leftSlice);

            BoardValidSlice rightSlice = new BoardValidSlice();
            int rcolumn = columns-1;
            for (int i = 0; i < rows; i++) {
                rightSlice.add(boardPieces[i][rcolumn--]);
            }
            slices.add(rightSlice);
        }


        return slices;
    }


    public static void main(String args[]) {
        Board board = new Board(3,4);
        board.select(new Player("a1"), 0, 0);
        board.select(new Player("a2"), 0, 1);
        board.select(new Player("a3"), 0, 2);
        board.select(new Player("b1"), 1, 0);
        board.select(new Player("b2"), 1, 1);
        board.select(new Player("b3"), 1, 2);
        board.select(new Player("c1"), 2, 0);
        board.select(new Player("c2"), 2, 1);
        board.select(new Player("c3"), 2, 2);

        board.print();

        List<BoardValidSlice> slices = board.slice();



        for (BoardValidSlice slice: slices) {
            System.out.println(slice.hasWinner());
        }

    }
}
