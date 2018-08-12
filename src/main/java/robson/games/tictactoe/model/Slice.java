package robson.games.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Slice {

    private List<Field> fields;

    public Slice() {
        this.fields = new ArrayList<>();
    }

    public void add(Field piece) {
        this.fields.add(piece);
    }

    public List<Field> getFields() {
        return this.fields;
    }

    public boolean hasWinner() {

        //empty path?
        if (this.fields == null || this.fields.isEmpty()) {
            return false;
        }

        //uncompleted path?
        if (!isFull()) {
            return false;
        }

        //unmatched slice?
        Field first = fields.get(0);
        for (Field piece : this.fields) {
            if (!piece.getAssigned().equals(first.getAssigned())) {
                return false;
            }
        }

        return true;

    }

    public boolean isUnworthy() {
        return isFull() && !hasWinner();
    }

    public boolean isFull() {
        for (Field field : this.fields) {
            if (!field.isAssigned()) {
                return false;
            }
        }
        return true;
    }

    public Integer countFreeFields() {
        int result = 0;
        for (Field field : this.fields) {
            if (!field.isAssigned()) {
                result++;
            }
        }
        return result;
    }

    public Field getAFreeField() {
        for (Field field : this.fields) {
            if (!field.isAssigned()) {
                return field;
            }
        }
        return null;
    }

    public boolean containsOnly(Player player) {
        if (this.fields == null || this.fields.isEmpty()) {
            return false;
        }

        for (Field field : this.fields) {
            if (!field.getAssigned().equals(player)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsOnlyOnePlayer() {
        if (this.fields == null || this.fields.isEmpty()) {
            return false;
        }

        Field first = fields.get(0);
        for (Field piece : this.fields) {
            if (!piece.getAssigned().equals(first.getAssigned())) {
                return false;
            }
        }
        return true;
    }
}

