package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.UserSystem;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserSystem, Integer>{
    UserSystem findByUsername(String username);
    List<UserSystem> getAllByRoles(String role);
    UserSystem findById(Long id);

    default Boolean findExactPerson(String username) {
        return findByUsername(username) != null;
    }
}