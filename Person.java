import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Person mother;
    private Person father;
    private Person spouse;
    private List<Person> children;
    private List<Person> parents;
    public Person(String name, int i, Gender gender, LocalDate localDate) {
        this(name, gender, null, null);
    }
    public Person(String name, Gender gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public void addChild(Person child) {
        children.add(child);
        if (gender == Gender.Male) {
            child.setFather(this);
        } else {
            child.setMother(this);
        }
    }
    public void addFather(Person father) {
        this.father = father;
        father.addChild(this);
    }
    public void addMother(Person mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    private Gender getGender() {
        return gender;
    }
    public Person getSpouse() {
        return spouse;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public List<Person> getChildren() { return children; }

    public void setMother(Person mother) {
        this.mother = mother;
        parents.add(mother);
    }
    public void setFather(Person father) {
        this.father = father;
        parents.add(father);
    }

    public void setSpouse(Person spouse) {
        setSpouse(spouse);
        spouse.setSpouse(this);
    }

    public Set<Person> getParents() {
        Set<Person> parents = new HashSet<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("пол: ");
        sb.append(getGender());
        sb.append("возраст");
        sb.append(getAge());
        sb.append(", ");
        sb.append("мать: ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append("отец: ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append("дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate,LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person Person = (Person) obj;
        return Person.getName().equals(getName());
    }
}
    

