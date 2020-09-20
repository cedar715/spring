package guru.svadhyaya.learnspring.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;
    private LocalDate dueData;

    private TaskStatus status;

    public Task(String name, String description, LocalDate dateCreated, LocalDate dueData) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueData = dueData;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueData() {
        return dueData;
    }

    public void setDueData(LocalDate dueData) {
        this.dueData = dueData;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dueData=" + dueData +
                ", status=" + status +
                '}';
    }
}
