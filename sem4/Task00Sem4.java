package sem4;
/*
1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
*/
import java.util.ArrayList;
import java.util.LinkedList;

public class Task00Sem4 {
    public static void main(String[] args) {
        long ms = System.currentTimeMillis();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            integerArrayList.add(i);
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis()-ms)); //ArrayList: 2

        ms = System.currentTimeMillis();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            integerLinkedList.add(i);
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis()-ms));//LinkedList: 8

    }
}
