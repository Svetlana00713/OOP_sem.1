import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Person> personList;
    public Tree() {
        this(new ArrayList<>());
    }
    public Tree(List<Person> personList) { this.personList = personList; }

    public boolean addPerson(Person person){
        if (person == null) {
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);
            if (person.getFather() != null){
                person.getFather().addChild(person);
            }
            if (person.getMother() != null){
                person.getMother().addChild(person);
            }
            return true;
        }
        return false;
    }

    public Person getPersonByName(String name){
        for (Person person: personList){
            if (person.getName().equalsIgnoreCase(name)){
                return person;
            }
        }
        return null;
    }
    public void addSpouse(Person spouse) { personList.add(spouse);}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(personList.size());
        sb.append(" человек: \n");
        for (Person person: personList){
            sb.append(person.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addPerson(String string, Gender male, LocalDate of) {
    }
}


    
    


    

