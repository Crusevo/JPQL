package com.example.JPQL.Services;


import com.example.JPQL.Models.Project;
import com.example.JPQL.Repositories.ProjectRepo;
import com.example.JPQL.Repositories.UserRepo;
import com.example.JPQL.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProjectRepo projectRepo;



    public List<User> findByName(String name){

        return userRepo.findByName(name);

    }

    public List<User> findAll(){

        return userRepo.findAll();

    }

    public Optional<User> findById(long id) {

        return userRepo.findById(id);


    }


    public User save(User user) {

        List<User> userByName = userRepo.findByName(user.getName());
        List<User> byLastName = userRepo.findByLastName(user.getLastName());

        boolean nameIsEmpty = userByName.isEmpty();
        boolean lastNameIsEmpty = byLastName.isEmpty();


        if (nameIsEmpty == false && lastNameIsEmpty ==false){

            System.out.println("Użytkownik jest już w bazie dnaych");

        } else if (nameIsEmpty == true && lastNameIsEmpty ==false){

            userRepo.save(user);

        } else if (nameIsEmpty == false && lastNameIsEmpty ==true) {

            userRepo.save(user);

        } else if (nameIsEmpty == true && lastNameIsEmpty ==true) {

            userRepo.save(user);

        }

        return user;

    }


    public User update(User user,Long userId, Long projectId) {


        Project projectFromDatabase = projectRepo.findById(projectId).orElseThrow();

        User updatedtedUser = userRepo.findById(userId).orElseThrow();

        user.setId(updatedtedUser.getId());
        user.setName(updatedtedUser.getName());
        user.setLastName(updatedtedUser.getLastName());

        List<Project> projectsUpdatedUser = updatedtedUser.getProjects();

        projectsUpdatedUser.add(projectFromDatabase);

        user.setProjects(projectsUpdatedUser);

        return userRepo.save(user);

    }
}
