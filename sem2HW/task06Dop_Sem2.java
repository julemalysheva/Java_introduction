package sem2HW;
/*Напишите метод, который определит тип (расширение) файлов из текущей папки и
выведет в консоль результат вида
			1 Расширение файла: txt
			2 Расширение файла: pdf
			3 Расширение файла:
			4 Расширение файла: jpg
 */

import java.io.File;

public class task06Dop_Sem2 {
    public static void main(String[] args) {
        String pathProject = System.getProperty("user.dir");
        File file = new File(pathProject);
        File[] listFiles = file.listFiles();
        System.out.println(makeStrFilesExtensions(listFiles));
    }

    static String makeStrFilesExtensions(File[] list){
        StringBuilder sb = new StringBuilder();

        if (list != null) {
            int number = 1;

            for (File fl:list) {
                if (fl.isFile()) { //если файл, а не папка
                    //собираем строку
                    String[] strArr = fl.getName().split("\\.");
                    //1 Расширение файла: txt
                    sb.append(number).append(" ").append("Расширение файла: ").append(strArr[strArr.length-1]).append("\n");
                    number++;
                }
            }
        } else sb.append("Нет файлов");
        return sb.toString();
    }

}
