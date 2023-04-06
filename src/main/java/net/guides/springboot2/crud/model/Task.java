package net.guides.springboot2.crud.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    private long taskId;
    private String taskName;
    private boolean status;
    private String username;
 
    public Task() {  
    }
    public Task(String taskName, boolean status, String username) {
         this.taskName = taskName;
         this.status = status;
         this.username=username;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return taskId;
    }
    public void setId(long taskId) {
        this.taskId = taskId;
    }
 
    @Column(name = "task_name", nullable = false)
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Column(name = "status", nullable = false,columnDefinition = "TINYINT(1)")
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status ;
    }
 
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public String setUsername(String username) {
        return this.username = username;
    }
}