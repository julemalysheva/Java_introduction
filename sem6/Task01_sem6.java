package sem6;

import java.util.*;

/*1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент
уникальных значений в данном массиве и верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
*/
public class Task01_sem6 {
    public static void main(String[] args) {
    Integer[] arrInt = randomArr(0,24,1000);
        System.out.println("Доля уникальных = "+shareUnique(arrInt));//Доля уникальных = 2.4
    }

    static Integer[] randomArr(int start, int end, int size){
        Random random = new Random();
        Integer[] ints = new Integer[size];
        for (int i = 0; i <size; i++) ints[i] = random.ints(start, (end)).findFirst().getAsInt();
        return ints;
    }

    static double shareUnique(Integer[] arr){
        //так сработает, если в качестве типа использовать обертку Integer, а не int
        HashSet<Integer> integerHashSet = new HashSet<>(Arrays.asList(arr));
        //если int, то так:
//        HashSet<Integer> integerHashSet = new HashSet<>();//как еще можно на основе массива?
//        for (int el:arr) {
//            integerHashSet.add(el);
//        }
        return (double) integerHashSet.size() / (double) arr.length *100;
    }

}
