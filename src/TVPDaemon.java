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
        final Server server = new Server(".");
        System.out.printf("Dossier courant : %n%s", server.lsToString());
        System.out.printf("Une autre version : %n%s%n", server.lsToStringAlternative());
        System.out.printf("Fichier \"RT_TVP.iml\" : %n%s", server.catToString("RT_TVP.iml"));
        System.out.printf("Fichier \"RT2_TVP.iml\" : %n%s", server.catToString("RT2_TVP.iml"));
        System.out.printf("Une autre version du fichier \"RT_TVP.iml\" : %n%s",
                          server.catToStringAlternative("RT_TVP.iml"));

    }
}
