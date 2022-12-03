package sem4HW;

import java.util.*;

/*Задание №5 (доп)
* Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
Вычислить запись если это возможно.
*/
public class Task05Sem4 {
    public static Map<Character,Integer> mapPriorities = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку выражения: ");
        String exp = scanner.nextLine();
        System.out.println("Выражение в ОПЗ: " + convertingExpToOPZ(exp));
    }

    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static ArrayList<String> convertingExpToOPZ(String str){
        ArrayList<String> list = new ArrayList<>(str.length());
        LinkedList<Character> stackOp = new LinkedList<>();
        char[] chars = str.toCharArray();
        mapPriorities.put('(',1);
        mapPriorities.put('+',2);
        mapPriorities.put('-',2);
        mapPriorities.put('*',3);
        mapPriorities.put('/',3);
       // System.out.println(mapPriorities);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isInteger(String.valueOf(ch))) {
                sb.append(ch);
                //если конец массива или след.-не число, добавляем в результир.список
                if (i == chars.length-1 || !isInteger(String.valueOf(chars[i+1]))){
                    list.add(String.valueOf(sb));
                    sb.delete(0, sb.length());
                }
            }   else if (ch == ')') { //можно добавить проверку наличия '(', иначе вызвать исключение
                    while (!stackOp.isEmpty() && stackOp.getLast() != '(') {
                        list.add(String.valueOf(stackOp.removeLast()));
                    } //скобка ( остается в конце, ее просто удаляем
                    stackOp.removeLast();//если ее нет, будет ошибка в выражении
            }   else if (mapPriorities.containsKey(ch)) {
                    if ((stackOp.isEmpty()) || (mapPriorities.get(stackOp.getLast()) < mapPriorities.get(ch))) {
                        stackOp.add(ch);
                    } else if ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
        //                пока выполн.условие - перекладываем знаки из стека в результат
                        while ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
                            list.add(String.valueOf(stackOp.removeLast()));
                        }
                        //затем кладем в стек текущий
                        stackOp.add(ch);
                    } else if (ch == '(') { //т.е.если это откр. скобка '('-mapPriorities.get(ch) == 1
                        stackOp.add(ch);
                    }
            }
            //например, если есть пробелы в выражении и пр.-пропускать
            else continue;
        }
        //все, что осталось в стеке - переносим в результир.список
        while (!stackOp.isEmpty()){
            list.add(String.valueOf(stackOp.removeLast()));
        }

        return list;
    }

}
