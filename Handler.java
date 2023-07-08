import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Handler implements Writable, Serializable {

    private void writeObject(ObjectOutputStream obj) throws IOException {
        obj.defaultWriteObject();
    }

    private void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException {
        obj.defaultReadObject();
    }

    @Override
    public void save(Tree tree) {
        try (FileOutputStream fos = new FileOutputStream("FamilyTree.out")){
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(tree);
            out.close();
            System.out.println("Saved\n");
        } catch (Exception e) {
            System.out.println("Oops!");
        }
    }

    @Override
    public Object read() {
        try (FileInputStream fis = new FileInputStream("Tree.out")){
            Tree tree = new Tree();
            ObjectInputStream in = new ObjectInputStream(fis);
            tree = (Tree) in.readObject();
            in.close();
            System.out.println("Read\n");
            return tree;
        } catch (Exception e) {
            System.out.println("Oops!");
            return null;
        }
    }
}