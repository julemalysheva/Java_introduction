package sem2;
/*Напишите метод, который принимает на вход строку (String) и определяет 
является ли строка палиндромом (возвращает boolean значение).
*/
public class task03Sem2 {
    public static void main(String[] args) {
        System.out.println(palindrome("Довод")); 
    }

    static boolean palindrome(String str){
        char[] chars = str.toCharArray();
        //копия массива для работы со StringBuilder
        char[] chCopy = chars.clone();
        StringBuilder sb = new StringBuilder();
        //1й способ через массив символов
        int j = chars.length-1;
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[j-i];
            chars[j-i] = temp;
        }
        System.out.println("Перевернутый массив символов: "+ String.valueOf(chars));

        //2й способ - идти с конца и собирать строку в sb
        for (int i = chCopy.length-1; i >= 0; i--) {
            sb.append(chCopy[i]);
        }
        System.out.println("StringBuilder собрали строку с конца: "+ sb.toString());

        return str.equalsIgnoreCase(sb.toString());
    }

}
