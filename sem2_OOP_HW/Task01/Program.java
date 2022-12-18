package sem2_OOP_HW.Task01;


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

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        person1.addChildren(person3);
        person1.addChildren(person4);
        person2.addChildren(person3);
        person2.addChildren(person4);
        System.out.println("----added parents----change power and beauty----");
        System.out.println(person3);
        System.out.println(person4);

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

        //здесь вызываем исследование для формирования других связей на основе текущих, дядя/тетя и т.п.
        person7.addNewRelations(Person.personList);
        person1.addNewRelations(Person.personList);
        //метод интерфейса устанавливает grand связи
        Research.addGrandRelations(Person.personList);

        for (Person person: Person.personList) {
            System.out.println("-------------------------");
            KinshipPrint.printChildren(person);
            System.out.println("-------------------------");
            KinshipPrint.printAllRelatives(person);
        }


    }
}
