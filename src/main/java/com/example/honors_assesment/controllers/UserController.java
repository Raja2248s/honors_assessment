package com.example.honors_assesment.controllers;

import com.example.honors_assesment.models.User;
import com.example.honors_assesment.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        if(userService.existByNameAndDepartment(user.getName() , user.getDepartment())){
            return ResponseEntity.badRequest().body("User with the same nae and Department");
        }
        String userId = userService.createUser(user);
        return ResponseEntity.ok(userId);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        if(!userService.deleteUser(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id , @RequestBody User user){
        if(!userService.updateUser(id , user)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Usser updates Succesfully");
    }

}
