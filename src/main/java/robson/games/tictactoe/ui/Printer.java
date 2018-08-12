package robson.games.tictactoe.ui;

public final class Printer {

    public static void info(String message) {
        System.out.println(message);
    }

    public static void warn(String message) {
        System.out.println("Warning: "+message);
    }

    public static void err(String message) {
        System.err.println("Error: "+message);
    }
}
