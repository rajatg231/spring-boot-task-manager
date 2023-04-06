package net.guides.springboot2.crud.controller;
import net.guides.springboot2.crud.model.Users;
import net.guides.springboot2.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    //Get a list of all users
    @GetMapping("/users")
    public List<Users> getAllTasks() {
        return usersRepository.findAll();
    }
}