package sem1_OOP.Task01;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Person person1 = new Woman("Yulia", "M.", 1983);
        Person person2 = new Man("Sergey", "M.", 1984);
        Person person3 = new Woman("Alyona", "M.", 2010);
        Person person4 = new Woman("Vika", "M.", 2006);
        Person person5 = new Woman("Olga", "K.", 1961);
        Person person6 = new Man("Andrey", "K.", 1959);
        Person person7 = new Man("Maxim", "K.", 1984);
        Person person8 = new Woman("Sofiya", "K.", 2013);
        Person person9 = new Woman("Venera", "K.", 1983);

// Set<String> choosingKinship = new HashSet<>(Arrays.asList("parent", "child", "grandparent", "spouse", "brother", "grandchild"));
//возможные связи на текущий момент - при настройке пользовательского ввода можно его ограничивать
        Relatives rel1 = new Relatives(person1, person3, "parent");
        Relatives rel2 = new Relatives(person4, person1, "child");
        Relatives rel3 = new Relatives(person2, person4, "parent");
        Relatives rel4 = new Relatives(person3, person2, "child");
        Relatives rel5 = new Relatives(person5, person1, "parent");
        Relatives rel6 = new Relatives(person6, person1, "parent");
        Relatives rel7 = new Relatives(person7, person5, "child");
        Relatives rel8 = new Relatives(person7, person6, "child");
        Relatives rel9 = new Relatives(person8, person7, "child");
        Relatives rel10 = new Relatives(person9, person7, "spouse");
        Relatives rel11 = new Relatives(person2, person1, "spouse");
        Relatives rel12 = new Relatives(person7, person1, "brother");
        Relatives rel13 = new Relatives(person5, person3, "grandparent");
        Relatives rel14 = new Relatives(person6, person3, "grandparent");
        Relatives rel15 = new Relatives(person5, person4, "grandparent");
        Relatives rel16 = new Relatives(person6, person4, "grandparent");
        Relatives rel17 = new Relatives(person5, person8, "grandparent");
        Relatives rel18 = new Relatives(person6, person8, "grandparent");
        Relatives rel19 = new Relatives(person8, person9, "child");
        Relatives rel20 = new Relatives(person3, person4, "brother");
        Relatives rel21 = new Relatives(person5, person6, "spouse");


        List<Person> personList = new ArrayList<>(List.of(person1, person2, person3, person4, person5, person6,
                person7, person8, person9));
        System.out.println("-------------Смотрим детей--------------------");
        for (Person person: personList) {
            System.out.println("---------------");
            KinshipResearch.printChildren(person);
        }
        System.out.println("---------------");
        System.out.println("-------------Смотрим все текущие связи-------------------");
        for (Person person: personList) {
            System.out.println("---------------");
            KinshipResearch.printAllRelatives(person);
        }




    }
}
