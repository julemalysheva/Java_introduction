package sem4HW;

import java.util.*;

/*Задание №5 (доп)
* Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
Вычислить запись если это возможно.
*/
public class Task05Sem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку выражения: ");
        String exp = scanner.nextLine();
        System.out.println("Выражение в ОПЗ: " + convertingExpToOPZ(exp));
        System.out.println("Результат вычисления: " + calcOpzExp(convertingExpToOPZ(exp)));
    }

    static boolean isDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static ArrayList<String> convertingExpToOPZ(String str){
        ArrayList<String> list = new ArrayList<>(str.length()); //результирующий список
        LinkedList<Character> stackOp = new LinkedList<>(); //стек для знаков операций
        char[] chars = str.toCharArray();
        //словарь приоритетов для знаков, пока */+-
        Map<Character,Integer> mapPriorities = new HashMap<>();
        mapPriorities.put('(',1);
        mapPriorities.put('+',2);
        mapPriorities.put('-',2);
        mapPriorities.put('*',3);
        mapPriorities.put('/',3);
       // System.out.println(mapPriorities);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isDigit(String.valueOf(ch))) {
                sb.append(ch);
                //если конец массива или след.-не число, добавляем в результир.список
                if (i == chars.length-1 || !isDigit(String.valueOf(chars[i+1]))){
                    list.add(String.valueOf(sb));
                    sb.delete(0, sb.length());
                }
            }   else if (ch == ')') { //можно добавить проверку наличия '(', иначе вызвать исключение
                    while (!stackOp.isEmpty() && stackOp.getLast() != '(') {
                        list.add(String.valueOf(stackOp.removeLast()));
                    } //скобка ( остается в конце, ее просто удаляем
                    stackOp.removeLast();//если ее нет, будет ошибка в выражении
            }   else if (mapPriorities.containsKey(ch)) {
                    if (ch == '(') { //т.е.если это откр. скобка '('; было -mapPriorities.get(ch) == 1
                        stackOp.add(ch);
                    } else if ((stackOp.isEmpty()) || (mapPriorities.get(stackOp.getLast()) < mapPriorities.get(ch))) {
                        stackOp.add(ch);
                    } else if ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
        //                пока выполн.условие - перекладываем знаки из стека в результат
                        while ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
                            list.add(String.valueOf(stackOp.removeLast()));
                        }
                        //затем кладем в стек текущий
                        stackOp.add(ch);
                    }
            }
            //например, если есть пробелы в выражении и пр.-пропускать
            else continue;//можно вызвать исключение
        }
        //все, что осталось в стеке - переносим в результир.список
        while (!stackOp.isEmpty()){
            list.add(String.valueOf(stackOp.removeLast()));
        }

        return list;
    }

    static double calcOpzExp(ArrayList<String> list){
        double res;
        double tmp;
        //в данном случае использую Stack для разнообразия, хотя можно было также LinkedList
        //тип Double для полноценного деления
        Stack<Double> doubleStack = new Stack<>();
        for (String s:list) {
            if (isDigit(s)){
                doubleStack.push(Double.parseDouble(s));
            }
            else {
                switch (s) {
                    case "+" -> {
                        res = doubleStack.pop() + doubleStack.pop();
                        doubleStack.push(res);
                    }
                    case "*" -> {
                        res = doubleStack.pop() * doubleStack.pop();
                        doubleStack.push(res);
                    }
                    case "-" -> {
                        tmp = doubleStack.pop();
                        res = doubleStack.pop() - tmp;
                        doubleStack.push(res);
                    }
                    case "/" -> {
                        tmp = doubleStack.pop();
                        res = doubleStack.pop() / tmp;
                        doubleStack.push(res);
                    }
                    default -> {
                    }
                }
            }
        }
        return doubleStack.pop();
    }

}
