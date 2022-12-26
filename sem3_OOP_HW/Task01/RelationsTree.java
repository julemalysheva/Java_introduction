package sem3_OOP_HW.Task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RelationsTree implements Iterable<Relation>, Iterator<Relation>{
    public List<Relation> relations;
    int index;

    public RelationsTree() {
        relations = new ArrayList<>();
        index = 0;
    }

    public void addRelation(Relation relation){
        if (!relations.contains(relation))
            relations.add(relation);
    }

    @Override
    public Iterator<Relation> iterator() {
        return new Iterator<Relation>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < relations.size();
            }

            @Override
            public Relation next() {
                return relations.get(index++);
            }
        };
    }

    @Override
    public boolean hasNext() {
        return index < relations.size();
    }

    @Override
    public Relation next() {
        return relations.get(index++);
    }
}
