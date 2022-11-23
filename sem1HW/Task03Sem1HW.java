package sem1HW;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*Реализовать простой калькулятор */

/*Решила разобраться с динамическим списком ArrayList.
На текущий момент реализован расчет выражений с рациональными числами из строки,
пока не работает с отрицательными значениями и скобками.
 */

public class Task03Sem1HW {

    // парсим строку и получаем список чисел типа Double
    static List<Double> strToArray(String str) {
        String[] expArr = str.trim().split("\\s*(\\+|\\*|\\/|-)\\s*");
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < expArr.length; i++) {
            numbers.add(Double.parseDouble(expArr[i]));
        }

        return numbers;
    }

    // получаем список арифметических операций
    static List<String> strToArrOperation(String str) {
        List<String> arrOperation = new ArrayList<>();
        String[] znaki = str.split("\\s*(\\d+\\.?\\d*)\\s*");
        for (String string : znaki) {
            if (!string.isEmpty())
                arrOperation.add(string);
        }
        return arrOperation;
    }

    // производится арифм. операция
    static double operation(String math_operation, Double x, Double y) throws Exception {
        double res = 0;
        if (math_operation.equals("+"))
            res = x + y;
        else if (math_operation.equals("-"))
            res = x - y;
        else if (math_operation.equals("/")) {
            if (y!=0) res = x / y;
            else throw new Exception("Деление на --0--!");
        }       
        else if (math_operation.equals("*"))
            res = x * y;
        return res;
    }

    // определяем порядок расчета и обращения к спискам с числами и знаками
    static double calc(List<Double> numbers, List<String> arrOperation) throws Exception {
        int index = 0;
        double tempCalc;
        // проводим расчеты по порядку с *|/
        while ((arrOperation.contains("*")) || (arrOperation.contains("/"))) {
            if (arrOperation.indexOf("*") == -1)
                index = arrOperation.indexOf("/");
            else if (arrOperation.indexOf("/") == -1)
                index = arrOperation.indexOf("*");
            else
                index = (arrOperation.indexOf("*") < arrOperation.indexOf("/")) ? arrOperation.indexOf("*")
                        : arrOperation.indexOf("/");

            tempCalc = operation(arrOperation.get(index), numbers.get(index), numbers.get(index + 1));
            // записываем полученный результат на место первого числа в операции
            numbers.set(index, tempCalc);
            // удаляем второе число и сам знак операции
            numbers.remove(index + 1);
            arrOperation.remove(index);
        }

        // после проводим расчеты с +|-
        while ((arrOperation.contains("+")) || (arrOperation.contains("-"))) {
            if (arrOperation.indexOf("+") == -1)
                index = arrOperation.indexOf("-");
            else if (arrOperation.indexOf("-") == -1)
                index = arrOperation.indexOf("+");
            else
                index = (arrOperation.indexOf("+") < arrOperation.indexOf("-")) ? arrOperation.indexOf("+")
                        : arrOperation.indexOf("-");

            tempCalc = operation(arrOperation.get(index), numbers.get(index), numbers.get(index + 1));
            // записываем полученный результат на место первого числа в операции
            numbers.set(index, tempCalc);
            // удаляем второе число и сам знак операции
            numbers.remove(index + 1);
            arrOperation.remove(index);
        }

        return numbers.get(0);
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите строку выражения,\nнапример, 25.5-9/3+7*2.45; 45/9 и т.д.: ");
        String expString = iScanner.nextLine();
        System.out.printf("Считаем %s\n", expString);
        iScanner.close();

        try {
            List<Double> numbers = strToArray(expString);
            // вывожу значения для проверки
            System.out.println(numbers);
            List<String> arrOperation = strToArrOperation(expString);
            System.out.println(arrOperation);
            double resCalc = calc(numbers, arrOperation);
            System.out.printf("Результат вычисления:\n%s = %.2f\n", expString, resCalc);

        } catch (Exception e) {
            System.out.println("Некорректное выражение");
            System.err.println(e.getMessage());
        }

    }

}
