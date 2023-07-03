import java.security.PublicKey;
import java.time.LocalDate;


public class Program {
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        
        tree.addPerson("Victor Smirnov", Gender.Male, LocalDate.of(1951,2,15));
        tree.addPerson("Marya Smirnova", Gender.Female, LocalDate.of(1955,6,10));

        tree.addPerson("Elena Turova", Gender.Female, LocalDate.of(1978,3,22),
            tree.getPersonByName("Victor Smirnov"),tree.getPersonByName("Marya Smirnova"));
        tree.addPerson("Fedor Turov", Gender.Male, LocalDate.of(1975,10,13));
        
        tree.addPerson("Olga Boyko", Gender.Female, LocalDate.of(1999,5,16),
            tree.getPersonByName("Fedor Turov", tree.getPersonByName("Elena Turova")));
        tree.addPerson("Nika Boyko", Gender.Female, LocalDate.of(2020,4,17),
            tree.getPersonByName("Olga Boyko"));
        tree.addPerson("Ksenya Ryzhova", Gender.Female, LocalDate.of(2009,1,31),
            tree.getPersonByName("Victor Smirnov"));
        tree.addPerson("Lev Boyko", Gender.Male, LocalDate.of(2008,12,25),
            tree.getPersonByName("Olga Boyko"));
        
        System.out.println(tree.getInfo());
    }
}

       