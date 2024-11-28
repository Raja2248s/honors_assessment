package com.example.honors_assesment.services;

import com.example.honors_assesment.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServices {

    private Map<String , User> users;

    @PostConstruct
    public void init(){
        users = new HashMap<>();
    }

    public String createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        users.put(user.getUserId(), user);
        return user.getUserId();
    }

    public List<User> getAllUsers(){
        return  new ArrayList<>(users.values());
    }

    public User getUserById(String id){
        return users.get(id);
    }

    public boolean updateUser(String id , User updatedUser){

        if(!users.containsKey(id)){
            return false;
        }
        updatedUser.setUserId(id);
        users.put(id , updatedUser);
        return true;
    }

    public boolean deleteUser(String id){
        return users.remove(id) != null;
    }

    public boolean existByNameAndDepartment(String name , String department){
        return users.values().stream().anyMatch(user -> user.getName().equalsIgnoreCase(name) && user.getDepartment().equalsIgnoreCase(department));
    }
}
