import java.util.Iterator;
import java.util.List;

public class ThreeIterator implements Iterator<Person> {
    private int index;
    private final List<Person> personList;

    public ThreeIterator(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public Person next() {
        return personList.get(index++);
    }
}

