package sem1;

import java.util.Arrays;

/*Дан массив nums = [3,2,2,3] и число val = 3. 
Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, 
а остальные - равны ему.
 */
public class task04 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,2,3};
        int num = 3;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==num) {
                for (int j = arr.length-1; j>i;j--) {   
                    if (arr[j]!=num) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
