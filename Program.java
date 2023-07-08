import java.time.LocalDate;

public class Program{
    private static final Person[] PersonList = null;
    public static void main(String[] args) {
        Tree tree = new Tree();
        Handler Handler = new Handler();

        tree.add(new Person("Victor Smirnov", Gender.Male, LocalDate.of(1951, 03, 10)));
        tree.add(new Person("Marya Smirnova", Gender.Female, LocalDate.of(1952, 12, 15)));  
        tree.add(new Person("Elena Turova", Gender.Female, LocalDate.of(1973, 05, 04))), getByName("Victor Smirnov", getByName("Maria Smirnova"));   
        tree.add(new Person("Ksenia Ryzhova", Gender.Female, LocalDate.of(2000, 04, 14)),getByName("Victor Smirnov"));     
        tree.add(new Person("Fedor Turov", Gender.Male, LocalDate.of(1971, 03, 11)));
        tree.add(new Person("Olga Boyko", Gender.Female, LocalDate.of(1993, 05, 31))), getByName("Fedor Turov", getByName("Elena Turova"));    
        tree.add(new Person("Nika Boyko", Gender.Female, LocalDate.of(2013, 12, 25))), getByName("Olga Boyko"));
        tree.add(new Person("Lev Boyko", Gender.Male, LocalDate.of(2012, 11, 03))),getByName("Olga Boyko"));    
        System.out.println(tree.toString());

        Handler.save(tree);

        System.out.println(Handler.read());
    }

    private static Tree GetPersonByName(String string) {
        return null;
    }
    public Person getByName(String name){
        for (Person person: PersonList){
            if (person.getName().equalsIgnoreCase(name)){
                return person;
            }
            return null;
        }
    }
}
        
    

    