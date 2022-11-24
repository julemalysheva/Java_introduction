package sem1;
/*Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
 */
public class task05 {
    public static void main(String[] args) {
        String fr = "Добро пожаловать на курс по Java";
        String[] arrStr = fr.split(" ");
        int j = arrStr.length -1;
        for (int i = 0; i < arrStr.length/2; i++) {
            String temp = arrStr[i];
            arrStr[i] = arrStr[j-i];
            arrStr[j-i] = temp;
        }
        System.out.println(String.join(" ", arrStr));
    }
}
