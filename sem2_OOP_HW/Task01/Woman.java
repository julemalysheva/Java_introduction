package sem2_OOP_HW.Task01;

import java.util.List;
import java.util.Map;

public class Woman extends Person implements FamilyTree, Research{
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

    @Override
    public void addNewRelations(List<Person> personList) {
        for (Person person:personList) {
            if (!this.equals(person)){
                if (this.getCommunications().containsKey(person) &&
                        (this.getCommunications().get(person) == RelationDegree.Sister ||
                                this.getCommunications().get(person) == RelationDegree.Brother)){
                    for (Map.Entry<Person,RelationDegree> entry: person.getCommunications().entrySet()) {
                        if (!this.getCommunications().containsKey(entry.getKey())){
                            if (entry.getValue() == RelationDegree.Daughter){
                                this.addCommunications(entry.getKey(), RelationDegree.Niece);//добавляем племянницу
                                entry.getKey().addCommunications(this, RelationDegree.Aunt);//а ей тетю
                            } else if (entry.getValue() == RelationDegree.Son) {
                                this.addCommunications(entry.getKey(), RelationDegree.Nephew);//добавляем племянника
                                entry.getKey().addCommunications(this, RelationDegree.Aunt);//а ему тетю
                            }
                        }
                    }
                }
            }
        }
    }


}
