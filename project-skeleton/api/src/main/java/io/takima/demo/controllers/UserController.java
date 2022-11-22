package io.takima.demo.controllers;

import io.takima.demo.UserDAO;
import io.takima.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("")
    public List<User> listUsers() {
        Iterable<User> it = userDAO.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(user -> users.add(user));
        return users ;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDAO.deleteById(id);
    }

    @PostMapping("")
    public void adduser(@RequestBody User user) {
        userDAO.save(user);
    }
}
