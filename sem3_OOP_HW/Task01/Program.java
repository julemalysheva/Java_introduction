package sem3_OOP_HW.Task01;


import java.util.Collections;
import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
        Woman person1 = new Woman("Yulia", "M.", 1983);
        Man person2 = new Man("Sergey", "M.", 1984);
        Woman person3 = new Woman("Alyona", "M.", 2010);
        Woman person4 = new Woman("Vika", "M.", 2006);
        Woman person5 = new Woman("Olga", "K.", 1961);
        Man person6 = new Man("Andrey", "K.", 1959);
        Man person7 = new Man("Maxim", "K.", 1984);
        Woman person8 = new Woman("Sofiya", "K.", 2013);
        Woman person9 = new Woman("Venera", "K.", 1983);

        person1.addChildren(person3);
        person1.addChildren(person4);
        person2.addChildren(person3);
        person2.addChildren(person4);

        person1.addBrotherSister(person7);
        person3.addBrotherSister(person4);
        person1.addParent(person5);
        person6.addChildren(person1);
        person7.addParent(person5);
        person6.addChildren(person7);
        person2.addSpouse(person1);
        person7.addSpouse(person9);
        person5.addSpouse(person6);
        person8.addParent(person7);
        person8.addParent(person9);
        person7.addChildren(person2);//не добавит по условию compareTo


        //здесь вызываем исследование для формирования других связей на основе текущих, Uncle, Aunt, Nephew, Niece
        Research.addNewRelations(Person.personList);
        //метод интерфейса устанавливает grand связи: GrandMother, GrandFather, GrandDaughter, GrandSon,
        Research.addGrandRelations(Person.personList);

        //в абстр.класс Person имплементировала интерфейс Comparable - сортируем список по году рождения
        Collections.sort(Person.personList);

        //проходим по всему отсортированному списку людей и выводим детей и полный перечень родственных связей
        for (Person person: Person.personList) {
            System.out.println("-------------------------");
            KinshipPrint.printChildren(person);
            System.out.println("-------------------------");
            KinshipPrint.printAllRelatives(person);
        }
        //вывод отсортированного Map по значению - по порядку хранения связей в enum через Comparator
        System.out.println("""
                
                Сортировка по порядку хранения связей в enum через Comparator:\s
                А также использование фабричных функциональных интерфейсов:\s
                """);
        System.out.println("Родственники " + person4.getName() + ": ");
        KinshipPrint.printMap(KinshipPrint.sortByValueComparator(person4.getCommunications()));

    //отдельно сущности с компонентами связей для отработки итерации implements Iterable<Relation>
        System.out.println("\nПрименение интерфейса implements Iterable<Relation> для итерации собственных типов: ");
        for (Relation re: person1.relationsTree) {
            System.out.println(re);
        }
        System.out.println("\nПрименение интерфейса implements Iterator<Relation> для итерации собственных типов: ");
        Iterator<Relation> relationIterator = person7.relationsTree;
        while (relationIterator.hasNext()){
            System.out.println(relationIterator.next());
        }
        //для отработки Обобщений создан класс GenderList
        GenderList<Man> manList = new GenderList<Man>();
        for (Person man: Person.personList) {
            if (man instanceof Man) manList.add((Man) man);
        }
        System.out.println(manList);
        GenderList<Woman> woman = new GenderList<>();
        woman.add(person3);
        woman.add(person1);
//        woman.add(person2);не соответствует типу woman - ошибка на этапе компиляции
        woman.add(person4);
        woman.add(person5);
        woman.add(person8);
        woman.add(person9);
        for (Woman women: woman) {
            System.out.println(women);
        }

        System.out.println("\nРезультат применения обобщений - связь формируется по enum или по строке");
        person1.addAnother(person9, "жена брата");
        for (Relation<?,?> re: person1.relationsTree) {
            System.out.println(re);
        }
    }
}
