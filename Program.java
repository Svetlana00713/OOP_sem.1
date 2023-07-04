import java.time.LocalDate;

public class Program {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addPerson(new Person("Victor Smirnov", Gender.Male, LocalDate.of(1951,2,15)));
        tree.addPerson(new Person("Marya Smirnova", Gender.Female, LocalDate.of(1955,6,10)));

        tree.addPerson(new Person("Elena Turova", Gender.Female, LocalDate.of(1978,3,22),
            tree.getPersonByName("Victor Smirnov"),tree.getPersonByName("Marya Smirnova")));
        tree.addPerson(new Person("Ksenya Ryzhova", Gender.Female, LocalDate.of(2009,1,31),
            tree.getPersonByName("Victor Smirnov"),tree.getPersonByName(null)));         
        
        tree.addPerson(new Person("Fedor Turov", Gender.Male, LocalDate.of(1975,10,13)));
        
        tree.addPerson(new Person("Olga Boyko", Gender.Female, LocalDate.of(1999,11,16),
            tree.getPersonByName("Fedor Turov"),tree.getPersonByName("Elena Turova")));

        tree.addPerson(new Person("Nika Boyko", Gender.Female, LocalDate.of(2020,5,3),
            tree.getPersonByName(null), tree.getPersonByName("Olga Boyko")));
        tree.addPerson(new Person("Lev Boyko", Gender.Male, LocalDate.of(2018,12,25),
            tree.getPersonByName(null), tree.getPersonByName("Olga Boyko")));

        System.out.println(tree.getInfo());
    }
}
    
    

       