package Exceptions.lesson2.HW_Seminar2;
/*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить
 у пользователя ввод данных.*/

import java.util.Scanner;

public class Task01Sem2 {
    public static void main(String[] args) {
        float inputNumber = getFloatFromUser();
        System.out.println("Вы ввели число: " + inputNumber);
    }

    public static float getFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите дробное число: ");
            try {
                float inputNumber = Float.parseFloat(scanner.nextLine());
                return inputNumber;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректное значение. Попробуйте снова.");
            }
        }
    }
}
