package oop.lesson3.Task3;

public class Main {
    public static void main(String[] args) {
        SomeTest<Integer> someTest = (n, d) -> (n % d) == 0;
        if (someTest.test(10, 2)) {
            System.out.println("2 является делитем 10");
        }
        System.out.println();

        SomeTest<Double> someTest1 = (n, d) -> (n % d) == 0;
        if (someTest1.test(212.0, 2.0)) {
            System.out.println("2.0 является делитем 212.0");
        }
        System.out.println();

        SomeTest<String> someTest2 = (z,x) -> z.indexOf(x) != -1;
        String str = "Обобщенный функциональный интерфейс";
        System.out.println("Тестируемая строка " + str);
        if (someTest2.test(str,"face")) {
            System.out.println("face найднено");
        }else {
            System.out.println("face не найдено");
        }
    }
}
