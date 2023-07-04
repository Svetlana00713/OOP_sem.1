import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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
    
    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }

        children = new ArrayList<>();
    }

    public Person(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null,null);
    }
    public Person(String name, Gender gender, LocalDate birthDate, Person father, Person mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Person child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Person parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
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
        sb.append(", ");
        sb.append("возраст: ");
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
        String res = "";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("");
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
    

