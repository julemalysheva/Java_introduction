package sem1HW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*Реализовать простой калькулятор */

/*Решила разобраться с динамическим списком ArrayList.
На текущий момент реализован расчет выражений с рациональными числами из строки,
пока не работает с отрицательными значениями и скобками.
 */

/*По заданию семинара 2 добавлено логирование*/

public class Task03Sem1HW {

    // парсим строку и получаем список чисел типа Double
    static List<Double> strToArray(String str) {
        String[] expArr = str.trim().split("\\s*[+*/-]\\s*");
        List<Double> numbers = new ArrayList<>();
        for (String s : expArr) {
            numbers.add(Double.parseDouble(s));
        }

        return numbers;
    }

    // получаем список арифметических операций
    static List<String> strToArrOperation(String str) {
        List<String> arrOperation = new ArrayList<>();
        String[] operation = str.split("\\s*(\\d+\\.?\\d*)\\s*");
        for (String string : operation) {
            if (!string.isEmpty())
                arrOperation.add(string);
        }
        return arrOperation;
    }

    // производится арифм. операция
    static double operation(String math_operation, Double x, Double y) throws Exception {
        double res = 0;
        switch (math_operation) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "/":
                if (y != 0) res = x / y;
                else throw new Exception("Деление на --0--!");
                break;
            case "*":
                res = x * y;
                break;
        }
        return res;
    }

    // определяем порядок расчета и обращения к спискам с числами и знаками
    static double calc(List<Double> numbers, List<String> arrOperation) throws Exception {
        int index;
        double tempCalc;
        // проводим расчеты по порядку с *|/
        while ((arrOperation.contains("*")) || (arrOperation.contains("/"))) {
            if (!arrOperation.contains("*"))
                index = arrOperation.indexOf("/");
            else if (!arrOperation.contains("/"))
                index = arrOperation.indexOf("*");
            else
                index = Math.min(arrOperation.indexOf("*"), arrOperation.indexOf("/"));

            tempCalc = operation(arrOperation.get(index), numbers.get(index), numbers.get(index + 1));
            // записываем полученный результат на место первого числа в операции
            numbers.set(index, tempCalc);
            // удаляем второе число и сам знак операции
            numbers.remove(index + 1);
            arrOperation.remove(index);
        }

        // после проводим расчеты с +|-
        while ((arrOperation.contains("+")) || (arrOperation.contains("-"))) {
            if (!arrOperation.contains("+"))
                index = arrOperation.indexOf("-");
            else if (!arrOperation.contains("-"))
                index = arrOperation.indexOf("+");
            else
                index = Math.min(arrOperation.indexOf("+"), arrOperation.indexOf("-"));

            tempCalc = operation(arrOperation.get(index), numbers.get(index), numbers.get(index + 1));
            // записываем полученный результат на место первого числа в операции
            numbers.set(index, tempCalc);
            // удаляем второе число и сам знак операции
            numbers.remove(index + 1);
            arrOperation.remove(index);
        }

        return numbers.get(0);
    }

    static void myLog(String res, int level) {
        //level = 1 - ошибки, = 2 - инфо
        Logger logger = Logger.getLogger(Task03Sem1HW.class.getName());
        try {
            FileHandler fh = new FileHandler("sem1HW/logCalc.txt", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            switch (level) {
                case 1 -> logger.log(Level.WARNING, res);
                case 2 -> logger.info(res);
            }
            fh.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите строку выражения,\nнапример, 25.5-9/3+7*2.45; 45/9 и т.д.: ");
        String expString = iScanner.nextLine();
        myLog(String.format("Пользователь ввел выражение: %s", expString),2);
        iScanner.close();

        try {
            // вывожу значения для проверки
            List<Double> numbers = strToArray(expString);
            myLog(String.format("Получили числа: %s", numbers),2);
            List<String> arrOperation = strToArrOperation(expString);
            myLog(String.format("Получили знаки: %s", arrOperation),2);

            double resCalc = calc(numbers, arrOperation);
            myLog(String.format("Результат вычисления = %.2f", resCalc),2);
            System.out.printf("Результат вычисления:\n%s = %.2f\n", expString, resCalc);

        } catch (Exception e) {
            myLog(String.format("Некорректное выражение, ошибка: %s",e.getMessage()),1);
            System.out.println("Некорректное выражение");
            System.err.println(e.getMessage());
        }

    }

}
