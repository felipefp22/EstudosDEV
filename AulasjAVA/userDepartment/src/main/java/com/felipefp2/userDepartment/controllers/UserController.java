package com.felipefp2.userDepartment.controllers;

import com.felipefp2.userDepartment.entities.User;
import com.felipefp2.userDepartment.repositories.UserRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepositoriy repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value= "/teste")
    public String xama() {
        return "Olá Mundo";
    }

    @GetMapping(value = "/{id}")
    public User findBy(@PathVariable long id){
        User result = repository.findById(id).get();
        return result;
    }
//    @GetMapping(value = "/{name}")
//    public User findBy(@PathVariable String name){
//        User result = 2;
//        return result;
//    }

    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }
//    @PutMapping(value = "/{id}")
//    public User modify(RequestBody User user){
//        User result = repository.;
//        return result;
//    }

}
