package Exceptions.lesson1;

import java.util.Arrays;

public class ExceptionsSeminar1HW {
    public static void main(String[] args) {
        int[] a = null;
        int[] b = {4, 5, 6};
        int[] c = {7, 12};
        int[] d = {7, 8, 0};

        try {
            int[] result1 = subtractArraysForLength(b, c);
            System.out.println(Arrays.toString(result1));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Arrays are not of equal length
        }

        try {
            int[] result2 = subtractArraysWithNullPointer(a, b);
            System.out.println(Arrays.toString(result2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Array is null
        }

        try {
            int[] result3 = subtractArraysIndexOut(d, c);
            System.out.println(Arrays.toString(result3));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Index is out of bounds 2
        }

        System.out.println("*******************************************");

        try {
            int[] result4 = divideArrays(a, b);
            System.out.println(Arrays.toString(result4));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Array is null
        }

        try {
            int[] result5 = divideArrays(b, c);
            System.out.println(Arrays.toString(result5));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Array lengths are not equal!
        }

        try {
            int[] result6 = divideArrays(b, d);
            System.out.println(Arrays.toString(result6));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); //Division by zero!
        }


    }

    /*Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
 необходимо как-то оповестить пользователя.*/

    // 1 метод - сравнивает длину массивов
    public static int[] subtractArraysForLength(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays are not of equal length");
        }

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    // 2 метод - проверка null
    public static int[] subtractArraysWithNullPointer(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new NullPointerException("Array is null");
        }

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    // 3 метод - проверка индексов первого с длиной второго
    public static int[] subtractArraysIndexOut(int[] a, int[] b) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (i >= b.length) {
                throw new IndexOutOfBoundsException("Index is out of bounds " + i);
            }
            result[i] = a[i] - b[i];
        }
        return result;
    }

    //Задание 2
    /** Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
     * каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно:
     * При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.*/

    public static int[] divideArrays(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new NullPointerException("Array is null");
        }

        if (a.length != b.length) {
            throw new RuntimeException("Array lengths are not equal!");
        }

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                throw new RuntimeException("Division by zero!");
            }
            result[i] = a[i] / b[i];
        }

        return result;
    }

}
