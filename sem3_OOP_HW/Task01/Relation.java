package sem3_OOP_HW.Task01;

import java.util.Objects;

//создаю новую сущность Relation, которая будет иметь два поля - Человек и его отношение.
// эти связи будут собираться в RelationsTree, которое в свою очередь будет полем класса Person.
//сейчас все связи хранятся в Map  - новую сущность формирую только для отработки применения интерфейсов итерации
//по собственным типам. На деле нужно оставить что-то одно - свой RelationsTree или встроенный TreeMap
public class Relation {
    Person person;
    RelationDegree relationDegree;

    public Relation(Person person, RelationDegree relationDegree) {
        this.person = person;
        this.relationDegree = relationDegree;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "person=" + person.getName() + person.birthYear +
                ", relationDegree=" + relationDegree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return Objects.equals(person, relation.person) && relationDegree == relation.relationDegree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, relationDegree);
    }
}
