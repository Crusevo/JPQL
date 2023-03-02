package com.example.JPQL.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.imageio.ImageWriter;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String lastName;

    @OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
    public List<Project> projects;




}
