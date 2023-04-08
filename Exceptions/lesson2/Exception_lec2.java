package Exceptions.lesson2;

public class Exception_lec2 {
    public static void main(String[] args) {
//        String name = null;
//        System.out.println(name.length()); //lang.NullPointerException
//        Object ob = new String("123");
//        File file = (File) ob; //.ClassCastException
//        System.out.println(file);
//        String num = "123fd";
//        int res = Integer.parseInt(num); //NumberFormatException
//        System.out.println(res);

//        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(new Object()); //.UnsupportedOperationException
//т.к. emptyList неизменяемый константный объект
//        try {
//            int a = 0;
//            int b = 10 / a;
//            System.out.println("Это сообщение не будет выведено в консоль");
//        } catch (ArithmeticException e) {
//            System.out.println("Деление на ноль");
//            e.printStackTrace();
//        }
//        System.out.println("Завершение работы");

        //2 и более catch
        try {
            int a = 10;
            //a -= 10;
            int b = 42 / a;
            int[] с = {1, 2, 3};
            с[42] = 99;//.ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка индексации массива: " +
                    e);
        } finally {
            System.out.println(" block finally");
        }
        System.out.println("Пocлe блока операторов try/catch");



    }

}
