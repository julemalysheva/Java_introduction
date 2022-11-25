package sem2;

import java.util.Scanner;

/*Напишите метод, который принимает на вход строку (String) и определяет 
является ли строка палиндромом (возвращает boolean значение).
*/
public class task03Sem2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        /*
         * При вводе столкнулась с неверным форматом
         * Введите строку: Довод
         * ввели: ?????
         * Перевернутый массив символов: ?????
         * StringBuilder собрали строку с конца: ?????
         * Как исправить?
         */
        System.out.print("Введите строку: ");
        String strInput = iScanner.nextLine();
        System.out.println("ввели: " + strInput);
        iScanner.close();
        System.out.println(palindrome(strInput));
        System.out.println("3 вариант: "+palindrome2("рвал дед лавр"));
    }

    static boolean palindrome(String str) {
        char[] chars = str.toCharArray();
        // копия массива для работы со StringBuilder
        char[] chCopy = chars.clone();
        StringBuilder sb = new StringBuilder();
        // 1й способ через массив символов
        int j = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[j - i];
            chars[j - i] = temp;
        }
        System.out.println("Перевернутый массив символов: " + String.valueOf(chars));

        // 2й способ - идти с конца и собирать строку в sb
        for (int i = chCopy.length - 1; i >= 0; i--) {
            sb.append(chCopy[i]);
        }
        System.out.println("StringBuilder собрали строку с конца: " + sb.toString());


        return str.equalsIgnoreCase(sb.toString());
    }

    //3 вариант - цикл по самой строке и извлечение символов, сравнение первого и крайнего и .т.д к центру
    static boolean palindrome2(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }


}
