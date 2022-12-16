package sem1_OOP.Task01;

public class KinshipResearch {
    public static void printChildren(Person person){
        System.out.println("Дети " + person + ": ");
        int count = 0;
        for (var item: person.getCommunications().entrySet()) {
            if (item.getValue().equals(RelationDegree.Children)){
                System.out.println(item.getValue() + ": " + item.getKey());
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
