package net.guides.springboot2.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.guides.springboot2.crud.model.Task;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    public List<Task> findByUsername(String username);

}