package net.guides.springboot2.crud.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Task;
import net.guides.springboot2.crud.repository.TaskRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

// Get all task user-wise
    @GetMapping("/username/{username}/tasks")
    public List<Task> getAllTasks(@PathVariable(value = "username") String username) {
        return taskRepository.findByUsername(username);
   
}

// Get a single task by id user-wise
    @GetMapping("/username/{username}/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId, @PathVariable(value = "username") String username)
        throws ResourceNotFoundException {
            Task task = taskRepository.findById(taskId)
          .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));
        return ResponseEntity.ok().body(task);
    }

// Create a task user-wise
    @PostMapping("/username/{username}/tasks")
    public ResponseEntity<Task> createTask(@PathVariable(value = "username") String username,@Valid @RequestBody Task task) {
        task.setUsername(username);      
        Task data = taskRepository.save(task);
        return ResponseEntity.ok(data);
    }

// Update a task user-wise by id
    @PutMapping("/username/{username}/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "username") String username,@PathVariable(value = "id") Long taskId,
         @Valid @RequestBody Task taskDetails) throws ResourceNotFoundException {
            Task task = taskRepository.findById(taskId)
        .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));
        task.setUsername(username);
        task.setStatus(taskDetails.getStatus());
        task.setTaskName(taskDetails.getTaskName());
        final Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

// Delete a task by id
    @DeleteMapping("/tasks/{id}")
    public Map<String, Boolean> deleteTask(@PathVariable(value = "id") Long taskId)
         throws ResourceNotFoundException {
            Task task = taskRepository.findById(taskId)
       .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

       taskRepository.delete(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}