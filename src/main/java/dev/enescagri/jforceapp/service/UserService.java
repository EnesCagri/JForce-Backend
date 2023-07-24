package dev.enescagri.jforceapp.service;

import dev.enescagri.jforceapp.model.Inventory;
import dev.enescagri.jforceapp.model.User;
import dev.enescagri.jforceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


    public Optional<User> getUser(String userName, String password){
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    public Optional<User> updateUser(Long id, User employeeDetails){
        Optional<User> userOptional = getUserById(id);

        if (userOptional.isPresent()) {
            User inventory = userOptional.get();
            inventory.setUserName(employeeDetails.getUserName());
            inventory.setPassword(employeeDetails.getPassword());
            inventory.setRole(employeeDetails.getRole());


            userRepository.save(inventory);
            return Optional.of(inventory);
        }

        return Optional.empty();
    }

    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id){
        Optional<User> userOptional = getUserById(id);
        Map<String, Boolean> response = new HashMap<>();
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            userRepository.delete(user);

            response.put("deleted", Boolean.TRUE);

            return ResponseEntity.ok(response);
        }
        response.put("deleted", Boolean.FALSE);

        return ResponseEntity.notFound().build();
    }

    public Optional<User> loginUser(String userName, String password) {

        return userRepository.findByUserNameAndPassword(userName, password);
    }
}
