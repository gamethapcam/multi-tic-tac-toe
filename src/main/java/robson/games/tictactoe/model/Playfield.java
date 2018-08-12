package robson.games.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Playfield {

    private Field[][] fields;
    private List<Slice> slices;

    private final int rows;
    private final int columns;

    public Playfield(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.reset();
        this.slice();
    }

    public Field[][] getFields() {
        return this.fields;
    }

    public List<Slice> getSlices() { return this.slices; }

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
                fields[i][j] = new Field();
            }
        }
    }

    public void select(Player player, int row, int column) {
        if (!fields[row][column].isAssigned()) {
            fields[row][column].assign(player);
        }
    }

    private List<Slice> initializeListOfValidSlice(int size) {
        List<Slice> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(new Slice());
        }
        return result;
    }

    public void slice() {
        this.slices = new ArrayList<>();
        List<Slice> rowSlices = initializeListOfValidSlice(this.rows);
        List<Slice> columnSlices = initializeListOfValidSlice(this.columns);
        this.slices.addAll(rowSlices);
        this.slices.addAll(columnSlices);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowSlices.get(i).add(fields[i][j]);
                columnSlices.get(j).add(fields[i][j]);
            }
        }

        //tie the diagonal possibilities
        if (rows == columns) { //check if it´s a perfect square
            Slice leftSlice = new Slice();
            for (int i = 0; i < rows; i++) {
                leftSlice.add(fields[i][i]);
            }
            this.slices.add(leftSlice);

            Slice rightSlice = new Slice();
            int rcolumn = columns - 1;
            for (int i = 0; i < rows; i++) {
                rightSlice.add(fields[i][rcolumn--]);
            }
            this.slices.add(rightSlice);
        }
    }

    public boolean hasWinner() {
        for (Slice slice : this.slices) {
            if (slice.hasWinner()) {
                return true;
            }
        }
        return false;
    }

    public Player getWinner() {
        if (!hasWinner()) {
            throw new IllegalStateException("There´s no winner.");
        }
        for (Slice slice : this.slices) {
            if (slice.hasWinner()) {
                return slice.getFields().get(0).getAssigned();
            }
        }
        return null;
    }

    public boolean isDraw() {
        int countUnworthy = 0;
        for (Slice slice : this.slices) {
            if (slice.isUnworthy()) {
                countUnworthy++;
            }
        }
        return countUnworthy == this.slices.size();
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
