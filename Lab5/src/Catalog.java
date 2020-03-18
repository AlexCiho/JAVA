import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;

public class Catalog implements Serializable {

    String location;
    List<Graph> cat;

    Catalog(String loc) {
        this.cat = new ArrayList<Graph>();
        location = loc;
    }

    public void Add(Graph graf) {
        cat.add(graf);
    }

    public void list() {
        for (int i = 0; i < this.cat.size(); i++) {
            System.out.println(this.cat.get(i).toString());
        }
    }

    public void open(String nume) {


        try {
            String local = "";
            for (int i = 0; i < this.cat.size(); i++) {
                if (this.cat.get(i).name == nume) {
                    local = this.cat.get(i).image;
                }
            }

            Desktop d = Desktop.getDesktop();
           // d.open(local);
            d.open(new File(local));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
    public void save(String path) {
        try {
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        try {
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);
            Catalog catalog = (Catalog) ois.readObject();
            this.cat = catalog.cat;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}