package Exceptions.lesson2;

public class Seminar2Task01 {
    public static void main(String[] args) {
        String[][] arr = new String[][]
                        {{"2","3",";"},
                        {"5","fd", "6"},
                        {"7", "f","9"}};
        System.out.println("Сумма найденных значений = " + sum2d(arr));
    }

    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 5; j++) {//если указать <5 как по заданию, есть вероятность оказаться вне индекса arr[i].length
                    try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                    } catch (IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());

                    } catch (NumberFormatException e){
                        System.out.println("Битое значение по индексу: " + String.format("[%d][%d] \n", i, j) + e);
                    }
                }
        }
        return sum;
    }




}
