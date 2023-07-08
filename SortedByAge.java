import java.time.LocalDate;
import java.util.Comparator;

public class SortedByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        LocalDate dateO1 = o1.getDateBirth();
        LocalDate dateO2 = o2.getDateBirth();
        int result =  dateO1.getYear() - dateO2.getYear();
        if (result == 0) {
            result = dateO1.getMonthValue() - dateO2.getMonthValue();
            if (result == 0) {
                result = dateO1.getDayOfMonth() - dateO2.getDayOfMonth();
            }
        }
        return result;
    }

    @Override
    public Comparator<Person> reversed() {
        return Comparator.super.reversed();
    }
}

