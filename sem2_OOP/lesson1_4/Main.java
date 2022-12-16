package sem2_OOP.lesson1_4;

public class Main {
    public static void main(String[] args) {
        MyClass2 ob = new MyClass2();
        MyClass3 ob1 = new MyClass3();

        int unId = MyI.universalId();//вызываем статический метод интерфейса - обращаясь напрямую к интерфейсу

        System.out.println(unId);
        System.out.println("Id пользователя " + ob.getUserId());
        System.out.println("Id Администратора " + ob.getAdminId());
        System.out.println();
        System.out.println("Id пользователя " + ob1.getUserId());
        System.out.println("Id Администратора " + ob1.getAdminId());
    }
}
