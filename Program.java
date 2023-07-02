public class Program {
    public static void main(String[] args) {
        Person Victor = new Person(1, "Victor", "Smirnov", 73, Gender.MALE);
        Person Marya = new Person(2, "Marya", "Smirnova", 69, Gender.FEMALE);
        Person Elena = new Person(3, "Elena", "Turova", 45, Gender.FEMALE);
        Person Fedor = new Person(4, "Fedor", "Turov", 47, Gender.MALE);
        Person Olga = new Person(5, "Olga", "Boyko", 25, Gender.FEMALE);
        Person Nika = new Person(6, "Nika", "Boyko", 3, Gender.FEMALE);
        Person Ksenya = new Person(7, "Ksenya", "Ryzhova", 14, Gender.FEMALE);
        Person Lev = new Person(8, "Lev", "Boyko", 4, Gender.MALE);
        
        Victor.addSpouse(Marya);
        Elena.addFather(Victor);
        Elena.addMother(Marya);
        Ksenya.addFather(Victor); 

        Fedor.addSpouse(Elena);
        Olga.addFather(Fedor);
        Olga.addMother(Elena);
        Nika.addMother(Olga); 
        Lev.addMother(Olga); 
       
        Tree tree = new Tree();

        tree.addPerson(Victor);
        tree.addPerson(Marya);
        tree.addPerson(Fedor);
        tree.addPerson(Elena);
        tree.addPerson(Olga);
        tree.addPerson(Nika);
        tree.addPerson(Ksenya);        
        tree.addPerson(Lev);

        tree.printTree(); 
        System.out.println("Family Tree" + "\n");
    }
}

       