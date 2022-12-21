package sem3_OOP_HW.Task01;

import java.util.List;
import java.util.Map;

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

    @Override //попоробовать работать с клонами, может это решит вопрос верного вывода ТриМап
    //или же сортировать по значению, а именно по порядку enum
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
                                entry.getKey().addCommunications(this, RelationDegree.Uncle);//а ей дядю
                            } else if (entry.getValue() == RelationDegree.Son) {
                                this.addCommunications(entry.getKey(), RelationDegree.Nephew);//добавляем племянника
                                entry.getKey().addCommunications(this, RelationDegree.Uncle);//а ему дядю
                            }
                        }
                    }
                }
            }
        }
    }
}
