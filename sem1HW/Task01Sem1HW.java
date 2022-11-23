package sem1HW;
import java.util.Scanner;

/**
 * Task01Sem1HW
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 * 
 */
public class Task01Sem1HW {

    //получаем и проверяем число с пользовательского ввода
    static int inputNum(String strInput) {
        Boolean chNum = false;
        int numInput=0;

        while (!chNum) {
            Scanner iScanner = new Scanner(System.in);
            System.out.printf(strInput);
            chNum = iScanner.hasNextInt();
            if (chNum) {
                numInput = iScanner.nextInt();
                if (numInput<0) {
                    System.out.println("Введите положительное число");
                    chNum = false;
                }
                else iScanner.close();
            }
            else System.out.println("Некорректный ввод");
            }

        return numInput;
    }


    static int triangularNumber(int n){
        int trNum = n*(n+1)/2;
        return trNum;
    }        

    static int factorial (int n){
        if (n == 0) return 1;
        else return n*factorial(n-1);
    }

    public static void main(String[] args) {
        int n = inputNum("\nВведите n: ");
        System.out.printf("Треугольное число %d = %d\n", n, triangularNumber(n));
        System.out.printf("Факториал %d! = %d\n", n, factorial(n));
    }
}