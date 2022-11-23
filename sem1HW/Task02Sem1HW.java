package sem1HW;
/*Вывести все простые числа от 1 до 1000 */

public class Task02Sem1HW {
    public static void main(String[] args) {
        boolean[] arr = new boolean[1000];
        for (int i = 2; i*i < arr.length; i++) {
            if(arr[i]==false){
                for (int j = i*i; j < arr.length; j+=i) {
                    arr[j] = true;
                }
            }
        }
        // выводим простые числа в консоль
        System.out.println();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]==false){
                System.out.print(i+" ");
            }
        } 
        System.out.println();       
    }
}
