package sem5;

import java.util.HashMap;

/*Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет.
Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
(Например, add - egg изоморфны)
буква может не меняться, а остаться такой же. (Например, note - code)
Пример 1:
Input: s = "foo", t = "bar"
Output: false
Пример 2:
Input: s = "paper", t = "title"
Output: true
*/
public class Task01Sem5 {
    public static void main(String[] args) {
        String s1 = "foo";
        String s2 = "bar";
        System.out.println(checkIsomorph(s1, s2));
    }

    static boolean checkIsomorph(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        HashMap<Character,Character> charHashMap = new HashMap<>();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (!charHashMap.containsKey(chars1[i])){
                charHashMap.put(chars1[i],chars2[i]);
            }
            else if (!charHashMap.get(chars1[i]).equals(chars2[i])) {
                return false;
            }
        }
        return true;
    }
}

