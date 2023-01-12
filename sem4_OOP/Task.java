package sem4_OOP;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Task implements Comparable<LocalDate>{
    private String id;
    private LocalDate dateOfAdding;
    private LocalTime timeOfAdding;
    private LocalDateTime deadlineTask;
    private String author;
    private String taskDescription;
    private static Integer countForId;

    static {
        countForId = TaskTree.getTaskTree().size();//0 изначально - менять при удалении и загрузке,очищении,
        //если TreeTask статич. то можно так TaskTree.getTaskTree().size() - брать размер
    }

    public Task(LocalDate dateOfAdding, LocalTime timeOfAdding, LocalDateTime deadlineTask, String author, String taskDescription) {

        this.id = String.format("T#%d",++countForId);
        this.dateOfAdding = dateOfAdding;
        this.timeOfAdding = timeOfAdding;
        this.deadlineTask = deadlineTask;
        this.author = author;
        this.taskDescription = taskDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(LocalDate dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public LocalTime getTimeOfAdding() {
        return timeOfAdding;
    }

    public void setTimeOfAdding(LocalTime timeOfAdding) {
        this.timeOfAdding = timeOfAdding;
    }

    public LocalDateTime getDeadlineTask() {
        return deadlineTask;
    }

    public void setDeadlineTask(LocalDateTime deadlineTask) {
        this.deadlineTask = deadlineTask;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(dateOfAdding, task.dateOfAdding) &&
                Objects.equals(timeOfAdding, task.timeOfAdding) && Objects.equals(deadlineTask, task.deadlineTask) &&
                Objects.equals(author, task.author) && Objects.equals(taskDescription, task.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfAdding, timeOfAdding, deadlineTask, author, taskDescription);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", Дата добавления=" + dateOfAdding +
                ", Время добавления=" + timeOfAdding +
                ", Дедлайн=" + deadlineTask +
                ", Автор='" + author + '\'' +
                ", Задача='" + taskDescription + '\'' +
                '}';
    }

    public String taskToStringBuilderForCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(',').append(dateOfAdding).append(',').append(timeOfAdding).append(',').append(deadlineTask)
                .append(',').append(author).append(',').append(taskDescription);
        return sb.toString();
    }

    @Override
    public int compareTo(LocalDate date) {
        LocalDate dateThis = LocalDate.from(this.deadlineTask);
        if (dateThis.isAfter(date)) {
            return 1;
        } else if (dateThis.isBefore(date))
            return -1;
        else
            return 0;
    }

}
