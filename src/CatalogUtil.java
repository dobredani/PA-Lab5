import javax.print.Doc;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);


        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            Catalog catalog = (Catalog) objectInputStream.readObject();

            objectInputStream.close();
            return catalog;
        }
        catch (IOException ex)
        {
            System.out.printf("Cannot open file: " + ex.toString());
        }
        catch (ClassNotFoundException ex)
        {
            System.out.printf("Invalid data: " + ex.toString());
        }

        return null;
    }

    public static void view(Document document){
        Desktop desktop = Desktop.getDesktop();

        try {
            URI uri = new URI(document.getLocation());
            desktop.browse(uri);
        }
        catch (URISyntaxException ex)
        {
            System.out.printf("Invalid URI: " + ex.toString());
        }
        catch (IOException ex){
            System.out.printf("Invalid URI: " + ex.toString());
        }

    }
}
