package oop.lesson3.Task2;

public class Main {
    public static void main(String[] args) {
        NumTest numTest = (n, d) -> (n % d) == 0;
        if (numTest.test(10, 2)) {
            System.out.println("2 является делителем 10");
        }
        if (!numTest.test(10, 3)) {
            System.out.println("3 неявляется делителем 10");
        }

        NumTest numTest1 = (m, v) -> (m < v);
        if (!numTest1.test(10, 2)) {
            System.out.println("10 не меньше 2");
        }
        if (numTest1.test(2, 10)) {
            System.out.println("2 меньше 10");
        }

        NumTest numTest2 = (s, d) -> (s < 0 ? -s : s) == (d < 0 ? -d : d);
        if (numTest2.test(4,-4)) {
            System.out.println("Обсолютные велечины 4 и -4 равны");
        }
        if (!numTest2.test(5,-4)) {
            System.out.println("Обсолютные велечины 5 и -4 не равны");
        }
    }
}
