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
        //можно задать вспом.список операций - для проверки вхождения символов в него
        //или же лучше map, где символ будет ключом, тогда можно проверять на содержание ключа
        //а значение приоритет операции для проверки правила сборки результирующего списка
        StringBuilder sb = new StringBuilder();
        for (char ch: chars) {
            if(isInteger(String.valueOf(ch))){ //или создавать каждый раз? - проверить
                sb.append(ch);
                //пробую добавить последнее - скорее всего переделать под for i
                list.add(String.valueOf(sb));
                sb.delete(0,sb.length());
            }
            else {
//                if (!sb.isEmpty()) {
//                    list.add(String.valueOf(sb));
//                    sb.delete(0,sb.length());
//                }
                if ((stackOp.isEmpty()) || (mapPriorities.get(stackOp.getLast()) < mapPriorities.get(ch))) {
                    stackOp.add(ch);
                } else if ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
                //или вызывать здесь отдельно др. метод для этого?
                    while ((!stackOp.isEmpty()) && (mapPriorities.get(stackOp.getLast()) >= mapPriorities.get(ch))) {
                        list.add(String.valueOf(stackOp.removeLast()));
                    }
                    //в цикле выше, пока выполн.условие - перекладываем знаки из стека в результат,
                    //затем кладем в стек текущий
                    stackOp.add(ch);
                }
                else if (mapPriorities.get(ch)==1){ //т.е. это откр. скобка
                    stackOp.add(ch);
                } else if (ch == ')') { //можно добавить проверку наличия '(', иначе вызвать исключение
                    while (stackOp.getLast()!='('){
                        list.add(String.valueOf(stackOp.removeLast()));
                    } //скобка ( остается в конце, ее просто удаляем
                    stackOp.removeLast();//если ее нет, будет ошибка в выражении
                }
            }
        }
        while (!stackOp.isEmpty()){
            list.add(String.valueOf(stackOp.removeLast()));
        }
        //добавляем крайнее собранное число - проверить логику конвертации
        //!!!так не пойдет - нужно внутри проверять на конец строки
        if (!sb.isEmpty()) {
            list.add(String.valueOf(sb));
//            sb.delete(0,sb.length());
        }


        return list;
    }

}
