package sem2_OOP_HW.Task01;

import java.util.List;
import java.util.Map;

public interface Research {

    //перебирает список, обращаясь к словарю каждого - устанавливает новые связи
    //думаю, как лучше - сделать один статический и вызывать через интерфейс или расширять класс и описывать там, логика схожа.
    //можно сделать один для переопределения, а второй статич. - через интерфейс, тогда он будет проверять сразу весь список
    //а не конкретного человека

    static void addGrandRelations(List<Person> personList) {//статич.метод интерфейса- ко всему списку
        for (int i = 0; i < personList.size() -1; i++) {
            for (int j = 1; j < personList.size(); j++) {
                if (personList.get(i).getCommunications().containsKey(personList.get(j))) {
//                    System.out.println(personList.get(i) + " содержит " + personList.get(j));
                    //если находим детей - ищем у них детей
                    RelationDegree current = personList.get(i).getCommunications().get(personList.get(j));
                    if (current == RelationDegree.Daughter || current == RelationDegree.Son) {
//                        System.out.println(personList.get(j) + " сын или дочь для " + personList.get(i));
                        for (Map.Entry<Person, RelationDegree> entry :
                                personList.get(j).getCommunications().entrySet()) {
                            if (!personList.get(i).getCommunications().containsKey(entry.getKey())) {
                                if (entry.getValue() == RelationDegree.Daughter) {
                                    personList.get(i).addCommunications(entry.getKey(), RelationDegree.GrandDaughter);
                                    if (personList.get(i) instanceof Man)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandFather);
                                    else if (personList.get(i) instanceof Woman)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandMother);
                                } else if (entry.getValue() == RelationDegree.Son) {
                                    personList.get(i).addCommunications(entry.getKey(), RelationDegree.GrandSon);
                                    if (personList.get(i) instanceof Man)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandFather);
                                    else if (personList.get(i) instanceof Woman)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandMother);
                                }
                            }
                        }
                    //если находим родителя - ищем у них родителей
                    } else if (personList.get(i).getCommunications().get(personList.get(j)) == RelationDegree.Mother ||
                            personList.get(i).getCommunications().get(personList.get(j)) == RelationDegree.Father) {
//                        System.out.println(personList.get(j) + " мама или папа для " + personList.get(i));
                        for (Map.Entry<Person, RelationDegree> entry :
                                personList.get(j).getCommunications().entrySet()) {
                            if (!personList.get(i).getCommunications().containsKey(entry.getKey())) {
                                if (entry.getValue() == RelationDegree.Mother) {
                                    personList.get(i).addCommunications(entry.getKey(), RelationDegree.GrandMother);
                                    if (personList.get(i) instanceof Man)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandSon);
                                    else if (personList.get(i) instanceof Woman)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandDaughter);
                                } else if (entry.getValue() == RelationDegree.Father) {
                                    personList.get(i).addCommunications(entry.getKey(), RelationDegree.GrandFather);
                                    if (personList.get(i) instanceof Man)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandSon);
                                    else if (personList.get(i) instanceof Woman)
                                        entry.getKey().addCommunications(personList.get(i), RelationDegree.GrandDaughter);
                                }
                            }
                        }

                    }
                }
            }
        }
    }//после добавления показывает этот элемент и почему то дальше не смотрит этот Map?

    void addNewRelations(List<Person> personList);//переопределяется в классах
}
