package sem3_OOP_HW.Task01;

public class Man extends Person implements FamilyTree{
    private final String GENDER;
    {
        GENDER = "male";
    }

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
        this.beauty = r.nextInt(10,30);
        this.power = r.nextInt(30,50);
    }

    @Override
    public String toString() {
        return GENDER + " " + super.toString();
    }

//добавлены условия compareTo при добавлении детей/родителей
    @Override
    public void addParent(Person person) {
        super.addParent(person);
        if ((!person.getCommunications().containsKey(this)) && (this.compareTo(person) > 12)){
            person.addCommunications(this, RelationDegree.Son);
            person.relationsTree.addRelation(new Relation<>(this, RelationDegree.Son));
        }
    }

    @Override
    public void addChildren(Person person) {
        if ((!this.getCommunications().containsKey(person)) && (this.compareTo(person) < -12)){
            super.addChildren(person);
            this.transferPower(person);
        }
        if ((!person.getCommunications().containsKey(this)) && (this.compareTo(person) < -12)){
            person.addCommunications(this,RelationDegree.Father);
            person.relationsTree.addRelation(new Relation<>(this, RelationDegree.Father));
        }
    }

    @Override
    public void addBrotherSister(Person person) {
        super.addBrotherSister(person);
        if (!person.getCommunications().containsKey(this)) {
            person.addCommunications(this,RelationDegree.Brother);
            person.relationsTree.addRelation(new Relation<>(this, RelationDegree.Brother));
        }
        }

    @Override
    public void addSpouse(Person person) {
        if  (person instanceof Woman) {
            super.addSpouse(person);
        }
    }
//Man имеет отдельный метод передачи по наследству силы - вызывается в момент добавления ребенка
    void transferPower(Person child){
        child.setPower(this.getPower());
    }


}
