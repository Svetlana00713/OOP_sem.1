package FamilyTree;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tree {
    private List<Person> people;

    public Tree() {
        this.people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void allTree() {
        System.out.println(people);
        System.out.println(people.size());
    }

    public void printTree() {
        System.out.println("Family tree:");
        for (Person person : people) {
            if (person.getParents().isEmpty()) {
                printNode(person, 0);
            } 
        }
    }
    
    private void printNode(Person person, int level) {
        String tabs = "";
        for (int i = 0; i < level; i++) {
            tabs += "\t";
        }
    
        String parents = "";
        Set<Person> parentsSet = new HashSet<>();
        for (Person parent : person.getParents()) {
            if(!parentsSet.contains(parent)){
                parents += parent.getName() + " " + parent.getSurname() + " ";
            }
            parentsSet.add(parent);
        }
        if (parentsSet.size() > 1) {
            parents = parents.substring(0, parents.length());
        }
        if (parentsSet.size() < 1) {
            parents = "unknown";
        }
        
        System.out.println(tabs + person.getName() + " " + person.getSurname() + "-parents: (" + parents + ")");
        if (person.getPartner() != null) {
            System.out.println(tabs + person.getPartner());
        } else {
            System.out.println(tabs + "no spouse");
        }
                
        for (Person child : person.getChildren()) {
            printNode(child, level + 1);
        }
    }

    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            
            for (Person person : people) {
                String parents = "";
                Set<Person> parentsSet = new HashSet<>();
                for (Person parent : person.getParents()) {
                    if(!parentsSet.contains(parent)){
                        parents += parent.getName() + " " + parent.getSurname() + " ";
                    }
                    parentsSet.add(parent);
                }
                if (parents.length() > 1) {
                    parents = parents.substring(0, parents.length() - 1);
                }
                if (parents.length() < 1) {
                    parents = "unknown";
                }
                
                String children = "";
                Set<Person> childrenSet = new HashSet<>();
                for (Person child : person.getChildren()) {
                    if(!childrenSet.contains(child)){
                        children += child.getName() + " " + child.getSurname() + ", ";
                    }
                    childrenSet.add(child);
                }
                if (children.length() > 2) {
                    children = children.substring(0, children.length() - 2);
                }
                if (children.length() < 1) {
                    children = "no children";
                }
                
                if (person.getPartner() != null) {
                    writer.write(person.getId() + ": " + person.getName() + " " + person.getSurname() +  " partner: " + person.getPartner()
                    + ", parents: " + parents + ", children: " + children + "\n");
                } else {
                    writer.write(person.getId() + ": " + person.getName() + " " + person.getSurname() +  " partner: " + "no spouse"
                    + ", parents: " + parents + ", children: " + children + "\n");
                }

            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    

