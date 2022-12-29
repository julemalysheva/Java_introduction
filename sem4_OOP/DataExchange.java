package sem4_OOP;

import java.io.*;

//предназначен для описания логики обмена данными с файлами
//по хорошему здесь прописать поведение - выгрузка/загрузка, а нюансы в классах разных форматов
//но пока не успеваю, пробую только csv
public class DataExchange {
    public static void csvWriter()  {
        String path = "A:\\GB\\Java\\Java_introduction\\sem4_OOP\\task.csv";
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(path,false);

        csvWriter.append("id");
        csvWriter.append(",");
        csvWriter.append("dateOfAdding");
        csvWriter.append(",");
        csvWriter.append("timeOfAdding");
        csvWriter.append(",");
        csvWriter.append("deadlineTask");
        csvWriter.append(",");
        csvWriter.append("author");
        csvWriter.append(",");
        csvWriter.append("taskDescription");
        csvWriter.append("\n");

        for (Task task : TaskTree.getTaskTree()) {
            csvWriter.append(task.taskToStringBuilderForCsv());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

        } catch (Exception e) {
            System.out.println("Не удалось записать данные в " + path);
            //throw new RuntimeException(e);
        } //id, dateOfAdding, timeOfAdding, deadlineTask, author, taskDescription
    }

    //загрузка из файла - в разработке - не окончен
    public static void csvReader() throws IOException {
        String pathToCsv = "A:\\GB\\Java\\Java_introduction\\sem4_OOP\\task.csv";
        File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
//            while () {
//                не успела закончить
//            }
            csvReader.close();
        }


    }
}
