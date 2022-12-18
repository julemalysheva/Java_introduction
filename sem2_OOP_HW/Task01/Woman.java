package sem2_OOP_HW.Task01;

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

    @Override
    public void addParent(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) {
                addCommunications(person, RelationDegree.Father);
                ((Man) person).transferPower(this);
            }
            else if (person instanceof Woman) {
                addCommunications(person, RelationDegree.Mother);
                ((Woman) person).transferBeauty(this);
            }
        }
        //добавляем родителю дочь, т.к. данная логика будет вызываться из экземпляра класса Woman
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this, RelationDegree.Daughter);
    }

    @Override
    public void addChildren(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) addCommunications(person, RelationDegree.Son);
            else if (person instanceof Woman) addCommunications(person, RelationDegree.Daughter);
            this.transferBeauty(person);
        }
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this,RelationDegree.Mother);
    }

    @Override
    public void addBrotherSister(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) addCommunications(person, RelationDegree.Brother);
            else if (person instanceof Woman) addCommunications(person, RelationDegree.Sister);
        }
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this,RelationDegree.Sister);
    }

    @Override
    public void addSpouse(Person person) {
        if  (person instanceof Man) {
            if (!this.getCommunications().containsKey(person))
                addCommunications(person, RelationDegree.Spouse);
            if (!person.getCommunications().containsKey(this))
                person.addCommunications(this, RelationDegree.Spouse);
        }
    }

    //Woman имеет отдельный метод передачи по наследству красоты - вызывается в момент добавления ребенка
    void transferBeauty(Person child){
//        int heredity = r.nextInt(50,70);//процент наследственности определяем рандомно в диапазоне 50-70
//        int newBeautyForChild = this.getBeauty()*heredity/100;
//        if (newBeautyForChild >= 10 && newBeautyForChild <= 50){
//            child.setBeauty(newBeautyForChild);}
        child.setBeauty(this.getBeauty());
    }

}
