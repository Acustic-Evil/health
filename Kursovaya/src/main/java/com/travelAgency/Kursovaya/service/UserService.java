package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Admins;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public Admins findUserById(Long userId) {
        Optional<Admins> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Admins());
    }

    public Admins findUserByLogin(String login){
        return userRepository.findByUsername(login);
    }

    public boolean saveUser(Admins user){
        Admins userFromBD = userRepository.findByUsername(user.getUsername());

        if(userFromBD!=null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }
    public boolean deleteUser(Long ID){
        if(userRepository.findById(ID).isPresent()){
        userRepository.deleteById(ID);
            return true;
        }
        return false;
    }

    public Admins findByLogin(String login){
        return userRepository.findByUsername(login);
    }
    public void ListAllUsers(){
        int len= userRepository.findAll().size();
        for(int i = 0; i<len; i++){
            System.out.println(userRepository.findAll().get(i).getUsername()+" "+userRepository.findAll().get(i).getPassword());
        }
    }
    public void DeleteAllUsers(Boolean uShure){
        if(uShure){
            int len= userRepository.findAll().size();
            for(int i = 0; i<len; i++){
                userRepository.deleteById(userRepository.findAll().get(i).getId_user());
            }
        }
    }
    public void deleteByLogin(String login){
        Admins userSystem = userRepository.findByUsername(login);
        userRepository.deleteById(userSystem.getId_user());
    }
    public List<Admins> getAllUsers(){
        return userRepository.findAll();
    }

}
