package lec.Lesson_10.Ex004.V4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Repository<T extends Content> implements Iterator<T>,Iterable<T> {
    List<T> ds;
    int index;

    private String name;

    public Repository(String name) {
        this.ds = new ArrayList<>();
        index = 0;
        this.name = name;
        System.out.printf("\n  >>  %s created\n",this.name);
    }

    public void add(T content) {
        ds.add(content);
    }

    public int count() {
        return ds.size();
    }

    public T get(Integer index) {
        return ds.get(index);
    }

    public void merge(Repository<T> repo){
//        for (int i = 0; i < repo.count(); i++) {
//            this.add(repo.get(i));
        Iterator<T> iterator = repo;
        while (iterator.hasNext()){
            this.add(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return index<ds.size();
    }

    @Override
    public T next() {
        return ds.get(index++);
    }

    // В качестве тренировки реализуйте возможность работы с foreach
    @Override
    public Iterator<T> iterator() {
        Iterator<T> tIterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index<ds.size();
            }

            @Override
            public T next() {
                return ds.get(index++);
            }
        };
        return tIterator;
    }
}
