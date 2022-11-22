/*Дан массив двоичных чисел, например [1,1,0,1,1,1], 
вывести максимальное количество подряд идущих 1.
*/
package sem1;

public class Task02 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 0, 0, 1};
        int count = 0;
        int max = 0;

        for (int i : array) {
            if (i == 1) count++;
            else {
                if (max < count) max = count;
                count = 0;
            }
        }
        if (max < count) max = count;
        
        System.out.println(max);
    }
}

