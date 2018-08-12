package robson.games.tictactoe.io;

public final class Printer {

    private static boolean debug = true;

    public static void info(String message) {
        System.out.println(message);
    }

    public static void debug(String message) {
        if (debug) {
            System.out.println(message);
        }
    }

    public static void warn(String message) {
        System.out.println("Warning: " + message);
    }

    public static void err(String message) {
        System.err.println("Error: " + message);
    }
}
