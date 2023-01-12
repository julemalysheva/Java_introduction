package sem4_OOP;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

//компонента хранения задач - можно настроить компаратор для хранения/сортировки по дедлайну
public class TaskTree  {
    private static TreeSet<Task> taskTree;

    static {//множество задач сортируется по срочности
        taskTree = new TreeSet<>(Comparator.comparing(Task::getDeadlineTask));//Comparator<Task>
    }

    public static TreeSet<Task> getTaskTree() {
        return taskTree;
    }

    public static void addTask(Task task) {
        taskTree.add(task);
    }
    public static void clearTaskTree(){
        taskTree.clear();
    }
    public static void removeTaskByID(String id){
        taskTree.removeIf(task -> task.getId().equals(id));
    }

    public static void printTask(){
        if (taskTree.size()>0) {
            for (Task task : taskTree) {
                System.out.println(task);
            }
        } else System.out.println("Задачи не обнаружены");
    }
    //поиск по id для изменений
    public static Task searchById(String id){
        for (Task task:taskTree) {
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public static void printTaskBeforeDate(LocalDate date){
        for (Task task : taskTree) {
            if (task.compareTo(date) <= 0)
                System.out.println(task);
        }

    }

}
