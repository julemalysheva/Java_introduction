package sem3_OOP_HW.Task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RelationsTree implements Iterable<Relation>{
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
        Iterator<Relation> relationIterator = new Iterator<Relation>() {
            @Override
            public boolean hasNext() {
                return index < relations.size();
            }

            @Override
            public Relation next() {
                return relations.get(index++);
            }
        };
        return  relationIterator;
    }
}
