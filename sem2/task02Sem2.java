package sem2;

/*Написать метод, который сжимает строку. Пример, вход aaaabbbcdd 
 * Вывод: a4b3c1d2
 * Разбить на массив символов, а собирать в СтрингБилдер
*/
public class task02Sem2 {
    public static void main(String[] args) {
        System.out.println(encodeStr(("aaaabbbcdd")));//a4b3c1d2
    }

    static String encodeStr(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char templ = ch[0];
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == templ) {
                count++;
            } else {
                sb.append(templ).append(count);
                templ = ch[i];
                count = 1;
            }
        }
        sb.append(templ).append(count);
        return sb.toString();
    }
}
