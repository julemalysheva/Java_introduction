package sem1;

import java.util.Scanner;
import java.time.LocalDateTime;


public class Task01 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = iScanner.nextLine();
        System.out.println(LocalDateTime.now().getHour());
        int hour = LocalDateTime.now().getHour();
        if ((hour>=5) && (hour <12)){
            System.out.printf("Доброе утро, %s!\n", name);
        }
        else if ((hour>=12) && (hour <18)){
            System.out.printf("Добрый день, %s!\n", name);
        }
        else if ((hour>=18) && (hour <23)){
            System.out.printf("Добрый вечер, %s!\n", name);
        }
        else {
            System.out.printf("Доброй ночи, %s!\n", name);
        }

        iScanner.close();
    }
}
