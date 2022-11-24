package lec.lec2;

import java.io.File;

public class fileSystemDemo {
    public static void main(String[] args) {
        //получаем системный путь к папке - в рвзных ОС выглядит по разному
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.txt");
        //не совсем поняла, что мы здесь создали? потенциальный путь для потенциального файла?
        //т.к. сам файл не создался, не записался
        File f3 = new File(pathFile);
        System.out.println(f3.getAbsolutePath());

        //A:\GB\Java\Java_introduction\file.txt - в моем случае
        //в Linux это будет по другому - учитывать
    }
}
