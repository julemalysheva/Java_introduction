package sem3HW;

import java.util.ArrayList;
import java.util.Random;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.*/
public class Task03Sem3HW {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = randomList(10,99,10);
        System.out.println("Задан список:   " + integerList);
        System.out.println("min: " + minArrayList(integerList));
        System.out.println("max: " + maxArrayList(integerList));
        System.out.println("average: " + averageNumberArrayList(integerList));
    }

    static ArrayList<Integer> randomList(int start, int end, int size){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            list.add(random.ints(start,(end)).findFirst().getAsInt());
        }
        return list;
    }

    static Integer minArrayList(ArrayList<Integer> list){
        Integer min = list.get(0);
        for (Integer el: list) {
            if(el<min) min = el;
        }
        return min;
    }

    static Integer maxArrayList(ArrayList<Integer> list){
        Integer max = list.get(0);
        for (Integer el: list) {
            if(el>max) max = el;
        }
        return max;
    }

    static double averageNumberArrayList(ArrayList<Integer> list){
        int sum = 0;
        for (Integer el: list) {
            sum+=el;
        }
        return (double)sum/(double)list.size();
    }


}
