package com.example.JPQL.Controllers;

import com.example.JPQL.Models.Project;
import com.example.JPQL.Models.User;
import com.example.JPQL.Services.ProjectService;
import com.example.JPQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping("/projects/")
    public List<Project> findAll(){

       return projectService.findAll();

    }

    @GetMapping("/projects/{id}")
    public Optional<Project> findById(@PathVariable ("id") Long id){


        return projectService.findById(id);

    }



    @PostMapping("/projects/")
    public Project save( @RequestBody Project project ){

        return projectService.save(project);

    }


}
