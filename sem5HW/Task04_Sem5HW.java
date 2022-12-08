package sem5HW;

import java.util.ArrayList;
import java.util.Arrays;

/*4**. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.*/
public class Task04_Sem5HW {
    public static void main(String[] args) {
        int n = 8;
        int[][] arr = new int[n][n];
        printArray(eightQueens(arr));
    }

    //Лестничное решение для 8 n
    //Один из подходов заключается в:
    static int[][] eightQueens(int[][] arr){
        /*Если остаток от деления n на 6 не равен 2 или 3, то список состоит просто из всех четных чисел,
        за которыми следуют все нечетные числа, не превышающие n .
В противном случае напишите отдельные списки четных и нечетных чисел (2, 4, 6, 8 – 1, 3, 5, 7).*/
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 1; i < arr.length+1; i++) {
            if (i%2 == 0) even.add(i);
            else odd.add(i);
        }
        //Если остаток равен 2, поменяйте местами 1 и 3 в нечетном списке и переместите 5 в конец ( 3, 1 , 7, 5 ).
        if (arr.length%6 == 2) {
            odd.add(0, odd.remove(1));//3 на первое место
            odd.add(odd.remove(2));//5 в конец
        } //Если остаток равен 3, переместите 2 в конец четного списка и 1,3 в конец нечетного списка (4, 6, 8, 2 – 5, 7, 1, 3 ).
        else if (arr.length%6 == 3){
            even.add(even.remove(0));//2 в конец
            odd.add(odd.remove(0));//1 в конец
            odd.add(odd.remove(0));//3 в конец
        }
        //Добавьте нечетный список к четному и поместите ферзей в ряды, указанные этими числами,
        // слева направо (a2, b4, c6, d8, e3, f1, g7, h5).
        even.addAll(odd); //собрали результирующий
        System.out.println("Расстановка: "+even);
        for (int i = 0; i < even.size(); i++) {
            arr[i][even.get(i)-1] = 1;
            //arr[even.get(i)-1][i] = 1; или так
        }

        return arr;
    }

    static void printArray(int[][] arr){
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
