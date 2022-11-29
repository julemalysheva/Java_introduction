import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

// public class lec3 {
// public static void main(String[] args) {
// Тип данных
// Object o = 1; GetType(o); // java.lang.Integer
// o = 1.2; GetType(o); // java.lang.Double

// System.out.println(Sum(1, 2));
// System.out.println(Sum(1.0, 2));
// System.out.println(Sum(1, 2.0));
// System.out.println(Sum(1.2, 2.1));

// //Итератор - отсылка

// List<Integer> list = List.of(1, 12, 123, 1234, 12345);

// for (int item : list) { System.out.println(item); }
// Iterator<Integer> col = list.iterator();

// while (col.hasNext()) {
// System.out.println(col.next());

// }

// // List<Integer> list = List.of(1, 12, 123, 1234, 12345);

// // for (int item : list) { System.out.println(item); }
// // Iterator<Integer> col = list.iterator();

// // while (col.hasNext()) {
// // //System.out.println(col.next());
// // col.next();
// // col.remove();
// // }

// }

// //здесь мы описываем метод в целом для объекта, возвращая его тип данных
// //таким образом, упаковав данные сначала в объект, мы можем вызывать этот
// метод для любого типа
// static void GetType(Object obj) {
// System.out.println(obj.getClass().getName());

// }
// static Object Sum(Object a, Object b) {
// //ниже проверяем, если a b принадлежат к типу Double
// if (a instanceof Double && b instanceof Double) {
// //внутри скобок мы должны скастовать/преобразовать к типу Double,
// //провести вычисления и обратно преобразовать к Object (не обязательно)
// return (Object)((Double) a + (Double) b);
// } else if(a instanceof Integer && b instanceof Integer) {
// return (Object)((Integer) a + (Integer) b);
// } else return 0;

// Пример, что происходит с памятью при добавлении элементов в массив

// int[] a = new int[] { 1, 9 };
// int[] b = new int[3];
// System.arraycopy(a, 0, b, 0, a.length);

// for (int i : a) { System.out.printf("%d ", i);} // 1 9
// System.out.println();

// for (int j : b) { System.out.printf("%d ", j);} //1 9 0
// }

// static int[] AddItem(int[] array, int item) {
// int length = array.length;
// int[] temp = new int[length + 1];
// System.arraycopy(array, 0, temp, 0, length);
// temp[length] = item;
// return temp;
// }
// public static void main(String[] args) {
// int[] a = new int[] { 0, 9 };
// for (int i : a) { System.out.printf("%d ", i); } //0 9
// System.out.println();
// a = AddItem(a, 2);
// a = AddItem(a, 3);
// for (int j : a) { System.out.printf("%d ", j); }//0 9 2 3
// System.out.println();

// }

// public static void main(String[] args) {
// ArrayList list = new ArrayList(); //ArrayList можно создать как List, или как
// ArrayList
// list.add(2809);
// list.add("string line");
// for (Object o : list) {
// System.out.println(o);
// // Проблема извлечения данных
// }
// // лучше явно указывать тип через угловые скобки <> Обобщения
// List<Integer> list = new ArrayList<Integer>();//справа <Integer> можно не писать
// list.add(1);
// list.add(123);
// //в сыром типе можно положить и др. тип данных
// // list.add("string line");
// for (Object o : list) {
//     System.out.println(o);
//     // Проблема извлечения данных
// }

//     }
// }

// import java.util.Arrays;
// import java.util.List;

public class lec3 {
    public static void main(String[] args) {
        // int day = 29;
        // int month = 9;
        // int year = 1990;
        // Integer[] date = { day, month, year };
        // List<Integer> d = Arrays.asList(date);
        // System.out.println(d); // [29, 9, 1990]

        // StringBuilder day = new StringBuilder("28");
        // StringBuilder month = new StringBuilder("9");
        // StringBuilder year = new StringBuilder("1990");
        // //массив StringBuilder
        // StringBuilder[] date = { day, month, year };
        // //на его основе коллекцию
        // List<StringBuilder> d = Arrays.asList(date);
        // System.out.println(d); //[28, 9, 1990]
        // //далее если изменить значение конкретного э-та массива
        // date[1] = new StringBuilder("09");
        // System.out.println(d); // [29, 09, 1990]
        // //массив date, коллекция d - меняется при изменении массива date,
        // //на основе которой создана

        // Character value = null;
        // List<Character> list1 =
        // List.of('S', 'e', 'r', 'g', 'e', 'y');
        // System.out.println(list1); //[S, e, r, g, e, y]
        // //List созданный при помощи List.of нельзя изменить
        // //list1.remove(1); // java.lang.UnsupportedOperationException
        // List<Character> list2 = List.copyOf(list1);
        // System.out.println(list2); //

        List<Integer> list = List.of(1, 12, 123, 1234, 12345);
        // 1вариант - цикл foreach
        for (int item : list) {
            System.out.println(item);
        }

        // 2 вариант, Итератор в цикле while (col.hasNext())
        Iterator<Integer> col = list.iterator();
        while (col.hasNext()) {
            // дай след.элемент
            System.out.println(col.next());
            // col.next(); здесь ждет Exception, внтури Итератора нельзя повтоно смотреть
            // col.remove(); след-щий или удалять элемент
        }

    }
}
