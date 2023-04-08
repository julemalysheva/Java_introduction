package Exceptions.lesson1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Seminar1 {
    public static void main(String[] args) {
        //задание 1
//        int[] array = new int[]{1, 5, 8, 4, 9, 12, 10};
//        try {
//            userInOut(array, 7);
//        } catch (RuntimeException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        //задание 2
//        int[][] arr = setArray(0,2, 3,3);
//        printArray(arr);
//        try {
//            System.out.println(sumArray(arr));
//        } catch (RuntimeException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        //задание3
        Integer[] arr = new Integer[]{7,2,6,78,45,89};
        try {
            checkArray(arr);
        } catch (RuntimeException e){
            e.printStackTrace();
        }


    }

//    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
//    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
//            1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//            2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//            3. если вместо массива пришел null, метод вернет -3
//            4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
//    Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит
//    искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый
//    результат пользователю. Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
    public static int fixErrorInArray(int[] arr, int value, int min){
        //например, может придти null для поиска значения в массиве с int или массив просто пустой
        //else if (arr.length < 1){
        //            index = -4;
        //        }
        int index = -2;
        if (arr == null){
            index = -3;
        } else if (arr.length < min){
            index = -1;
        }  else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value){
                    index = i;
                }
            }
        }
        return index;
    }

    public static void userInOut(int[] arr, int min) {
//        Scanner in = new Scanner(System.in);
        int userNum;
        boolean checkNum = false;

        while (!checkNum) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите число для поиска в массиве: ");
            checkNum = in.hasNextInt();
            if (checkNum) {
                userNum = in.nextInt();
                in.close();
                int result = fixErrorInArray(arr, userNum, min);
                switch (result) {
                    case -1 -> throw new RuntimeException("длина массива меньше заданного минимума");
                    case -2 -> throw new RuntimeException("Искомый элемент не найден");
                    case -3 -> throw new RuntimeException("Вместо массива пришел null");
                    case -4 -> throw new RuntimeException("Массив пустой");

                    default -> System.out.println("Найден искомый элемент " + userNum + " по индексу: " + result);
                }

            } else {
            System.out.println("Нужно ввести целое число");
            }
        }

    }

    //Задание 2
    //заполнение массива
    public static int[][] setArray(int start, int end, int length1, int length2){
        int[][] arr = new int[length1][length2];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.ints(start,(end+1)).findFirst().getAsInt();
                //System.out.printf("%d ", arr[i][j]);
            }
        }
        return  arr;
    }

    public static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int sumArray(int[][] arr){
        int amount = 0;
        if (arr.length != arr[0].length){
            throw new RuntimeException("Массив не квадратный");
        } else {//вряд здесь нужен else
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    if (anInt == 0 || anInt == 1) {
                        amount += anInt;
                    } else {
                        throw new RuntimeException("Элемент не равен 0 или 1");
                    }
                }
            }
        }
        return amount;
    }

    //Задание 3. на данный момент просто выводит инфу, можно сделать и boolean
    public static void checkArray(Integer[] arr){
        ArrayList<Integer> indexNull = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                indexNull.add(i);
            }
        }
        if (indexNull.size() > 0){
            throw new RuntimeException("Массив содержит null на позициях: " + indexNull);
        } else {
            System.out.println("Массив не содержит null");
        }
    }


}
