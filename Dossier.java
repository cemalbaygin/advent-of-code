import java.util.ArrayList;
import java.util.List;

/**
 *
 * Day7
 */
public class Dossier{
    String name;
    int size;
    List<Dossier> sousDossier;

    public Dossier(String name) {
        this.name = name;
        this.size=0;
        sousDossier = new ArrayList<>();
    }
}