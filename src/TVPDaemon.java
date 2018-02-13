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
        System.out.printf("Dossier courant : \n%s%n", lsToString());
    }

    /** 1.b: list all the files in the current folder. */
    private static String lsToString() {
        final File currentFolder = new File(".");
        final File[] files = currentFolder.listFiles();
        final StringBuilder list = new StringBuilder();
        for (final File file : files) {
            list.append(String.format("- %s%n", file.getName()));
        }
        return list.toString();
    }
}
