import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave(){
        Catalog catalog = new Catalog("Java Resources", "d:/Workspace Facultate/PA-Lab5/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        try {
            CatalogUtil.save(catalog);
        }
        catch (IOException ex)
        {
            System.out.printf("Cannot save catalog: " + ex.toString());
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("d:/Workspace Facultate/PA-Lab5/catalog.ser");
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        }
        catch (InvalidCatalogException ex)
        {
            System.out.printf("Cannot load catalog: " + ex.toString());
        }
        catch (NullPointerException ex)
        {
            System.out.printf("Catalog not found!");
        }
    }
}
