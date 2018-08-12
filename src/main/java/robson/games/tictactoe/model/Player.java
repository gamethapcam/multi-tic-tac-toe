package robson.games.tictactoe.model;

public class Player {
    private Character character;
    private boolean human;

    public Player(Character character) {
        this.character = character;
        this.human = true;
    }

    public Player(Character character, boolean human) {
        this.character = character;
        this.human = human;
    }

    public Character getCharacter() {
        return this.character;
    }

    public boolean isHuman() { return this.human; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return character != null ? character.equals(player.character) : player.character == null;
    }

    @Override
    public int hashCode() {
        return character != null ? character.hashCode() : 0;
    }
}
