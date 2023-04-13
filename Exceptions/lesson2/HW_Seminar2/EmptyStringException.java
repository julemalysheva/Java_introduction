package Exceptions.lesson2.HW_Seminar2;
/*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/

import java.util.Scanner;

public class EmptyStringException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        do {
            System.out.print("Введите строку (не пустую): ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Пустые строки вводить нельзя!");
                throw new IllegalArgumentException("Пустая строка!");
            }
        } while (input.isEmpty() && scanner.hasNextLine());
        System.out.println("Вы ввели: " + input);
    }

}
