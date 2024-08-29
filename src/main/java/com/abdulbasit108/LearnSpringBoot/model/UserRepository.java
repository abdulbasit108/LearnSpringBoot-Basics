package com.abdulbasit108.LearnSpringBoot.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.email LIKE %:domain")
    List<User> findByDomain(@Param("domain") String domain);
}
