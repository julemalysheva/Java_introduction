package sem2_OOP_HW.Task01;

import java.util.List;
import java.util.Map;

public interface Research {

    //перебирает список, обращаясь к словарю каждого - устанавливает новые связи
    //думаю, как лучше? - сделать один статический и вызывать через интерфейс или расширять класс и описывать там, логика схожа.
    //для практики сделала один для переопределения, а второй статич. - через интерфейс, тогда он будет проверять сразу весь список,
    //а не вызываться у конкретного человека

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


    void addNewRelations(List<Person> personList);//переопределяется в классах
}
