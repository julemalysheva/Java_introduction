package sem1HW;

/**+Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет. */

//в моем варианте работает, только если в числе один знак ?, не больше, или отсутствует совсем
//предположила, что по условию после знака = всегда какое-то число, без ?

import java.util.Scanner;

public class Task04Sem1HW {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите строку выражения: ");
        String primer = iScanner.nextLine();
        iScanner.close();
        // в регулярке я не очень уверена)) но вроде работает)
        boolean result = primer.matches(
                "((\\?*\\d+\\?*)|(\\d+\\?*\\d+))\\s*(\\+)\\s*((\\?*\\d+\\?*)|(\\d+\\?*\\d+))\\s*(\\=)\\s*\\d+");
        System.out.println(result);
        if (result) {
            try {
                String[] arrStr = primer.split("=");
                int res = Integer.parseInt(arrStr[1].trim());
                String[] arrNum = arrStr[0].split("\\s*(\\+)\\s*");
                System.out.println("res:" + res + " Числа: " + String.join(" ", arrNum));
                boolean checkEx = false;
//если число начинается на ? - значит этот разряд предполагается, и он не может быть равен нулю
                int start1 = arrNum[0].startsWith("?") ? 1 : 0;
                int start2 = arrNum[1].startsWith("?") ? 1 : 0;
                //добавляю условие числа прохождения цикла в зависимости от содержания ? в числе
                int end1 = (arrNum[0].indexOf("?")==-1)? start1+1 : 10;
                int end2 = (arrNum[1].indexOf("?")==-1)? start2+1 : 10;

                for (int i = start1; i < end1; i++) {
                    int num1 = Integer.parseInt(arrNum[0].trim().replace("?", String.format("%d", i)));
                    
                    for (int j = start2; j < end2; j++) {
                        int num2 = Integer.parseInt(arrNum[1].trim().replace("?", String.format("%d", j)));

                        if (num1 + num2 == res) {
                            checkEx = true;
                            System.out.printf("Выражение %s является верным равенством\nпри значениях %d + %d = %d\n",
                                    primer, num1, num2, res);
                        }
                    }
                }
                if (!checkEx)
                    System.out.println("Решения нет");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так...");
                System.out.println(e.getMessage());
            }

        } else
            System.out.println("Некорректное выражение");
    }
}
