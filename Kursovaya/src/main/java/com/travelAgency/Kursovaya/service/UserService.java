package com.travelAgency.Kursovaya.service;


import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;


    public boolean saveUser(UserSystem user){
        UserSystem userFromBD = userRepository.findByUsername(user.getUsername());

        if(userFromBD!=null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

}
