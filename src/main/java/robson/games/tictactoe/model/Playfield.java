package robson.games.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Playfield {

    private Field[][] fields;
    private List<Path> paths;

    private final int rows;
    private final int columns;

    public Playfield(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.reset();
        this.resetAllPossiblePaths();
    }

    public Field[][] getFields() {
        return this.fields;
    }

    public List<Path> getPaths() { return this.paths; }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    private void reset() {
        this.fields = new Field[this.rows][this.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = new Field(i, j);
            }
        }
    }

    public void select(Player player, int row, int column) {
        if (!fields[row][column].isAssigned()) {
            fields[row][column].assign(player);
        }
    }

    private List<Path> initializeListOfValidPaths(int size) {
        List<Path> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(new Path());
        }
        return result;
    }

    private void resetAllPossiblePaths() {
        this.paths = new ArrayList<>();
        List<Path> rowPaths = initializeListOfValidPaths(this.rows);
        List<Path> columnPaths = initializeListOfValidPaths(this.columns);
        this.paths.addAll(rowPaths);
        this.paths.addAll(columnPaths);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowPaths.get(i).add(fields[i][j]);
                columnPaths.get(j).add(fields[i][j]);
            }
        }

        //check the diagonal possibilities
        if (rows == columns) { //check if it´s a square
            Path leftPath = new Path();
            for (int i = 0; i < rows; i++) {
                leftPath.add(fields[i][i]);
            }
            this.paths.add(leftPath);

            Path rightPath = new Path();
            int rcolumn = columns - 1;
            for (int i = 0; i < rows; i++) {
                rightPath.add(fields[i][rcolumn--]);
            }
            this.paths.add(rightPath);
        }
    }

    public boolean hasWinner() {
        for (Path path : this.paths) {
            if (path.hasWinner()) {
                return true;
            }
        }
        return false;
    }

    public Player getWinner() {
        if (!hasWinner()) {
            throw new IllegalStateException("There´s no winner.");
        }
        for (Path path : this.paths) {
            if (path.hasWinner()) {
                return path.getFields().get(0).getAssigned();
            }
        }
        return null;
    }

    public boolean isDraw() {
        int countBadPaths = 0;
        for (Path path : this.paths) {
            if (path.isBadPath()) {
                countBadPaths++;
            }
        }
        return countBadPaths == this.paths.size();
    }

    public boolean isOver() {
        return hasWinner() || isDraw();
    }

    public boolean hasField(int row, int column) {
        return (row >= 0 && row <= this.rows) && (column >= 0 && column <= this.columns);
    }

    public boolean isFieldAvailable(int row, int column) {
        return hasField(row, column) && !this.getFields()[row][column].isAssigned();
    }

}
