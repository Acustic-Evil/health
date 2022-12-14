package com.travelAgency.Kursovaya.service;


import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public List<UserSystem> getAll(){return userRepository.findAll();}


    public List<UserSystem> getAllByRole(String role){return userRepository.getAllByRoles(role);}
    public boolean saveUser(UserSystem user){
        UserSystem userFromBD = userRepository.findByUsername(user.getUsername());

        if(userFromBD!=null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

}
