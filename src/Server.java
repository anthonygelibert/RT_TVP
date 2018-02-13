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
final class Server {
    /** Current folder. */
    private String m_pwd;

    /** Create a server in the given initial folder. */
    Server(final String initialFolder) {
        m_pwd = initialFolder;
    }

    /** 1.e: get current directory. */
    String pwd() {
        return new File(m_pwd).getAbsolutePath();
    }

    /** 1.e: change directory. */
    boolean cd(final String folder) {
        // TODO Better implem.
        final File file = new File(folder);
        if (!(file.isDirectory() && file.canExecute())) {
            return false;
        }
        m_pwd = folder;
        return true;
    }

    /** 1.d: create a folder. */
    boolean mkdir(final String nomRepertoire) {
        return new File(nomRepertoire).mkdirs();
    }

    /** 1.d: delete a folder. */
    boolean rmdir(final String nomRepertoire) {
        return new File(nomRepertoire).delete();
    }

    /** 1.b: list all the files in the current folder. */
    String lsToString() {
        final File[] files = new File(m_pwd).listFiles();
        final StringBuilder list = new StringBuilder();
        for (final File file : files) {
            list.append(String.format("- %s%n", file.getName()));
        }
        return list.toString();
    }

    /** 1.b alternative answer: list all the files in the current folder. */
    String lsToStringAlternative() {
        return Arrays.stream(new File(m_pwd).listFiles())
                     .map(e -> String.format("- %s", e.getName()))
                     .collect(Collectors.joining("\n"));
    }

    /** 1.c: read a text file. */
    String catToString(final String filename) {
        final String realFilename = filename.startsWith("/") ? filename : String.format("%s/%s", m_pwd, filename);

        try (final BufferedReader br = new BufferedReader(new FileReader(realFilename))) {
            final StringBuilder result = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append('\n');
            }
            return result.toString();
        }
        catch (final FileNotFoundException ignore) {
            return String.format("Le fichier \"%s\" est inexistant", filename);
        }
        catch (final IOException ignore) {
            return String.format("Erreur de lecture du fichier \"%s\"", filename);
        }
    }

    /** 1.c alternative answer: read a text file. */
    String catToStringAlternative(final String filename) {
        final String realFilename = filename.startsWith("/") ? filename : String.format("%s/%s", m_pwd, filename);

        try (final BufferedReader br = new BufferedReader(new FileReader(realFilename))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
        catch (final FileNotFoundException ignore) {
            return String.format("Le fichier \"%s\" est inexistant", filename);
        }
        catch (final IOException ignore) {
            return String.format("Erreur de lecture du fichier \"%s\"", filename);
        }
    }


    @Override
    public String toString() {
        return String.format("Server{m_pwd='%s'}", m_pwd);
    }
}

