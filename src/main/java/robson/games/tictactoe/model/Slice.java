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
            if (!piece.getAssigned().getCharacter().equals(first.getAssigned().getCharacter())) {
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
}

