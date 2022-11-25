package sem2;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/*Напишите метод, который вернет содержимое текущей папки в виде массива строк.
Напишите метод, который запишет массив, возвращенный предыдущим методом в файл. 
Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, 
оно должно записаться в лог-файл.
 */

/*Если делаю запись в файл лога, выдает ошибку, пока во всех связанных методах не написать throws IOException*/
public class task05Sem2 {
    public static void main(String[] args) throws IOException  {
        //получаю папку текущего проета
        String pathProject = System.getProperty("user.dir");
        System.out.println(pathProject);
        //вызываю метод - массив строк содержимого папки
        String[] folderList = getFolderList(pathProject);
        writeFile(folderList);
        //System.out.println(String.join("\n", folderList));
        //System.out.println(String.join("\n", getFolderList("sem2")));
    }

    static void myLogger(String strLog) throws IOException {
        Logger logger = Logger.getLogger(task05Sem2.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info(strLog);

    }
    //Напишите метод, который вернет содержимое текущей папки в виде массива строк.
    static String[] getFolderList(String nameFolder){
        File dir = new File(nameFolder);
        System.out.println(dir.getAbsolutePath());
        return dir.list();
    }

    //Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
    //пока не укажу throws IOException - выдает ошибку при записи в лог файл
    static void writeFile(String[] listFolder) throws IOException {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            FileWriter f5 = new FileWriter(pathFile);
            if (listFolder.length>0){
                for (String item: listFolder) {
                    f5.write(item+"\n");
                }
                f5.flush();
            } else System.out.println("В папке ничего не обнаружено");
        } catch (Exception e){
            myLogger("Ошибка записи в файл");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
