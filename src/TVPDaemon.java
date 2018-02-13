import java.io.File;

/**
 * TODO.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class TVPDaemon {
    /**
     * Program entry point.
     *
     * @param args unused
     */
    public static void main(final String... args) {
        System.out.printf("Dossier courant : %n%s", lsToString());
        System.out.printf("Une autre version : %n%s", lsToStringAlternative());
    }

    /** 1.b: list all the files in the current folder. */
    private static String lsToString() {
        final File[] files = new File(".").listFiles();
        final StringBuilder list = new StringBuilder();
        for (final File file : files) {
            list.append(String.format("- %s%n", file.getName()));
        }
        return list.toString();
    }

    /** 1.b alternative answer: list all the files in the current folder. */
    private static String lsToStringAlternative() {
        return Arrays.stream(new File(".").listFiles())
                     .map(e -> String.format("- %s", e.getName()))
                     .collect(Collectors.joining("\n"));
    }

}
