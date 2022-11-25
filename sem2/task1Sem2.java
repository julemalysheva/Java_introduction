package sem2;
//дано четное n, нужно собрать строку, где чередуются c1, c2


public class task1Sem2 {
    public static void main(String[] args) {
       makeString('q', 'w' ,6);
    }

    static String makeString(char c1, char c2, int n){
        //в данном варианте собираем в массив символов
        char[] chars = new char[n];
        for (int i = 0; i < n; i+=2) {
            chars[i] = c1;
            chars[i+1] = c2;
        }
        System.out.println("Строка из массива символов: "+ chars.toString());//вывод [C@4617c264
        System.out.println("valueOf из массива символов: "+ String.valueOf(chars)); //вывод qwqwqw
        //Arrays.toString(chars));так собирает в массив со скобками [q, w, q, w, q, w]

        //через др. инструмент, СтрингБилдер - работает корректно
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n/2; i++) {
            sb.append(c1).append(c2);
        }
        System.out.println("Через StringBuilder: "+ sb.toString());//вывод qwqw
        return sb.toString();
    }
}
