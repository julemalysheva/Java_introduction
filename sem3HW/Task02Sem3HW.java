package sem3HW;

import java.util.ArrayList;
import java.util.Random;

/*Пусть дан произвольный список целых чисел, удалить из него четные числа*/
public class Task02Sem3HW {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = randomList(10,99,10);
        System.out.println("Задан список:   " + integerList);
        deleteEvenNumbers(integerList);
        System.out.println("Удалены четные: " + integerList);

    }

    static ArrayList<Integer> randomList(int start, int end, int size){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            list.add(random.ints(start,(end)).findFirst().getAsInt());
        }
        return list;
    }

    static void deleteEvenNumbers(ArrayList<Integer> numbers){
//          1 способ:
//        Iterator<Integer> numIterator = numbers.iterator();
//        while (numIterator.hasNext()) {
//            Integer num = numIterator.next();
//            if(num % 2 == 0) {
//                numIterator.remove();
//            }
//        }
        //2 способ
        numbers.removeIf(integer -> integer % 2 == 0);

    }
}
