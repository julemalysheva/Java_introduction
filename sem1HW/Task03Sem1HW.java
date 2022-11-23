package sem1HW;

// import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
// import java.util.Stack;

/*Реализовать простой калькулятор */
//добавить проверку строки по регулярке при вводе или обработать исключение

public class Task03Sem1HW {

    static List<Double> strToArray(String str) {
        String[] expArr = str.trim().split("\\s*(\\+|\\*|\\/|-)\\s*");
        // // вывожу в консоль для проверки
        // for (String string : expArr) {
        // System.out.println(string);
        // }
        // здесь создавала просто массив дробных чисел, ниже пробую ArrayList
        // double[] exp = new double[expArr.length];
        // for (int i = 0; i < expArr.length; i++) {
        // exp[i] = Double.parseDouble(expArr[i]);
        // }
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < expArr.length; i++) {
            numbers.add(Double.parseDouble(expArr[i]));
        }

        return numbers;
    }

    static List<String> strToArrOperation(String str) {
        List<String> arrOperation = new ArrayList<>();
        // добавить addAll сразу из массива строк после split не получилось, видимо так
        // не работает)
        // делаю в цикле
        String[] znaki = str.split("\\s*(\\d+\\.?\\d*)\\s*");
        // System.out.println(String.join(" ", znaki));
        for (String string : znaki) {
            // если не пустая - добавляем, убираем таким образом какой-то первый пустой
            // символ [, *, -] - начало строки?
            if (!string.isEmpty())
                arrOperation.add(string);
        }
        return arrOperation;
    }

    static double operation(String math_operation, Double x, Double y) {
        double res = 0;
        if (math_operation.equals("+"))
            res = x + y;
        else if (math_operation.equals("-"))
            res = x - y;
        else if (math_operation.equals("/"))
            res = x / y;
        else if (math_operation.equals("*"))
            res = x * y;
        return res;
    }

    static double calc(List<Double> numbers, List<String> arrOperation) {
        int index = 0;
        double tempCalc;
        //проводим расчеты по порядку с *|/
        while ((arrOperation.contains("*"))||(arrOperation.contains("/"))) {
            if (arrOperation.indexOf("*") == -1)
                index = arrOperation.indexOf("/");
            else if (arrOperation.indexOf("/") == -1)
                index = arrOperation.indexOf("*");
            else
                index = (arrOperation.indexOf("*") < arrOperation.indexOf("/")) ? arrOperation.indexOf("*")
                        : arrOperation.indexOf("/");

            tempCalc = operation(arrOperation.get(index),numbers.get(index),numbers.get(index+1));  
            //записываем полученный результат на место первого числа в операции                      
            numbers.set(index, tempCalc);
            //удаляем второе число и сам знак операции
            numbers.remove(index+1);
            arrOperation.remove(index);
        }

        //после проводим расчеты с +|-
        while ((arrOperation.contains("+"))||(arrOperation.contains("-"))) {
            if (arrOperation.indexOf("+") == -1)
                index = arrOperation.indexOf("-");
            else if (arrOperation.indexOf("-") == -1)
                index = arrOperation.indexOf("+");
            else
                index = (arrOperation.indexOf("+") < arrOperation.indexOf("-")) ? arrOperation.indexOf("+")
                        : arrOperation.indexOf("-");

            tempCalc = operation(arrOperation.get(index),numbers.get(index),numbers.get(index+1));  
            //записываем полученный результат на место первого числа в операции                      
            numbers.set(index, tempCalc);
            //удаляем второе число и сам знак операции
            numbers.remove(index+1);
            arrOperation.remove(index);
        }

        return numbers.get(0);
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите строку выражения: ");
        String expString = iScanner.nextLine();
        System.out.printf("Считаем %s\n", expString);
        iScanner.close();
        // System.out.println(Arrays.toString(strToArray(expString)));
        List<Double> numbers = strToArray(expString);
        System.out.println(numbers);
        List<String> arrOperation = strToArrOperation(expString);
        System.out.println(arrOperation);
        double resCalc = calc(numbers, arrOperation);
        System.out.println(resCalc);
       // System.out.printf("Результат вычисления:\ns% = %f", expString, resCalc);

    }

}
