package com.example.JPQL.Controllers;

import com.example.JPQL.Models.Project;
import com.example.JPQL.Models.User;
import com.example.JPQL.Services.ProjectService;
import com.example.JPQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectController projectController;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{id}")
    public Optional<User> findById(@PathVariable ("id") Long id){

        return userService.findById(id);

    }



    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/")
    public List<User> findAll(){

        return userService.findAll();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users/")
    public User save(@RequestBody User user){


        return userService.save(user);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/users/{userId}/{projectId}/")
    public User update(@PathVariable ("userId") Long userId,@PathVariable ("projectId") Long projectId, @RequestBody User user){



        return userService.update(user,userId,projectId);


    }












}
