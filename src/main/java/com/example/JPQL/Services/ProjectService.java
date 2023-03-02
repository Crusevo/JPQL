package com.example.JPQL.Services;

import com.example.JPQL.Models.Project;
import com.example.JPQL.Models.User;
import com.example.JPQL.Repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;



    public List<Project> findAll() {

        return projectRepo.findAll();

    }

    public Optional<Project> findById(Long id){

        return projectRepo.findById(id);


    }


    public Project save(Project project) {

        List<Project> projectByName = projectRepo.findByProjectName(project.getProjectName());
        List<Project> projectByNumber = projectRepo.findByProjectNumber(project.getProjectNumber());

        if (projectByName.isEmpty() && projectByNumber.isEmpty()){

            projectRepo.save(project);

        } else {

            System.out.println("Projekt jest już w bazie dnaych");

        }

        return project;
    }
}
