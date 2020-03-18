import java.io.Serializable;

public class Graph implements Serializable {
    String name;
    String description;
    String image;

    Graph(String name, String description, String image) {
        try {
            if (name.isEmpty() || description.isEmpty() || image.isEmpty()) {
                throw new MyException("Can't be empty");
            }else {
                this.name = name;
                this.description = description;
                this.image = image;
            }
        }catch (MyException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public String toString() {
        return name + description;
    }
}
