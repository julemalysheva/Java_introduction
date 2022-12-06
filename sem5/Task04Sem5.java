package sem5;

import java.util.*;

/*Написать метод, который переведёт данное целое число в римский формат.
Например, 2022 = MMXXII
 1994 -> MCMXCIV
 2922; //MMCMXXII
 583 - DLXXXIII
*/
public class Task04Sem5 {
    public static void main(String[] args) {
        int num = 583;
        System.out.println(convertToRoman(num));
    }

    static String convertToRoman(int num){
        HashMap<Integer,Character> convert = new HashMap<>();
        convert.put(1, 'I');
        convert.put(5, 'V');
        convert.put(10,'X');
        convert.put(50,'L');
        convert.put(100,'C');
        convert.put(500,'D');
        convert.put(1000,'M');
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> categoriesNum = new TreeMap<>();
        int i = 1;
        while (num!=0){
            categoriesNum.put(i,num%10);
            i*=10;
            num/=10;
        }
        //если LinkedHashMap или TreeMap, то порядок такой{1=2, 10=2, 100=9, 1000=2} - можно ли развернуть?
        //или определить свой порядок хранения элементов?
        //или добавлять в ЛинкедЛист например, вперед
        System.out.println(categoriesNum);

        while (!categoriesNum.isEmpty()) {
            Map.Entry<Integer, Integer> lastEntry = categoriesNum.pollLastEntry();
            Integer key = lastEntry.getKey();
            Integer val = lastEntry.getValue();
//        System.out.println("Removed lastEntry : " + lastEntry );}
            if (key == 1000){
                //добавляю тысячи - если значение в цикле, т.е. >0
                for (int j = 0; j < val; j++) {
                    sb.append(convert.get(key));
            }} else {
            //работаем с сотнями, десятками и единицами
            if (val >= 5 && val < 9) {
                sb.append(convert.get(5*key));
                for (int j = 0; j < val - 5; j++) {
                    sb.append(convert.get(key));
                }
            } else if (val > 0 && val < 4) {
                for (int j = 0; j < val; j++) {
                    sb.append(convert.get(key));
                }
            } else if (val == 9) {
                sb.append(convert.get(key)).append(convert.get(10*key));
            } else if (val == 4) {
                sb.append(convert.get(key)).append(convert.get(5*key));
            }
            }
        }
        return sb.toString();
    }
}
