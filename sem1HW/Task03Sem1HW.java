package sem1HW;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
// import java.util.Stack;

/*Реализовать простой калькулятор */

//добавить проверку строки по регулярке при вводе или обработать исключение
public class Task03Sem1HW {

    static double[] strToArray(String str){
    String[] expArr = str.split("\\s*(\\+|\\*|\\/|-)\\s*");
    String[] znaki = str.split("\\s*\\d+\\s*");
    for (String string : expArr) {
    System.out.println(string);
    }
    System.out.println(String.join(" ", znaki));

    double[] exp = new double[expArr.length];
    for (int i = 0; i < expArr.length; i++) {
    exp[i] = Double.parseDouble(expArr[i]);
    }

    return exp;
    }

    // static double calc()

    public static void main(String[] args) {
    Scanner iScanner = new Scanner(System.in);
    System.out.print("\nВведите строку выражения: ");
    String expString = iScanner.nextLine();
    System.out.printf("Считаем %s\n", expString);
    iScanner.close();
    System.out.println(Arrays.toString(strToArray(expString)));

    }

}
