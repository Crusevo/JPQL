package com.example.JPQL.Repositories;

import com.example.JPQL.Models.Project;
import com.example.JPQL.Models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    @Query
    List<User> findByName(String name);

    @Query
    List<User> findByLastName(String lastName);


}
