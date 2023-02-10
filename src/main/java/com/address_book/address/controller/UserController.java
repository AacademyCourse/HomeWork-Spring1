package com.address_book.address.controller;

import com.address_book.address.entity.User;
import com.address_book.address.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(path = "/{id}/modify")
    public User modifyUser(@PathVariable Long id, @RequestBody User user) {
        return userService.modifyUser(id, user);
    }

    @DeleteMapping(path = "/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return String.format("User with %s id is deleted", id);
    }
}
