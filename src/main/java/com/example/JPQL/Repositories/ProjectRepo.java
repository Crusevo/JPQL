package com.example.JPQL.Repositories;

import com.example.JPQL.Models.Project;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    @Query
    List<Project> findByProjectName(String name);

    @Query
    List<Project> findByProjectNumber(String projectNumber);




}
