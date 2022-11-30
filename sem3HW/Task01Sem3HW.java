package sem3HW;

import java.util.ArrayList;
import java.util.Random;

/*Реализовать алгоритм сортировки слиянием
 */
public class Task01Sem3HW {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = randomList(10,99,9);
        System.out.println("Задан список:       " + integerList);
        System.out.println("Сортировка слиянием:" +mergeSort(integerList));

    }

    static ArrayList<Integer> randomList(int start, int end, int size){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            list.add(random.ints(start,(end)).findFirst().getAsInt());
        }
        return list;
    }
    static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
        // Последнее разделение массива
        if(arr.size()<2) return arr;

        // Выполняем mergeSort рекурсивно с двух сторон
        ArrayList<Integer> left = mergeSort(new ArrayList<>(arr.subList(0, arr.size() / 2)));
//        System.out.println("left" + left);
        ArrayList<Integer> right = mergeSort(new ArrayList<>(arr.subList(arr.size() / 2, arr.size())));
//        System.out.println("right" + right);

        // Объединяем стороны вместе
        return merge(left, right, arr);
//        return merge(left, right,(ArrayList<Integer>) arr.clone());
    }

    static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> merged){
        int leftCursor =0 ;
        int rightCursor = 0;
        while ((leftCursor<left.size()) && (rightCursor <right.size())){
            //Сортируем каждый и помещаем в результат
            if(left.get(leftCursor) <= right.get(rightCursor)){
                merged.set(leftCursor+rightCursor, left.get(leftCursor));
                leftCursor++;
            }
            else {
                merged.set(leftCursor+rightCursor, right.get(rightCursor));
                rightCursor++;
            }
        }

//записываем остаток отсортированного списка в результирующий, когда закончились элементы во втором подмассиве
        for (int i = leftCursor; i < left.size(); i++) {
            merged.set(i+rightCursor, left.get(i));
        }

        for (int i = rightCursor; i < right.size(); i++) {
            merged.set(leftCursor+i, right.get(i));
        }

        return merged;
    }

}
