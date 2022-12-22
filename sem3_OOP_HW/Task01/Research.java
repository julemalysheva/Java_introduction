package sem3_OOP_HW.Task01;

import java.util.List;
import java.util.Map;

public interface Research {

    //перебирает список, обращаясь к словарю каждого - устанавливает новые связи

    static void addGrandRelations(List<Person> personList){
        for (Person human:personList) {
            for (Person person:personList) {
                if (!human.equals(person)){
                    if (human.getCommunications().containsKey(person) &&
                            (human.getCommunications().get(person) == RelationDegree.Daughter ||
                                    human.getCommunications().get(person) == RelationDegree.Son)){
                        for (Map.Entry<Person,RelationDegree> entry: person.getCommunications().entrySet()) {
                            if (!human.getCommunications().containsKey(entry.getKey())){
                                if (entry.getValue() == RelationDegree.Daughter){
                                    human.addCommunications(entry.getKey(), RelationDegree.GrandDaughter);//добавляем внучку
                                    if (human instanceof Man) entry.getKey().addCommunications(human, RelationDegree.GrandFather);
                                    else if(human instanceof Woman) entry.getKey().addCommunications(human, RelationDegree.GrandMother);
                                } else if (entry.getValue() == RelationDegree.Son) {
                                    human.addCommunications(entry.getKey(), RelationDegree.GrandSon);//добавляем внука
                                    if (human instanceof Man) entry.getKey().addCommunications(human, RelationDegree.GrandFather);
                                    else if(human instanceof Woman) entry.getKey().addCommunications(human, RelationDegree.GrandMother);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//метод добавления новых родств.связей ранее переопределялся в классах Man Woman, разница в 2хстроках, поэтому сделала
    //его статич.методом текущего класса Research
    static void addNewRelations(List<Person> personList){
        for (Person human:personList) {
            for (Person person : personList) {
                if (!human.equals(person)) {
                    if (human.getCommunications().containsKey(person) &&
                            (human.getCommunications().get(person) == RelationDegree.Sister ||
                                    human.getCommunications().get(person) == RelationDegree.Brother)) {
                        for (Map.Entry<Person, RelationDegree> entry : person.getCommunications().entrySet()) {
                            if (!human.getCommunications().containsKey(entry.getKey())) {
                                if (entry.getValue() == RelationDegree.Daughter) {
                                    human.addCommunications(entry.getKey(), RelationDegree.Niece);//добавляем племянницу
                                    if (human instanceof Man) entry.getKey().addCommunications(human, RelationDegree.Uncle);
                                    else if(human instanceof Woman) entry.getKey().addCommunications(human, RelationDegree.Aunt);
                                } else if (entry.getValue() == RelationDegree.Son) {
                                    human.addCommunications(entry.getKey(), RelationDegree.Nephew);//добавляем племянника
                                    if (human instanceof Man) entry.getKey().addCommunications(human, RelationDegree.Uncle);
                                    else if(human instanceof Woman) entry.getKey().addCommunications(human, RelationDegree.Aunt);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
