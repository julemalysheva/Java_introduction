package sem5;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*Написать метод, который переведёт данное целое число в римский формат.
Например, 2022 = MMXXII
 1994 -> MCMXCIV
*/
public class Task04Sem5 {
    public static void main(String[] args) {
        int num = 2922;
        System.out.println(convertToRoman(num));
    }
    //здесь явно описываю каждый раз, но подумать, быть может использовать treemap, где есть возможность
    //при опр-х условиях обращаться к ближайшему меньшему или большему - для универсальности решения
    static String convertToRoman(int num){
        HashMap<Integer,Character> convert = new HashMap<>();
        convert.put(1, 'I');
        convert.put(5, 'V');
        convert.put(10,'X');
        convert.put(50,'L');
        convert.put(100,'C');
        convert.put(500,'D');
        convert.put(1000,'M');
        //или в билдере добавлять в начало, к единицам десятки впереди и т.д.?
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer, Integer> categoriesNum = new LinkedHashMap<>();
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
        //добавляю тысячи
        for (int j = 0; j < categoriesNum.get(1000); j++) {
            sb.append(convert.get(1000));
        }
        //работаем с сотнями
        if (categoriesNum.get(100)>=5 && categoriesNum.get(100)<9) {
            sb.append(convert.get(500));
            for (int j = 0; j < categoriesNum.get(100)-5; j++) {
                sb.append(convert.get(100));
            }
        }
        else if (categoriesNum.get(100)>0 && categoriesNum.get(100)<4) {
            for (int j = 0; j < categoriesNum.get(100); j++) {
                sb.append(convert.get(100));
            }
        } else if (categoriesNum.get(100)==9) {
            sb.append(convert.get(100)).append(convert.get(1000));
        }
        //sb.reverse(); //MCMM -не пойдет, разворот посимвольно
        System.out.println(sb); //или можно развернуть стринг билдер? если это типа массив строк, а не посимвольно
        return sb.toString();
    }
}
