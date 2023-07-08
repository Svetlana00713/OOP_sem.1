import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialazable implements Serializable{
    private String fullName;
    private String dateBirth;
    private Serialazable mother;
    private Serialazable father;
    private List<Serialazable> children;

    public Serialazable(String fullName, String dateBirth) {
        this(fullName, dateBirth, null, null);
    }

    public Serialazable(String fullName, String dateBirth, Serialazable mother, Serialazable father) {
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }
    public String getDateBirth() {
        return dateBirth;
    }
    public Serialazable getMother() {
        return mother;
    }
    public Serialazable getFather() {
        return father;
    }
    public List<Serialazable> getChildren() {
        return children;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public void setMother(Serialazable mother) {
        this.mother = mother;
    }
    public void setFather(Serialazable father) {
        this.father = father;
    }
    public void setChildren(List<Serialazable> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Full name:  " + fullName + ", date birth: " + dateBirth + ",  mother:  " + checkMother() 
        + ", father:  " + checkFather() + ", children:  " + checkChildren() + "\n";
    }

    public String checkMother() {
        if (mother == null) return " - ";
        else return mother.getFullName();
    }

    public String checkFather() {
        if (father == null) return " - ";
        else return father.getFullName();
    }

    public String checkChildren() {
        if (children.size() != 0) {
            String childrens = children.get(0).getFullName();
            for (int i = 1; i < children.size(); i++)
                childrens += (", " + getFullName());
            return childrens;
        }
        else return " - ";
    }

    public boolean addChild(Serialazable Person) {
        if (!children.contains(Person)) {
            children.add(Person);
            return true;
        }
        else return false;
    }
    
}
