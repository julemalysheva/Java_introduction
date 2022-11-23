package sem1HW;

/**+Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет. */

//в моем варианте работает, только если в числе один знак ?, не больше

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
                // System.out.println(String.join("И", arrStr));
                int res = Integer.parseInt(arrStr[1].trim());
                String[] arrNum = arrStr[0].split("\\s*(\\+)\\s*");
                System.out.println("res:" + res + " Числа: " + String.join(" ", arrNum));
                boolean checkEx = false;
//если число начинается на ? - значит этот разряд предполагается, и он не может быть равен нулю
                int start1 = arrNum[0].startsWith("?") ? 1 : 0;
                int start2 = arrNum[1].startsWith("?") ? 1 : 0;
                for (int i = start1; i < 10; i++) {
                    int num1 = Integer.parseInt(arrNum[0].trim().replace("?", String.format("%d", i)));
                    // System.out.println("\nnum1 = " + num1);
                    for (int j = start2; j < 10; j++) {
                        int num2 = Integer.parseInt(arrNum[1].trim().replace("?", String.format("%d", j)));
                        // System.out.println("num2 = " + num2);

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
