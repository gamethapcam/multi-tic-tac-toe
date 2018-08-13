package robson.games.tictactoe.ui;

import robson.games.tictactoe.utils.NumberUtils;

class InputValue {

    private static final String INPUT_SPLIT_CHARACTER = ",";

    private static final int INPUT_ARGUMENTS_SIZE = 2;

    private final String input;

    private boolean valid;

    private int lineValue;

    private int columnValue;

    InputValue(String input) {
        this.input = input;
        eval();
    }

    private void eval() {
        if (input == null || input.isEmpty() || !input.contains(INPUT_SPLIT_CHARACTER)) {
            this.valid = false;
            return;
        }
        String[] values = this.input.split(INPUT_SPLIT_CHARACTER);

        if (values.length != INPUT_ARGUMENTS_SIZE) {
            this.valid = false;
            return;
        }

        if (!NumberUtils.isNumeric(values[0]) || !NumberUtils.isNumeric(values[1])) {
            this.valid = false;
            return;
        }

        this.lineValue = Integer.valueOf(values[0]);
        this.columnValue = Integer.valueOf(values[1]);
        this.valid = true;
    }

    int getLineValue() {
        return this.lineValue;
    }

    int getColumnValue() {
        return this.columnValue;
    }

    boolean isValid() {
        return this.valid;
    }
}
