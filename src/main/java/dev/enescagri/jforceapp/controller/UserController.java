package dev.enescagri.jforceapp.controller;

import dev.enescagri.jforceapp.model.User;
import dev.enescagri.jforceapp.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User inventory){
        return userServiceImpl.createUser(inventory);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id, @RequestBody User userDetails){
        return new ResponseEntity<>(userServiceImpl.updateUser(id, userDetails), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        return userServiceImpl.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginReq) {
        String userName = loginReq.getUserName();
        String password = loginReq.getPassword();

        Optional<User> optionalUser = userServiceImpl.loginUser(userName, password);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
