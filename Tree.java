import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable{
    private Writable writable;
    private List<Person> PersonList;

    public Tree() {
        this(new ArrayList<>());
    }

    public Tree(List<Person> PersonList) {
        this.PersonList = PersonList;
    }

    public List<Person> getPersonList() {
        return PersonList;
    }
    public void setPersonList(List<Person> PersonList) {
        this.PersonList = PersonList;
    }

    public Writable getWritable() {
        return writable;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean add(Person Person) {
        if (Person == null) return false;
        if (!PersonList.contains(Person)) {
            PersonList.add(Person);
 
          if (Person.getMother() != null) Person.getMother().addChild(Person);
            if (Person.getFather() != null) Person.getFather().addChild(Person Child, getFather);
            return true;
        }
        return false;
    }

        public Person getByName(String name) {
        for (Person Person : PersonList) {
            if (Person.getName() == name)
                return Person;
        }
        return null;
    }

    @Override
    public String toString() {
        String list = "";
        for (Person Person : PersonList)
            list += Person.toString();
        return list;
    }
} 

    
