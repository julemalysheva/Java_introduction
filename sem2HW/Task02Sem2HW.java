package sem2HW;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*2 Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.*/
public class Task02Sem2HW {
    public static void main(String[] args) {
        int[] arr = setRandomArray(10,10,99);
        System.out.println("Задан массив: "+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Сортировка: "+ Arrays.toString(arr));
    }

    static int[] setRandomArray(int size, int start, int end){
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.ints(start,(end+1)).findFirst().getAsInt();
        }
        return arr;
    }

    static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] >arr [j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    myLog(Arrays.toString(arr));
                }
            }
        }
    }

    static void myLog(String res) {
        Logger logger = Logger.getLogger(Task02Sem2HW.class.getName());
        try {
                FileHandler fh = new FileHandler("sem2HW/log.txt", true);
                logger.addHandler(fh);
                SimpleFormatter sFormat = new SimpleFormatter();
                fh.setFormatter(sFormat);
                logger.info(res);
                fh.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }


}
