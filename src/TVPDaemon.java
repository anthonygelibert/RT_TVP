import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        System.out.printf("Une autre version : %n%s%n", lsToStringAlternative());
        System.out.printf("Fichier \"RT_TVP.iml\" : %n%s", catToString("RT_TVP.iml"));
        System.out.printf("Fichier \"RT2_TVP.iml\" : %n%s", catToString("RT2_TVP.iml"));
        System.out.printf("Une autre version du fichier \"RT_TVP.iml\" : %n%s", catToStringAlternative("RT_TVP.iml"));

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

    /** 1.c: read a text file. */
    private static String catToString(final String nomFichier) {
        try (final BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            final StringBuilder result = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append('\n');
            }
            return result.toString();
        }
        catch (final FileNotFoundException ignore) {
            return String.format("Le fichier \"%s\" est inexistant", nomFichier);
        }
        catch (final IOException ignore) {
            return String.format("Erreur de lecture du fichier \"%s\"", nomFichier);
        }
    }

    /** 1.c alternative answer: read a text file. */
    private static String catToStringAlternative(final String nomFichier) {
        try (final BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
        catch (final FileNotFoundException ignore) {
            return String.format("Le fichier \"%s\" est inexistant", nomFichier);
        }
        catch (final IOException ignore) {
            return String.format("Erreur de lecture du fichier \"%s\"", nomFichier);
        }
    }
}
