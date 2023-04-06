package net.guides.springboot2.crud.model;
import javax.persistence.*;

@Entity
@Table(name = "userlist")
public class Users {
    private long userId;
    private String username;

    public Users() {
    }
    public Users(String username) {
          this.username = username;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return userId;
    }
    public void setId(long userId) {
        this.userId = userId;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}