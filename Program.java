// /**
//  * program
//  */
// public class program {

//     public static void main(String[] args) {
//         // нужно обязательно идентифицировать переменную
//         // String s ;
//         // s= "s"+"1";
//         // System.out.println(s);
//         // short age = 10;
//         // int salary = 123456;
//         // // здесь нужно f
//         // float e = 2.7f;
//         // double pi = 3.1415;
//         // System.out.println(age);
//         // System.out.println(salary);
//         // System.out.println(e);
//         // System.out.println(pi);
//         // // если указать число а не символ, например '{'. то происходит неявное преобразование типа данных
//         // char ch = 123;
//         // System.out.println(ch);
//         // int a = 123;
//         // double b = a;
//         // // a = b; так неявное преобразование не получится, нужно по другому, из int в double да, обратно нет
//         // System.out.println(a);
//         // boolean flag1 = 123 <= 234;
//         // System.out.println(flag1);  // true
//         // boolean flag2 = 123 >= 234 || flag1;
//         // System.out.println(flag2);  // true
//         // boolean flag3 = flag1 ^ flag2;
//         // System.out.println(flag3);  // false

//     }
// }

// public class Program {
//     public static void main(String[] args) {
//         var a = 123;
//         System.out.println(a);  // 123
//         var d = 123.456;
//         System.out.println(d);  // 123.456
//         System.out.println(getType(a));  // Integer
//         System.out.println(getType(d));  // Double
//         d = 1022;
//         System.out.println(d);  // 1022

//         // d = "mistake";
//         //error: incompatible types:
//         //String cannot be converted to double
//     } 

//     // любой метод д.б. частью класса

//     static String getType(Object o){
//         return o.getClass().getSimpleName();
//     }
// }

// class Program {
//     public static void main(String[] args) {   
//         String s = "qwer";
//         System.out.println(s.charAt(1));
//         // Character.
//         // s[0] так нельзя обратится напрямую к символу строки, через обертку и метод выше

//     System.out.println(Integer.MAX_VALUE); // 2147483647
//     System.out.println(Integer.MIN_VALUE); // -2147483648

//       }
// }

/**
 * Program
 * Присваивание: =
 * 
 * Арифметические: *, /, +, -, %, ++, --
 * 
 * Операции сравнения: <, >, ==, !=, >=, <=
 * 
 * Логические операции: ||, &&, ^, !
 * 
 * Побитовые операции <<, >>, &, |, ^
 */
// public class Program {

//     public static void main(String[] args) {
// int a = 5;//101
// int b = 2;//010
// //далее побитово ИЛИ 111 - это 7
// //если & побитово И 000 - 0
// int c = a & b; //7 a или b, 0 a И b
// System.out.println(c);
// String s = "qwer";
// boolean b = s.length()>=5 & s.charAt(4)=='1';
// System.out.println(b);

//     }
// }
// introduction
/**
 * Program
 */
// public class Program {

//     public static void main(String[] args) {
//         int[] arr = new int[10];
//         boolean[] arrBool = new boolean[5];
//         String[] arrStr = new String[4];
//         System.out.println(arr.length);//10
//         // по умолчанию в числовых массивах значения 0, для строк и ссылочных типов null
//         System.out.println(arr[3]);//0 по умолчанию
//         System.out.println(arrBool[4]);//false по умолчанию
//         System.out.println(arrStr[0]);//null по умолчанию
// // ниже в [] не нужно указывать размер, т.к. java это понимает из значений
//         int[] arr2 = new int[] {1,2,3,4,5,6};
//         System.out.println(arr2.length);//6
//         String f = arr2.toString();
//         System.out.println(f);//[I@4617c264 ??
//     }
// }

// public class Program {
//     public static void main(String[] args) {

//         int[] arr[] = new int[3][5];
//         for (int[] line : arr) {
//             for (int item : line) {
//                 System.out.printf("%d ", item);
//             }
//             System.out.println();
//         }
// подобным образом можно определять массивы массивов
// int[][] arr = new int[3][5];

// for (int i = 0; i < arr.length; i++) {
//     for (int j = 0; j < arr[i].length; j++) {
//         System.out.printf("%d ", arr[i][j]);
//     }
//     System.out.println();
// }

//     }
// }

// public class Program {
//     public static void main(String[] args) {
//         // неявное преобразование
//         int i = 123; double d = i;
//         System.out.println(i);  // 123
//         System.out.println(d);  // 123.0
//         // явное
//         d = 3.1415; i = (int)d;
//         System.out.println(d);  // 3.1415
//         System.out.println(i);  // 3
//         d = 3.9415; i = (int)d;
//         System.out.println(d);  // 3.9415
//         System.out.println(i);  // 3
//         byte b = Byte.parseByte("123");
//         System.out.println(b);  // 123
//         // внимательно с переполнением
//         b = Byte.parseByte("1234");
//         System.out.println(b);  // NumberFormatException: Value out of range
//     }
//  }

// // Строки
// import java.util.Scanner;
// public class Program {
//    public static void main(String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("name: ");
//        String name = iScanner.nextLine();
//        System.out.printf("Привет, %s!\n", name);
//        iScanner.close();
//    }
// }

/**
 * Program
 */

// import java.util.Scanner;
// public class Program {
//     public static void main(String[] args) {
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("int a: ");
//         int x = iScanner.nextInt();
//         System.out.printf("double a: ");
//         double y = iScanner.nextDouble();
//         System.out.printf("bool a: ");
//         boolean y1 = iScanner.nextBoolean();
//         System.out.println(y1);
//         System.out.printf("%d + %f = %f", x, y, x + y);
//         iScanner.close();
// }}

// Проверка на соответствие получаемого типа
// import java.util.Scanner;

// public class Program {
//     public static void main(String[] args) {
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("int a: ");
//         // в этот флаг мы получаем значение True если тип int и дальше можем его
//         // считывать
//         boolean flag = iScanner.hasNextInt();
//         System.out.println(flag);
//         if (flag) {
//             int i = iScanner.nextInt();
//             System.out.println(i);
//             iScanner.close();
//         }
//         else System.out.println("Некорректный ввод");
//     }
// }

// public class Program {
//     public static void main(String[] args) {
//         // int a = 1, b = 2;
//         // int c = a + b;
//         // String res = a + " + " + b + " = " + c;
//         // System.out.println(res);
//         int a = 1, b = 2;
//         int c = a + b;
//         // для того чтоб положить куда нибудь форматированную строку, нужно указать String.format
//         String res = String.format("%d + %d = %d \n", a, b, c);
//         System.out.printf("%d + %d = %d \n", a, b, c);
//         System.out.println(res);
// // количество знаков после запятой
//         float pi = 3.1415f;
//         System.out.printf("%f\n", pi);    // 3,141500
//         System.out.printf("%.2f\n", pi);  // 3,14
//         System.out.printf("%.3f\n", pi);  // 3,141
//         System.out.printf("%e\n", pi);    // 3,141500e+00
//         System.out.printf("%.2e\n", pi);  // 3,14e+00
//         System.out.printf("%.3e\n", pi);  // 3,141e+00


//     }
// }
// // сколько строк здесь получили?
// // конкатенацию строк лучше переписывать, дает просадку, для это есть
// // соответствующие типы, например, Стринг Билдер, но об этом позже

// функции и методы
// public class Program {
//     static void sayHi() {
//         System.out.println("hi!");
//     }
//     static int sum(int a, int b) {
//         return a+b;
//     }  
//     static double factor(int n) {
//         if(n==1)return 1;
//         return n * factor(n-1);
//     }
//     public static void main(String[] args) {
//         sayHi(); // hi!
//         System.out.println(sum(1, 3)); // 4
//         System.out.println(factor(5)); // 120.0
//     }}
    // здесь технически не обязательно описывать методы и ф-ции выше вызова?

    // public class Program {
    //     public static void main(String[] args) {
    //         int a = 1;
    //         int b = 2;
    //         int c;
    //         if (a > b) {
    //             c = a;
    //         } else {
    //             c = b;
    //         }
    //         System.out.println(c);
    //     }
    // }    

    // public class Program {
    //     public static void main(String[] args) {
    //         int a = 1;
    //         int b = 2;
    //         int min = a < b ? a : b;
    //         System.out.println(min);
    //     }
    // }
    
    // import java.util.Scanner;
    // public class Program {
    //     public static void main(String[] args) {
    //         int mounth = value;
    //         String text = "";
    //         // break обязательно
    //         // можно повторять варианты для одного действия
    //         switch (mounth) {
    //             case 1:
    //                 text = "Autumn";
    //                 break;
    //         ...
    //         // дефолт не обязательно
    //             default:
    //                 text = "mistake";
    //                 break;
    //         }
    //         System.out.println(text);
    //         iScanner.close();
    //     }
    // }    

    // public class Program {
    //     public static void main(String[] args) {
    //         int value = 321;
    //         int count = 0;
    
    //         while (value != 0) {
    //             value /= 10;
    //             count++;
    //         }
    //         System.out.println(count);
    //     }
    // }
    
    // public class Program {
    //     public static void main(String[] args) {
    //         int value = 321;
    //         int count = 0;
    
    //         do {
    //             value /= 10;
    //             count++;
    //         } while (value != 0);
    //         System.out.println(count);
    //     }
    // }

    // public class Program {
    //     public static void main(String[] args) {
    
    //         for (int i = 0; i < 5; i++) {
    //             for (int j = 0; j < 5; j++) {
    //                 System.out.print("* ");
    //             }
    //             System.out.println();
    //         }        }
    // }

    // public class Program {
    //     public static void main(String[] args) {
    
    //         int arr[] = new int[10];
    //         // сниппетом определяется как forech
    //         for (int item : arr) {
    //             System.out.printf("%d ", item);
    //         }
    //         System.out.println();
    //         // в обычном for можно обращаться по индексам и менять значения, 
    //         // в for in такого сделать нелья
    //     }
    // }
//     import java.io.FileWriter;
// import java.io.IOException;
// public class Program {
//     public static void main(String[] args) {
//         // идентифицировали экз.класса при помощи конструктора, передав имя файла и флаг дозаписи
//         // false - создадим всегда новый, при true ищем этот файл и пытаемся дозаписать
//         try (FileWriter fw = new FileWriter("file.txt", false)) {
//             // записываем
//             fw.write("line 1");
//             // добавляем
//             fw.append('\n');
//             fw.append('2');
//             fw.append('\n');
//             fw.write("line 3");
//             // принудительно записали методом flush, в большинстве случаем нужно 
//             // еще закрывать работу с файлом
//             fw.flush();
//         } catch (IOException ex) {
//             System.out.println(ex.getMessage());
//         }
//     } }
//     // записали
// //     line 1
// // 2
// // line 3

// import java.io.*;
// public class Program {
//     public static void main(String[] args) throws Exception {
//         FileReader fr = new FileReader("file.txt");
//         int c;
//         while ((c = fr.read()) != -1) {
//             char ch = (char) c;
//             if (ch == '\n') {
//                 System.out.print(ch);
//             } else {
//                 System.out.print(ch);
//             }
//         }
//         // обязательно нужно закрыть
//         fr.close();
//     } }

// import java.io.*;

// public class Program {
// // для каждого типа записи и чтения используется свой опр.класс
// // также упрощаем обработку ошибки throws Exception 
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new FileReader("file.txt"));
//         String str;
//         while ((str = br.readLine()) != null) {
//             System.out.printf("== %s ==\n", str);
//         }
//         br.close();
//     }
// }

//можно попробовать использовать стек, как я делала с c# или как в примере, но он не корректный
// public class Program {
// import java.util.Stack;
// import java.util.Scanner;


// public static void main(String[] args) {
//     Scanner iscanner = new Scanner(System.in);
//     String exp[] = iscanner.nextLine().split(" ");
//     iscanner.close();
//     Stack<String> ops = new Stack<String>();
//     Stack<Double> vals = new Stack<Double>();

//     for (int i = 0; i < exp.length; i++) {
//         String s = exp[i];
//         if (s.equals("(")) {
//         } else if (s.equals("+") || s.equals("*")) {
//             ops.push(s);
//         } else if (s.equals(")")) {
//             getComp(ops, vals);
//         } else {
//             vals.push(Double.parseDouble(s));
//         }
//     }
//     getComp(ops, vals);
//     System.out.println(vals.pop());
// }

// private static void getComp(Stack<String> ops, Stack<Double> vals) {
//     String op = ops.pop();
//     if (op.equals("+")) {
//         vals.push(vals.pop() + vals.pop());
//     } else if (op.equals("*")) {
//         vals.push(vals.pop() * vals.pop());
//     }
// }
// }