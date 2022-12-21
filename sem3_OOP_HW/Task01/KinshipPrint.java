package sem3_OOP_HW.Task01;


public class KinshipPrint {
    public static void printChildren(Person person){
        System.out.println("Дети " + person + ": ");
        int count = 0;
        for (var item: person.getCommunications().entrySet()) {
            if (item.getValue().equals(RelationDegree.Son) || item.getValue().equals(RelationDegree.Daughter)){
                System.out.println(item.getValue() + ": " + item.getKey());
                count++;
            }
        }
        if (count>0) System.out.println("Всего детей: " + count);
        else System.out.println("не найдены");


    }
//    public static void printAllRelatives(Person person){
//        System.out.println("Для сравнения: \n" + person.getCommunications() + "\n");
////        Map<Person, RelationDegree> keySortedMap = new TreeMap<>(person.getCommunications());
//        Map<Person, RelationDegree> keySortedMap = new TreeMap<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return switch (Integer.compare(o1.birthYear, o2.birthYear)) {
//                    case 1, -1 -> Integer.compare(o1.birthYear, o2.birthYear);//o1.compareTo(o2);
//                    case 0 -> o1.getName().compareTo(o2.getName());
//                    default -> o1.compareTo(o2);
//                };
//                //return o1.compareTo(o2); //жду вывод в порядке убывания
//            }
//        });
//        keySortedMap.putAll(person.getCommunications());
//
//        System.out.println("Родственные связи " + person + ": ");
//        for (Map.Entry<Person, RelationDegree> item: keySortedMap.entrySet()) {
//            System.out.println(item.getValue() + ": " + item.getKey());
//        }
//        keySortedMap.clear();
//    }

    public static void printAllRelatives(Person person){
        System.out.println("Родственные связи " + person + ": ");
        for (var item: person.getCommunications().entrySet()) {
            System.out.println(item.getValue() + ": " + item.getKey());
        }
    }
}
