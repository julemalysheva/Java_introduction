package sem3_OOP_HW.Task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//класс создан с целью отработки обобщений в рамках ДЗ семинара 4 по ООП
public class GenderList<T extends Person> implements Iterable<T>{
    private List<T> tList;
    public GenderList() {
        tList = new ArrayList<T>();
    }
    public void add(T person){
        tList.add(person);
    }

    public T get(Integer index) {
        return tList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> tIterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index<tList.size();
            }

            @Override
            public T next() {
                return tList.get(index++);
            }
        };
        return tIterator;
    }

    @Override
    public String toString() {
        return "GenderList{" +
                " = " + tList.toString() +
                '}';
    }
}
