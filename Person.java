import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        children = new ArrayList<>();
    }

    public void addChild(Person child, Tree Tree) {
        children.add(child);
        if (this.getGenderInfo().equals("Female")) {
            child.setMother(this);
        } else {
            child.setFather(this);
        }
        ((Object) Tree).addPerson(child);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public Person getChild(int index) {
        return children.get(index);
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public String getGenderInfo() {
        return gender.name();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "Имя: '" + name + '\'' +
                ", Пол: " + gender.name() +
                ", Дата рождения: " + dateBirth;
    }
}