package sem3_OOP_HW.Task01;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

//для отработки фабричных функц.интерфейсов данный класс дополняю методами сортировки - Comparator
public class KinshipPrint {

    public static Map<Person, RelationDegree> sortByValueComparator(
            Map<Person, RelationDegree> unsortMap) {

        List<Map.Entry<Person, RelationDegree>> list = new LinkedList<Map.Entry<Person, RelationDegree>>(
                unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Person, RelationDegree>>() {
            public int compare(Map.Entry<Person, RelationDegree> o1, Map.Entry<Person, RelationDegree> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }//хочу сравнивать по порядку свзяи в enum
        });

        HashMap<Person, RelationDegree> sortedMap = new LinkedHashMap<Person, RelationDegree>();
        for (Map.Entry<Person, RelationDegree> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    //метод красивого вывода в консоль с применением функц.интерфейсов
    public static void printMap(Map<Person, RelationDegree> map){
        for (Map.Entry<Person, RelationDegree> entry: map.entrySet()) {
            //здесь воспользовалась функц.интерфейсом для вывода возраста и пр.
            //очевидно, такие сложности в данном примере не к чему, просто использую для отработки методов)
            UnaryOperator<Integer> unaryOperator = (z) -> LocalDate.now().getYear()-z;
            Consumer<Integer> consumer = x -> System.out.println(entry.getValue() + ": " + entry.getKey().getName()
                    + " " +  x + " лет");
            consumer.accept(unaryOperator.apply(entry.getKey().birthYear));
        }
    }

    //в данный метод также добавила вывод возраста, рассчитываемый от года рождения в UnaryOperator
    public static void printChildren(Person person){
        System.out.println("Дети " + person + ": ");
        int count = 0;
        for (var item: person.getCommunications().entrySet()) {
            if (item.getValue().equals(RelationDegree.Son) || item.getValue().equals(RelationDegree.Daughter)){
                //здесь воспользовалась функц.интерфейсом для вывода возраста и пр.
                //очевидно, такие сложности в данном примере не к чему, просто использую для отработки методов)
                UnaryOperator<Integer> unaryOperator = (z) -> LocalDate.now().getYear()-z;
                Consumer<Integer> consumer = x -> System.out.println(item.getValue() + ": " + item.getKey().getName()
                        + " " +  x + " лет");
                consumer.accept(unaryOperator.apply(item.getKey().birthYear));
                count++;
            }
        }
        if (count>0) System.out.println("Всего детей: " + count);
        else System.out.println("не найдены");


    }

    public static void printAllRelatives(Person person){
        System.out.println("Родственные связи " + person + ": ");
        for (var item: person.getCommunications().entrySet()) {
            System.out.println(item.getValue() + ": " + item.getKey());
        }
    }
}
