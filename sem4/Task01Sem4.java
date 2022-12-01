package sem4;

import java.util.LinkedList;
import java.util.Scanner;

/*Реализовать консольное приложение, которое:
Принимает от пользователя строку вида
text~num
Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.


*/
public class Task01Sem4 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        LinkedList<String> stringLinkedList = new LinkedList<>();
        boolean chPrint = false;

        while (!chPrint){
            System.out.println("Введите строку: ");
            String str = myScanner.nextLine();
            String[] arr = str.split("~");
            if (arr[0].equals("print")){
                System.out.println(stringLinkedList.get(Integer.parseInt(arr[1])));
                stringLinkedList.remove(Integer.parseInt(arr[1]));
                System.out.println("Список после удаления" + stringLinkedList);
                chPrint=true;
            }
            else {
                stringLinkedList.add(Integer.parseInt(arr[1]), arr[0]);
            }
        }
        myScanner.close();
    }

}
