package sem3_OOP_HW.Task01;

public class Woman extends Person implements FamilyTree{
    private final String GENDER;
    {
        GENDER = "female";
    }
    @Override
    public String toString() {
        return GENDER + " " + super.toString();
    }

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
        this.beauty = r.nextInt(30,50);
        this.power = r.nextInt(10,30);
    }
//добавлены условия compareTo при добавлении детей/родителей
    @Override
    public void addParent(Person person) {
        super.addParent(person);
        //добавляем родителю дочь, т.к. данная логика будет вызываться из экземпляра класса Woman
        if ((!person.getCommunications().containsKey(this)) && (this.compareTo(person) > 12))
            person.addCommunications(this, RelationDegree.Daughter);
    }

    @Override
    public void addChildren(Person person) {
        if ((!this.getCommunications().containsKey(person)) && (this.compareTo(person) < -12)){
            super.addChildren(person);
            this.transferBeauty(person);
        }

        if ((!person.getCommunications().containsKey(this)) && (this.compareTo(person) < -12))
            person.addCommunications(this,RelationDegree.Mother);
    }

    @Override
    public void addBrotherSister(Person person) {
        super.addBrotherSister(person);
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this,RelationDegree.Sister);
    }

    @Override
    public void addSpouse(Person person) {
        if  (person instanceof Man) {
            super.addSpouse(person);
        }
    }

    //Woman имеет отдельный метод передачи по наследству красоты - вызывается в момент добавления ребенка
    void transferBeauty(Person child){
        child.setBeauty(this.getBeauty());
    }


}
