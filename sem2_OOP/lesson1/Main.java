package sem2_OOP.lesson1;

public class Main {
    public static void main(String[] args) {
        NumberTwo ob = new NumberTwo();
        Methods obi;
        for (int i = 0; i < 5; i++) {
            obi = ob;
            System.out.println("Следующее значение " + ob.getNext());
        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println("Следующее значение " + ob.getNext());
//        }
//        System.out.println("Сброс");
//        ob.reset();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Следующее значение " + ob.getNext());
//        }
//        System.out.println("Начальное значение 100");
//        ob.setStart(100);
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Следующее значение " + ob.getNext());
//        }
    }
}
