package Exceptions.lesson2.HW_Seminar2;

public class Task02Sem2 {
    public static void main(String[] args) {
            /* Если необходимо, исправьте данный код
    (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)*/

        int[] intArray = new int[]{5, 8, 4, 6, 4, 56, 7, 8};
        /* В этом коде добавлен второй блок catch для обработки ArrayIndexOutOfBoundsException,
        который может быть выброшен при попытке доступа к элементу массива с недопустимым индексом.*/
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }




    }

}
