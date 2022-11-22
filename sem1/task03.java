/*Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
Если общего префикса нет, вернуть пустую строку "".
 */

package sem1;

public class task03 {

    static int minStrLength(String[] arr){
        //берем за минимум длину первой строки, дальше сравниваем
        int minLength = arr[0].length();
        for (String string : arr) {
            minLength = (string.length()< minLength)? string.length(): minLength;
        }
        return minLength;
    }

    public static void main(String[] args) {
        // String[] arrStr = new String[]{"торской","соре","морюшко"};
        // String[] arrStr = new String[]{"морской","море","морюшко"};
        String[] arrStr = new String[]{"весенний","весна","веснушки","веселиться"};
        //получаем длину мин.строки - для лимита в цикле, т.к. префикс не может быть больше
        int limit = minStrLength(arrStr);
        System.out.println("limit: "+ limit);
        String temp = "",last = "",res = "";
        Boolean checkRes = false;

        for (int i=0; i<limit;i++){
        // в качестве эталона для сравнения беру подстроку 0го эл-та, т.е. первой строки массива
        //от 0 до i,т.е. последовательно 1,2,3,и т.д. до i символа - правая граница не включается, поэтому +1
            temp = arrStr[0].substring(0, i+1); 
            System.out.println("temp "+ temp);

            for (String string : arrStr) {
                if (! string.substring(0, i+1).equals(temp)) {
                    System.out.println("temp "+temp + "\nвыходим, подстроки не равны");
                    res = last; //передаем в результат предыдущую подстроку
                    checkRes = true;
                    System.out.println("res: "+ res);
                    break;
                }
            }  
            last = temp;
            // выходим из внешнего цикла, если нашли результат
            if (checkRes) break;
        }

        System.out.println("Самая длинная строка общего префикса: "+ res);
    }
}
