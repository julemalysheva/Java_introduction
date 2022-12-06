package sem5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь
*/
public class Task02Sem5 {
    public static void main(String[] args) {
        String str = "{a+]}{(d*3)}";
        System.out.println(checkBrackets(str));
    }

    static boolean checkBrackets(String str){
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put(']','[');
        brackets.put('}','{');
        brackets.put('>','<');
        Deque<Character> stack = new ArrayDeque<>();

        char[] chars = str.toCharArray();
        for (char ch: chars) {
            if (brackets.containsValue(ch)){
                stack.addLast(ch);
            }
            else if (brackets.containsKey(ch)){
                if (stack.isEmpty() || !stack.removeLast().equals(brackets.get(ch))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
