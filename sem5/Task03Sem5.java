package sem5;

import java.util.HashMap;

/*Написать метод, который переведет число из римского формата записи в арабский.
 Например, MMXXII = 2022
 MCMXCIV -> 1994
 */
public class Task03Sem5 {
    public static void main(String[] args) {
        String roman = "MMXXII";
        System.out.println(parseRoman(roman));
    }

    static int parseRoman(String roman){
        HashMap<Character,Integer> convert = new HashMap<>();
        convert.put('I', 1);
        convert.put('V', 5);
        convert.put('X', 10);
        convert.put('L', 50);
        convert.put('C', 100);
        convert.put('D', 500);
        convert.put('M', 1000);

        char[] chars = roman.toCharArray();
        int numArab;
        int sumArab = 0;
        for (int i = 0; i < chars.length; i++) {
            numArab = convert.get(chars[i]);
            if((i + 1) < chars.length && numArab < convert.get(chars[i+1]))
                sumArab -= numArab;
            else
                sumArab += numArab;
        }
        return sumArab;
    }
}
