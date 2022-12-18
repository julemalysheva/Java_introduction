package sem2_OOP_HW.Task01;

import java.util.List;

public class Man extends Person implements FamilyTree, Research{
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
        //добавляем родителю сына, т.к. данная логика будет вызываться из экземпляра класса Man
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this, RelationDegree.Son);
    }

    @Override
    public void addChildren(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) addCommunications(person, RelationDegree.Son);
            else if (person instanceof Woman) addCommunications(person, RelationDegree.Daughter);
            this.transferPower(person);
        }
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this,RelationDegree.Father);
    }

    @Override
    public void addBrotherSister(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) addCommunications(person, RelationDegree.Brother);
            else if (person instanceof Woman) addCommunications(person, RelationDegree.Sister);
        }
        if (!person.getCommunications().containsKey(this)) person.addCommunications(this,RelationDegree.Brother);
        }

    @Override
    public void addSpouse(Person person) {
        if  (person instanceof Woman) {
            if (!this.getCommunications().containsKey(person))
                addCommunications(person, RelationDegree.Spouse);
            if (!person.getCommunications().containsKey(this))
                person.addCommunications(this, RelationDegree.Spouse);
        }
    }
//Man имеет отдельный метод передачи по наследству силы - вызывается в момент добавления ребенка
    void transferPower(Person child){
//        int heredity = r.nextInt(50,70);//процент наследственности определяем рандомно в диапазоне 50-70
//        int newPowerForChild = this.getPower()*heredity/100;
//        if (newPowerForChild >= 10 && newPowerForChild <= 50){
//        child.setPower(newPowerForChild);}
        child.setPower(this.getPower());
    }

    @Override
    public void AddNewRelations(List<Person> personList) {

    }
}
