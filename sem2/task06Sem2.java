package sem2;

import java.io.File;

/*Напишите метод, который определит тип (расширение) файлов из текущей папки и
выведет в консоль результат вида
			1 Расширение файла: txt
			2 Расширение файла: pdf
			3 Расширение файла: 
			4 Расширение файла: jpg
 */
public class task06Sem2 {
    public static void main(String[] args) {
        String pathProject = System.getProperty("user.dir");
        File file = new File(pathProject);
        //так мы увидим список полных путей к папкам и файлам в каталоге
        //File[] listFolder = file.listFiles();
        //System.out.println(Arrays.toString(listFolder));
        String[] listFolder = file.list();
        if (listFolder != null)
        System.out.println(makeStrFileExtensions(listFolder));
        else System.out.println("Папка пуста");
    }

    static String makeStrFileExtensions(String[] folderList){
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (String item: folderList) {
            if (item.contains(".")){
                String[] strArr = item.split("\\.");
                //1 Расширение файла: txt
                sb.append(number).append(" ").append("Расширение файла: ").append(strArr[strArr.length-1]).append("\n");
                number++;
            }
        }
        return sb.toString();
    }
}
