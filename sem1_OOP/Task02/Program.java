package sem1_OOP.Task02;

public class Program {
    public static void main(String[] args) {
        Human man1 = new Human("Ivan");
        Human man2 = new Human("Lena");
        System.out.println(man1);
        System.out.println(man2);
        Closet closet1 = new Closet("brown", "bedroom", 120, 200, 60);
        Closet closet2 = new Closet("white", "childrens room", 100, 160, 80);
        System.out.println(closet1);
        System.out.println(closet2);
        man1.changeLocation(closet1, "hall");

        man1.putItem(3,closet2);
        man2.putItem(4,closet2);
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(closet2);

        man1.takeItem(1,closet1);
        man2.takeItem(2,closet1);
        System.out.println(closet1);

        man1.takeItem(2,closet1);
        man1.putItem(2,closet2);

        man2.clearCloset(closet2);
        System.out.println(closet2);
        System.out.println(man2);


    }
}
